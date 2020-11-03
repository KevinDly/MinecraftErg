package com.example.ergmod.erg;

import com.example.ergmod.utils.Constants;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ErgRegistryEvent {
	public static final DeferredRegister<Erg> ERG = DeferredRegister.create(ErgRegistry.ERG, Constants.MOD_ID);
	
	/*TODO: Add the additional types*/
	
	public static void register(IEventBus eventBus) { ERG.register(eventBus); }
}
