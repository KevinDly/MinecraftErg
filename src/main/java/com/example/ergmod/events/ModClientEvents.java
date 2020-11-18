package com.example.ergmod.events;

import net.minecraftforge.fml.common.Mod;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.ergmod.ErgMod;
import com.example.ergmod.commands.ErgCommand;
import com.example.ergmod.commands.TestCommand;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import com.example.ergmod.itemhelpers.ItemHelper;
import com.example.ergmod.utils.Constants;
/*Class that handles new events for the mod.*/
import com.example.ergmod.erg.*;
@Mod.EventBusSubscriber(modid = ErgMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ModClientEvents {
    private static final Logger LOGGER = LogManager.getLogger();
    
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
	
	/*Event that handles adding new commands*/
	@SubscribeEvent
	public static void addCommand(RegisterCommandsEvent event){
		ErgCommand.register(event.getDispatcher());
		TestCommand.register(event.getDispatcher());
	}
	//TODO: Add this class with appropriate call to tooltip event.
	//Need to use: net.minecraftforge.event.ForgeEventFactory.onItemTooltip(this, playerIn, list, advanced);
	//TODO: Add the event into the parameters.
	@SubscribeEvent
	public static void displayToolTip(ItemTooltipEvent event){
		ItemStack item = event.getItemStack();
		CompoundNBT nbt = item.getOrCreateTag();
		List<ITextComponent> list = event.getToolTip();
	
		//TODO: Remove logging info
		LOGGER.info("Length of ITextComponent list is: " + list.size());
		LOGGER.info(list.toString());
		//TODO: Use flag to determine if erg is on or not.
		LOGGER.info("Checking for erg");
		if(nbt.contains(Constants.NBT_ERG)){
			LOGGER.info("Applying tooltips");
			//TODO: Display the actual erg level
			//TODO: Add space between the last tag using StringTextComponent
			//Grabs the list of effects
			ListNBT effects = nbt.getList(Constants.NBT_ERGEFFECT, 10);
			int length = effects.size();
			
			//TODO: Add erg level to list.
			IFormattableTextComponent ergiftc = new TranslationTextComponent("erg.erg.name");
			ergiftc.func_240702_b_(" " + String.valueOf(nbt.getInt(Constants.NBT_ERG)));
			list.add(ergiftc);
			
			//Iterate through the list of effect compounds available.
			for(int i = 0; i < length; i++) {
				CompoundNBT effectnbt = effects.getCompound(i);
				String id = effectnbt.getString("effect");
				
				ErgEffect effect = ErgEffectRegistry.ERGEFFECT.getValue(new ResourceLocation(Constants.MOD_ID, id));
				IFormattableTextComponent iftc = new TranslationTextComponent(effect.getName());
				
				//TODO: Make more generalizable than float
				iftc.func_240702_b_(" " + String.valueOf(effectnbt.getFloat("multiplier")));
				list.add(iftc);
				LOGGER.info("Successfully applied tooltip");
			}
		}
		return;
	}
}
