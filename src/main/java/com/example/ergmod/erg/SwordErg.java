package com.example.ergmod.erg;

import net.minecraft.entity.CreatureAttribute;

public class SwordErg extends Erg {

	/*TODO: Add this method somehow on an hook to PlayerEntity and MobEntity methods:
	 * attackEtntityAsMob(Entity) (MobEntity)
	 * attackTargetEntityWithCurrentItem(Entity) (PlayerEntity)
	 */
	@Override
	//Every level should add .1f amount of damage
	public float calcDamageByCreature(int level, CreatureAttribute creatureType) {
		// TODO Auto-generated method stub
		return level * 0.1f;
	}
	
}
