package com.example.ergmod.erg;

import javax.annotation.Nullable;

import com.example.ergmod.utils.Constants;

import net.minecraft.entity.CreatureAttribute;
import net.minecraftforge.registries.ForgeRegistryEntry;
import java.util.HashMap;

//TODO: Have this call ErgEffect somewhere
public abstract class Erg extends ForgeRegistryEntry<Erg>{
	
	protected int level;
	
	@Nullable
	protected String name;
	
	/*TODO: Add erg to registry?*/
	protected Erg(int level){
		this.name = "Erg";
		this.level = level;
	}
	
	/*Returns level of erg*/
	public int getMinLevel(){
		return Constants.MIN_ERG;
	}
	
	public int getMaxLevel(){
		return Constants.MAX_ERG;
	}
	
	public void getEffectSet(){
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return level;
	}
	
	public String getName(){
		return name;
	}
}
