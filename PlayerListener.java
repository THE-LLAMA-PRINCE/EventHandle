package minecraft.llama.minecraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import minecraft.llama.minecraft.EventHandled;

public class PlayerListener implements Listener {
	
	EventHandled configGetter;
	
	public PlayerListener(EventHandled plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		configGetter = plugin;
	}
	
	@EventHandler
	public void onLavaOrWaterBucketFill(PlayerBucketFillEvent e) {
		
		Player player = e.getPlayer();
		
		if (configGetter.getConfig().getBoolean("Enable Only Buy Buckets" , true));
		if (!player.hasPermission("OnlyBuyBuckets.override")) {
			e.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You do not have permission to fill buckets, buy them from the store if you need water or lava");
		}
			
	}
	
	@EventHandler
	public void onWaterTest(PlayerBucketEmptyEvent events) {
		events.setCancelled(false);
	}
}

