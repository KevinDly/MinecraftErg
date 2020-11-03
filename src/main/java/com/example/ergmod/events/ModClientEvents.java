package com.example.ergmod.events;

import net.minecraftforge.fml.common.Mod;

import com.example.ergmod.ErgMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

/*Class that handles new events for the mod.*/

@Mod.EventBusSubscriber(modid = ErgMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ModClientEvents {
	
	/*Event modifer that adjusts the amount of time added towards the swing cooldown*/
	@SubscribeEvent
	public static void onErgAttack(LivingAttackEvent event){
		LivingEntity player = event.getEntityLiving();
		Item item = player.getHeldItemMainhand().getItem();
		
		//TODO: Change to check item for erg enhancement
		if(true) {
			//Check item level
			//Check erg type
			//Add additional bonus damage based on level calculation
		}
	}
}
