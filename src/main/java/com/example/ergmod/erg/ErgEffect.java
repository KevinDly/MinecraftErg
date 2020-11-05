package com.example.ergmod.erg;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ErgEffect extends ForgeRegistryEntry<ErgEffect> {
	/*Calculates additional damage that is dealt by item with erg level.
	 * 
	 */
	
	@Nullable
	protected String name;

	public float calcDamageByCreature(Erg ergType, int level) {
		// TODO Auto-generated method stub
		return 0.0f;
	}
	
	public String getName(){
		return name;
	}
}
