package com.example.ergmod.events;

import net.minecraftforge.fml.common.Mod;

import com.example.ergmod.ErgMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeHooks;

/*Class that handles new events for the mod.*/

@Mod.EventBusSubscriber(modid = ErgMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ModClientEvents {
	
	/*Event modifer that adjusts the amount of time added towards the swing cooldown*/
	@SubscribeEvent
	public static void onPlayerPreTick(PlayerEntity player){
		
	}
}
