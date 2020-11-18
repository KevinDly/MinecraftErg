package com.example.ergmod.erg;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;

public class ErgEffectRegistry {
	static {
		init();
	}
	
	public static IForgeRegistry<ErgEffect> ERGEFFECT = RegistryManager.ACTIVE.getRegistry(ErgEffect.class);
	
	private static void init(){
		new RegistryBuilder<ErgEffect>()
			.setName(new ResourceLocation("erg", "ergeffect"))
			.setType(ErgEffect.class)
			.setDefaultKey(new ResourceLocation("erg", "empty"))
			.create();
	}
}
