package com.example.ergmod.erg;


public class DamageErgEffect extends ErgEffect {
	
	//Determines which damage modifier to use based on level and type of erg
	@Override
	public float calcDamageByCreature(Erg ergType, int level){
		if(ergType instanceof SwordErg)
			return .1f * level;
		return 0.0f;
	}
}
