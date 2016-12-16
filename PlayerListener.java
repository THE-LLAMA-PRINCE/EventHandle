package eventhandle.plugin.eventhandle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerListener implements Listener {
	
	public PlayerListener(EventHandle plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onThrow(PlayerEggThrowEvent event) {
		
		Player player = event.getPlayer();
		
		player.sendMessage(ChatColor.RED + "DO NOT THROW EGGS!");
	}
	
	@EventHandler
	public void onBucketFill(PlayerBucketFillEvent e) {
		e.setCancelled(true);
	}

}
