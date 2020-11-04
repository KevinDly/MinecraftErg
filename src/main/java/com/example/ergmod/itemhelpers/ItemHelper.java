package com.example.ergmod.itemhelpers;

import com.example.ergmod.erg.Erg;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

//TODO: Implement this class with appropriate calls to ItemStack.class
public class ItemHelper {
	
	//Check item for erg tag, add if it doesnt, don't add if it does
	//TODO: Erg.getKey should return a payload of stuff?
	public void checkErg(ItemStack item, Erg erg, int level) {
		//Creates tag for item if one hasn't already been created.
		CompoundNBT tag = item.getOrCreateTag();
		
		//TODO: Understand what .contains does and change 0 to appropriate number
		//Should be 9 so we can store a list of compounds (10)
		if(!tag.contains("Erg", 9)){
			tag.put("Erg", new ListNBT());
		}
		
		ListNBT listnbt = tag.getList("Erg", 10);
		CompoundNBT compoundNBT = new CompoundNBT();
		
		//if item has erg
			//add checks for erg level
		//otherwise
			//add the erg tag on to it
		return;
	}
	
	//Adds erg tag to item nbt
	public void addErg(ItemStack item,Erg erg, int level) {
		//
		return;
	}
	
	//Updates pre-existing erg tag on an item nbt.
	public void addErgLevel(ItemStack item,Erg erg, int level) {
		return;
	}
}
