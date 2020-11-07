package com.example.ergmod.erg;

import com.example.ergmod.utils.Constants;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class ErgEffectRegistryEvent {
	public static final DeferredRegister<ErgEffect> ERG_EFFECT = DeferredRegister.create(ErgEffectRegistry.ERGEFFECT, Constants.MOD_ID);
	
	/*TODO: Add the additional types*/
	//Basically add more effects later on.
	public static final RegistryObject<ErgEffect> DAMAGEEFFECT = ERG_EFFECT.register(Constants.DAMAGE_INCREASE, DamageErgEffect::new);
	public static void register(IEventBus eventBus) { ERG_EFFECT.register(eventBus); }

}
