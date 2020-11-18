package com.example.ergmod.erg;

import com.example.ergmod.utils.Constants;

public class DamageErgEffect extends ErgEffect {
	
	//Determines which damage modifier to use based on level and type of erg
	public DamageErgEffect(){
	}
	
	@Override
	public float calcDamageByCreature(Erg ergType, int level){
		if(ergType instanceof SwordErg)
			return .1f * level;
		return 0.0f;
	}
	
	@Override
	public float getDisplayNumber(Erg ergType, int level){
		return calcDamageByCreature(ergType, level);
	}
}
