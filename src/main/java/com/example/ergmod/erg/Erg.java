package com.example.ergmod.erg;

import java.util.LinkedList;
import javax.annotation.Nullable;


import com.example.ergmod.utils.Constants;
import com.example.ergmod.utils.Pair;

import net.minecraftforge.registries.ForgeRegistryEntry;
import java.util.Map;

//TODO: Have this call ErgEffect somewhere
public abstract class Erg extends ForgeRegistryEntry<Erg>{
	
	protected LinkedList<Pair<String, Integer>> effects;
	
	@Nullable
	protected String name;
	
	/*TODO: Add erg to registry?*/
	protected Erg(){
		this.name = "Erg";
	}
	
	/*Returns level of erg*/
	public int getMinLevel(){
		return Constants.MIN_ERG;
	}
	
	public int getMaxLevel(){
		return Constants.MAX_ERG;
	}
	
	public LinkedList<Pair<String, Integer>> getEffectSet(){
		return effects;
	}
	
	/*Adds an effect and the level that the effect should be unlocked at*/
	public void addEffectSet(String effect, int level){
		effects.add(new Pair<String, Integer>(effect, new Integer(level)));
	}
	

	public String getName(){
		return name;
	}
}
