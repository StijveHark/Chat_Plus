package nl.codeermeneer.chatplus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	/*
	 * Made by CodeerMeneer (Copyright)
	 */
	  public void onEnable(){
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	    Bukkit.getServer().getPluginManager().registerEvents(this, this);
	  }

	  @EventHandler
	  public void onPlayerChat(AsyncPlayerChatEvent e) {
	    Player p = e.getPlayer();
	    for (String word : e.getMessage().split(" "))
	      if (getConfig().getStringList("chatplus").contains(word.toLowerCase()))
	        if (!p.hasPermission("chatplus.allow")) {
	          e.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Hey! " + ChatColor.GRAY + "Do not swear its not enable on this server!");
	          e.setCancelled(true);
	          } else {
	          return;
	        }
	  }
}