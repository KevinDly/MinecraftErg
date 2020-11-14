package com.example.ergmod.itemhelpers;

import java.util.LinkedList;

import com.example.ergmod.erg.Erg;
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
import net.minecraftforge.fml.common.registry.GameRegistry;

//TODO: Use this class where we handle adding Erg to a weapon
public class ItemHelper {
	
	//Check item for erg tag, add if it doesnt, don't add if it does
	/*
	 * Method that returns the level of erg, returns 0 if no erg exists.
	 */
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
			addErg(item, tag);
			return;
		}
		addErgLevel(item, tag);
		return;
	}
	
	//Adds erg tag to item nbt
	public static void addErg(ItemStack item, CompoundNBT tag) {
		//Creates tag that initializes the Erg.
		tag.putInt(Constants.NBT_ERG, Constants.MIN_ERG);
		
		//Checks the typeof weapon
		Item itemType = item.getItem();
		
		if(itemType instanceof SwordItem) {
			Erg erg = ErgRegistryEvent.SWORDERG.get();
			LinkedList<Pair<String, Integer>> effects = erg.getEffectSet();
			CompoundNBT nbt = new CompoundNBT();
			tag.put(Constants.NBT_ERGEFFECT, new CompoundNBT());
			for(int i = 0; i < effects.size(); i++){
				Pair<String, Integer> effect = effects.get(i);
				int level = effect.getSecond();
				String id = effect.getFirst();
				if(level <= Constants.MIN_ERG) {
					//TODO: Change "0" to actual value of function
					nbt.putInt(id, 0);
				}
			}
			tag.put(Constants.NBT_ERGEFFECT, nbt);
		}
	}
	
	//Updates pre-existing erg tag on an item nbt.
	public static void addErgLevel(ItemStack item, CompoundNBT tag) {
		int newLevel = tag.getInt(Constants.NBT_ERG) + 1;
		tag.putInt(Constants.NBT_ERG, newLevel);
		
		CompoundNBT nbt = tag.getCompound(Constants.NBT_ERGEFFECT);
		Item itemType = item.getItem();
		
		if(itemType instanceof SwordItem) {
			Erg erg = ErgRegistryEvent.SWORDERG.get();
			LinkedList<Pair<String, Integer>> effects = erg.getEffectSet();
			
			for(int i = 0; i < effects.size(); i++){
				Pair<String, Integer> effect = effects.get(i);
				int level = effect.getSecond();
				String id = effect.getFirst();
				if(level <= newLevel) {
					if(nbt.contains(id)){
						//TODO: Change "0" to actual value of function
						//TODO: Change so that it checks for the existing strings.
						nbt.putInt(id, 0);
					}
				}
			}
		}
		return;
	}
}
