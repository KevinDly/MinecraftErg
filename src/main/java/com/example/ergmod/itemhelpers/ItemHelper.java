package com.example.ergmod.itemhelpers;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.ergmod.erg.Erg;
import com.example.ergmod.erg.ErgEffect;
import com.example.ergmod.erg.ErgEffectRegistry;
import com.example.ergmod.erg.ErgEffectRegistryEvent;
import com.example.ergmod.erg.ErgRegistryEvent;
import com.example.ergmod.utils.Constants;
import com.example.ergmod.utils.Pair;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;

//TODO: Use this class where we handle adding Erg to a weapon
public class ItemHelper {

	//Check item for erg tag, add if it doesnt, don't add if it does
	/*
	 * Method that returns the level of erg, returns 0 if no erg exists.
	 */
    private static final Logger LOGGER = LogManager.getLogger();

	public static int checkLevel(ItemStack item){
		//TODO: Check if redundant (getInt might return 0 anyways);
		CompoundNBT tag = item.getOrCreateTag();
		if(tag.contains(Constants.NBT_ERG)){
			return tag.getInt(Constants.NBT_ERG);
		}
		return 0;
	}
	public static void checkErg(ItemStack item) {
		//Creates tag for item if one hasn't already been created.
		CompoundNBT tag = item.getOrCreateTag();
		int level = checkLevel(item);
		//TODO: Understand what .contains does and change 0 to appropriate number
		//Should be 9 so we can store a list of compounds (10)
		//TODO: put tag.put("Erg", new ListNBT()); where erg is actually meant to be.
		if(level == 0){
			LOGGER.info("Adding new erg to item");
			addErg(item, tag);
			return;
		}
		LOGGER.info("Adding level to existing erg");
		addErgLevel(item, tag);
		return;
	}
	
	//Adds erg tag to item nbt
	public static void addErg(ItemStack item, CompoundNBT tag) {
		//Creates tag that initializes the Erg.
		tag.putInt(Constants.NBT_ERG, Constants.MIN_ERG);
		
		//Checks the typeof weapon
		Item itemType = item.getItem();
		
		//Checks for all instances of possible erg.
		//TODO: Change this into some sort of function that takes a lambda.
		LOGGER.info("Checking instance of item");
		if(itemType instanceof SwordItem) {
			//TODO: Refactor this into a function before it gets too annoying
			Erg erg = ErgRegistryEvent.SWORDERG.get();
			LinkedList<Pair<String, Integer>> effects = erg.getEffectSet();
			ListNBT nbt = new ListNBT();
			
			LOGGER.info("Checking erg effects.");
			for(int i = 0; i < effects.size(); i++){
				Pair<String, Integer> effectPair = effects.get(i);
				int level = effectPair.getSecond();
				String id = effectPair.getFirst();
				
				LOGGER.info("Attempting to get effect from registry.");
				try{		
					LOGGER.info("Attempting to grab effect");
					
					ErgEffect effect = ErgEffectRegistry.ERGEFFECT.getValue(new ResourceLocation(Constants.MOD_ID, id));
					
					LOGGER.info("Adding erg effect onto NBT L.");
					if(level <= Constants.MIN_ERG) {
						//TODO: make putfloat more flexible for other n
						//TODO: put strings into Constants.java
						//TODO: Might want to change representation again of Lists and Compounds
						CompoundNBT effectnbt = new CompoundNBT();
						effectnbt.putString("effect", id);
						effectnbt.putFloat("multiplier", effect.getDisplayNumber(erg, level));
						nbt.add(effectnbt);
					}
				}
				catch(Error error){
					LOGGER.error(error);
					LOGGER.info(error);
				}
			}
			tag.put(Constants.NBT_ERGEFFECT, nbt);
		}
	}
	
	//Updates pre-existing erg tag on an item nbt.
	public static void addErgLevel(ItemStack item, CompoundNBT tag) {
		int newLevel = tag.getInt(Constants.NBT_ERG) + 1;
		tag.putInt(Constants.NBT_ERG, newLevel);
		
		ListNBT nbt = tag.getList(Constants.NBT_ERGEFFECT, 10); 
		Item itemType = item.getItem();
		
		//Checks for all instances of possible erg
		//TODO: Change this into some sort of function that takes a lambda.
		LOGGER.info("Checking instance of item");
		if(itemType instanceof SwordItem) {
			
			//TODO: Refactor this into a function before it gets too annoying
			Erg erg = ErgRegistryEvent.SWORDERG.get();
			LinkedList<Pair<String, Integer>> effects = erg.getEffectSet();
			
			LOGGER.info("Checking erg effects.");
			for(int i = 0; i < effects.size(); i++){
				Pair<String, Integer> effectPair = effects.get(i);
				int level = effectPair.getSecond();
				String id = effectPair.getFirst();
				
				LOGGER.info("Attempting to get effect from registry.");
				try{
					//TODO: Check if this is the best way to get the correct value?
					ErgEffect effect = ErgEffectRegistry.ERGEFFECT.getValue(new ResourceLocation(Constants.MOD_ID, id));
					
					LOGGER.info("Adding or updating effect onto NBT Compound.");
					if(level <= newLevel) {
						for(int j = 0; j < nbt.size(); j++){
							CompoundNBT effectnbt = nbt.getCompound(j);
							
							//Check through all compounds in the list
							if(effectnbt.getString("effect").equals(id)) {
								//If effect found, update then break.
								effectnbt.putFloat("multiplier", effect.getDisplayNumber(erg, level));
								break;
							}
							
							if(j == (nbt.size() - 1)) {
								//If we are at last index and we failed above check
								CompoundNBT neweffectnbt = new CompoundNBT();
								neweffectnbt.putString("effect", id);
								neweffectnbt.putFloat("multiplier", effect.getDisplayNumber(erg, level));
								nbt.add(neweffectnbt);
							}
						}
					}
				}
				catch(Error error){
					LOGGER.error(error);
					LOGGER.info(error);
				}
			}
		}
		return;
	}
}
