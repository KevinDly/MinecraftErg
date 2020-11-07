package com.example.ergmod.erg;

import com.example.ergmod.utils.Constants;

import net.minecraft.entity.CreatureAttribute;

public class SwordErg extends Erg {
	//TODO: Add method that returns set of effects this erg should have.
	//TODO: Might need to initialize this (SwordErg) somewhere?
	public SwordErg() {
		super();
		// TODO Auto-generated constructor stub
		this.addEffectSet(Constants.DAMAGE_INCREASE, 1);
	}
}
