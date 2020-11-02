package com.example.ergmod.erg;

import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;

/*Class that checks if the item is compatible with erg upgrade*/

public enum ErgType implements net.minecraftforge.common.IExtensibleEnum {
	/*TODO: Add all enumerations for this to avoid any errors down the line, should return false in all other cases.*/
	
	WEAPON {
	   /**
	    * Return true if the item passed can be erged.
	    */
		public boolean canEnchantItem(Item itemIn){
			return itemIn instanceof SwordItem;
		}
	},
	TRIDENT {
		/**
		 * Return true if the item passed can be erged.
		 */
		public boolean canEnchantItem(Item itemIn){
			return itemIn instanceof TridentItem;
		}
	},
	BOW {
		/**
		 * Return true if the item passed can be erged.
		 */
		public boolean canEnchantItem(Item itemIn){
			return itemIn instanceof BowItem;
		}
	},
	CROSSBOW {
		/**
		 * Return true if the item passed can be erged.
		 */
		public boolean canEnchantItem(Item itemIn){
			return itemIn instanceof CrossbowItem;
		}
	};
	
	private ErgType(){
		
	}
	
	private java.util.function.Predicate<Item> delegate;
	
	private ErgType(java.util.function.Predicate<Item> delegate){
		this.delegate = delegate;
	}
	
	public static ErgType create(String name, java.util.function.Predicate<Item> delegate){
		throw new IllegalStateException("Enum not extended");
	}
	
	public boolean canEnchantItem(Item itemIn){
		return this.delegate == null ? false : this.delegate.test(itemIn);
	}
}
