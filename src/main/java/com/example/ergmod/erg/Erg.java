package com.example.ergmod.erg;

import javax.annotation.Nullable;

import com.example.ergmod.utils.Constants;

import net.minecraft.entity.CreatureAttribute;
import net.minecraftforge.registries.ForgeRegistryEntry;


public abstract class Erg extends ForgeRegistryEntry<Erg>{
	
	@Nullable
	protected String name;
	
	/*TODO: Add erg to registry?*/
	protected Erg(){
		
	}
	
	/*Returns level of erg*/
	public int getMinLevel(){
		return Constants.MIN_ERG;
	}
	
	public int getMaxLevel(){
		return Constants.MAX_ERG;
	}
	
	/*Calculates additional damage that is dealt by item with erg level.
	 * 
	 */
	public float calcDamageByCreature(int level, CreatureAttribute creatureType){
		return 0.0f;
	}
	
}
