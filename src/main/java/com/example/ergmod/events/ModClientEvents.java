package com.example.ergmod.events;

import net.minecraftforge.fml.common.Mod;

import com.example.ergmod.ErgMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.example.ergmod.itemhelpers.ItemHelper;
/*Class that handles new events for the mod.*/
import com.example.ergmod.erg.*;
@Mod.EventBusSubscriber(modid = ErgMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ModClientEvents {
	
	/*Event modifier that adjusts the amount of time added towards the swing cooldown*/
	@SubscribeEvent
	public static void onErgAttack(LivingHurtEvent event){
		LivingEntity player = event.getEntityLiving();
		ItemStack itemStack = player.getHeldItemMainhand();
		Item item = itemStack.getItem();
		int level = ItemHelper.checkLevel(itemStack);
		//TODO: Change to check item for erg enhancement
		if(level != 0) {
			//TODO: Make this if statement into a helper function somehow
			Erg erg = null;
			if(item instanceof SwordItem) {
				float damage = event.getAmount();
				erg = ErgRegistryEvent.SWORDERG.get();
				float ergModifier = ErgEffectRegistryEvent.DAMAGEEFFECT.get().calcDamageByCreature(erg, level);
				event.setAmount(damage + (damage * ergModifier));
			}
		}
	}
	
	//TODO: Add this class with appropriate call to tooltip event.
	//Need to use: net.minecraftforge.event.ForgeEventFactory.onItemTooltip(this, playerIn, list, advanced);
	//TODO: Add the event into the parameters.
	@SubscribeEvent
	public static void displayToolTip(){
		
	}
}
