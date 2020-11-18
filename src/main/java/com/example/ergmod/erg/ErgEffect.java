package com.example.ergmod.erg;

import javax.annotation.Nullable;

import com.example.ergmod.utils.Constants;

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
	
	protected ErgEffect(){
	}

	public float calcDamageByCreature(Erg ergType, int level) {
		// TODO Auto-generated method stub
		return 0.0f;
	}
	
	protected String getDefaultTranslationKey() {
		if(this.name == null) {
			this.name = Util.makeTranslationKey(Constants.NBT_ERGEFFECT, ErgEffectRegistry.ERGEFFECT.getKey(this));
		}
		
		return this.name;
	}
	
	public String getName(){
		return this.getDefaultTranslationKey();
	}
	
	//Returns the number that should be displayed on tooltip, dependent on the effect.
	public float getDisplayNumber(Erg ergType, int level) {
		
		return 0.0f;
	}
}
