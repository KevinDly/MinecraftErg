package com.example.ergmod.commands;


import com.example.ergmod.erg.ErgEffectRegistryEvent;

import com.example.ergmod.utils.Constants;
import com.mojang.brigadier.CommandDispatcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.TranslationTextComponent;


/*
 * Simple Command that lets me test certain functions ingame.
 */
public class TestCommand {
	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal(Constants.COMMAND_TEST).requires((p_198727_0_) ->{
			return p_198727_0_.hasPermissionLevel(2);
		}).executes((p_198727_0_) -> {
			LOGGER.info(ErgEffectRegistryEvent.DAMAGEEFFECT.get().getName());
			LOGGER.info(ErgEffectRegistryEvent.DAMAGEEFFECT.getId().getNamespace());
			LOGGER.info(ErgEffectRegistryEvent.DAMAGEEFFECT.getId().getPath());
			LOGGER.info(Enchantments.AQUA_AFFINITY.getName());
			IFormattableTextComponent aqua = new TranslationTextComponent(Enchantments.AQUA_AFFINITY.getName());
			LOGGER.info(aqua.getUnformattedComponentText());
			IFormattableTextComponent iformattabletextcomponent = new TranslationTextComponent(ErgEffectRegistryEvent.DAMAGEEFFECT.get().getName());
			LOGGER.info(iformattabletextcomponent.getUnformattedComponentText());
			
			return 1;
		}));
	}
}
