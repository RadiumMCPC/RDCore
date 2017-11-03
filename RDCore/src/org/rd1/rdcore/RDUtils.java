package org.rd1.rdcore;

import org.bukkit.entity.Player;

public class RDUtils {

	public static boolean canGmc(Player p) {
		if(p.hasPermission("rd1.gmc")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean canGms(Player p) {
		if(p.hasPermission("rd1.gms")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean flyAllowed(Player p) {
		if(p.hasPermission("rd1.fly")) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean healAllowed(Player p) {
		if(p.hasPermission("rd1.heal")) {
			return true;
		}
		else
		{
			return false;
		}
	}
}
