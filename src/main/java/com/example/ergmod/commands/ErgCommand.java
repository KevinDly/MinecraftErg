package com.example.ergmod.commands;

import com.example.ergmod.ErgMod;
import com.example.ergmod.itemhelpers.ItemHelper;
import com.example.ergmod.utils.Constants;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ErgCommand {
	
	//TODO: Modify or create new command that allows user to change erg level given
	//TODO: Have execute return different number once you figure out what the numbers represent.
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal(Constants.COMMAND_ERG).requires((p_198727_0_) ->{
			return p_198727_0_.hasPermissionLevel(2);
		}).executes((p_198727_0_) -> {
			ItemHelper.checkErg(p_198727_0_.getSource().asPlayer().getHeldItemMainhand());
			return 1;
		}));
	}
	
	
	//private static int 
	/*
	//TODO: Change where the throw is done?
	@SubscribeEvent
	public void parseErgCommand(CommandEvent event) throws CommandSyntaxException {
		CommandSource source = event.getParseResults().getContext().getSource();
		
		String command = event.getParseResults().getReader().getRead();
		PlayerEntity player = source.asPlayer();
		ItemStack item = player.getHeldItemMainhand();
		if(!command.equals("makeerg")) {
			return;
		}
		if(ItemHelper.checkLevel(item) != 0){
			ItemHelper.checkErg(item);
			return;
		}
		
	}*/
}
