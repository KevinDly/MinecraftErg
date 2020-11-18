package com.example.ergmod.erg;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;

/*Credit to "Dark Drizzs" for tutorial https://www.youtube.com/watch?v=4vurP-wvn7Y*/
public class ErgRegistry {
	static {
		init();
	}
	
	public static IForgeRegistry<Erg> ERG = RegistryManager.ACTIVE.getRegistry(Erg.class);
	
	private static void init(){
		new RegistryBuilder<Erg>()
			.setName(new ResourceLocation("erg", "erg"))
			.setType(Erg.class)
			.setDefaultKey(new ResourceLocation("erg", "empty"))
			.create();
	}
}
