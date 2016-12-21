package welcome.llama.welcome;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import net.md_5.bungee.api.ChatColor;
import welcome.llama.welcome.MainClass;

public class JoinListener implements Listener {
	
	MainClass configGetter;
	
	public JoinListener(MainClass plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		configGetter = plugin;
	}	
	//Player Join Message
	@EventHandler
	public void onPlayerJoinMessage(PlayerJoinEvent event) {
		if (configGetter.getConfig().getBoolean("Enable Server Welcome", true)) {
			if (configGetter.getConfig().getBoolean("Enable Player Join Message", true)) {
				Player player = event.getPlayer();
				if (!player.hasPermission("serverwelcome.msgoverride")) {
					String coloredJoinMessage = ChatColor.translateAlternateColorCodes('&', configGetter.getConfig().getString("Player Join Message"));
					player.sendMessage(coloredJoinMessage);
				}
			}
		}
	}
	//Player Join Broadcast
	@EventHandler
	public void onPlayerJoinBroadcast(PlayerJoinEvent eve) {
		if (configGetter.getConfig().getBoolean("Enable Server Welcome", true)) {
			if (configGetter.getConfig().getBoolean("Enable Player Join Broadcast", true)) {
				Player player = eve.getPlayer();
				if (!player.hasPermission("serverwelcome.joinbcoverride")) {
					String coloredJoinBroadcast = ChatColor.translateAlternateColorCodes('&', configGetter.getConfig().getString("Player Join Broadcast"));
					Bukkit.broadcastMessage(coloredJoinBroadcast);
				}
			}
		}
	}
	//Player quit broadcast
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if (configGetter.getConfig().getBoolean("Enable Server Welcome", true)) {
			if (configGetter.getConfig().getBoolean("Enable Player Leave Broadcast", true)) {
				Player player = e.getPlayer();
				if (!player.hasPermission("serverwelcome.leavebcoverride")) {
					String coloredLeaveBroadcast = ChatColor.translateAlternateColorCodes('&', configGetter.getConfig().getString("Player Leave Broadcast"));
					Bukkit.broadcastMessage(coloredLeaveBroadcast);
				}
			}
		}
	}
}
