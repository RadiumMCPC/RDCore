/*
 * Radium | Main Class
 * @Purpose: Intializes the Plugin
 * @Author: Radium team / w1l (Lead Developer)
 * @Copyright (c) Radium.tk
 */

package org.rd1.rdcore;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.rd1.rdcore.RDUtils;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		this.getLogger().info("RDCore by w1l");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command pCmd, String label, String[] args) {
		if(!(sender instanceof Player)) { //Check If Sender Is A Player!
			sender.sendMessage("§2You cannot use this Command!"); //It isnt a Player, block em all!
			return false;
		}
		
		Player p = (Player)sender; //Convert Sender to Player!
		
		//Heal Command
		if(pCmd.getName().equalsIgnoreCase("heal")) {
			if(RDUtils.healAllowed(p) == true) {
				p.setHealth(p.getMaxHealth()); //Ik It Is Deprecated, but who cares :p?
				p.sendMessage("§2Your health Is now §a" + p.getHealth());
			}
			else
			{
				p.sendMessage("§2You cannot use this Command!");
			}
		}
		
		//Feed Command
		if(pCmd.getName().equalsIgnoreCase("feed")) {
			p.setFoodLevel(20); //There Is no getMaxFoodLevel() so I had to Guess the Max Value :/
			p.sendMessage("§2Your Food Is now §a" + p.getFoodLevel());
		}
		
		//Fly Command
		if(pCmd.getName().equalsIgnoreCase("fly")) {
			if(args.length == 1) { //Checks If Player Entered Args (ON / OFF In This Case)
				if(args[0] == "on") {
					if(RDUtils.flyAllowed(p) == true) {
						p.setAllowFlight(true);
						p.sendMessage("§2You can now Fly!");
					}
					else
					{
						p.sendMessage("§2You cannot use this Command!");
					}
				}
				else if(args[0] == "off") {
					if(RDUtils.flyAllowed(p) == true) {
						p.setAllowFlight(false);
						p.sendMessage("§2You can't fly Anymore :/");
					}
					else
					{
						p.sendMessage("§2You cannot use this Command!");
					}
				}
			}
			else
			{
				p.sendMessage("§2Usage: /fly <on / off>"); //Shitty Usage for Noobs 8)
			}
		}
		
		//Gmc Command
		if(pCmd.getName().equalsIgnoreCase("gmc")){
			if(RDUtils.canGmc(p) == true) {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("§2Your Gamemode has been Updated to CREATIVE!");
			}
			else
			{
				p.sendMessage("§2You cannot use this Command!");
			}
		}
		
		//Gms Command
		if(pCmd.getName().equalsIgnoreCase("gms")) {
			if(RDUtils.canGms(p) == true) {
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage("§2Your Gamemode has been Updated to SURVIVAL!");
			}
			else
			{
				p.sendMessage("§2You cannot use this Command!");
			}
		}
		
		return false;
	}
}
