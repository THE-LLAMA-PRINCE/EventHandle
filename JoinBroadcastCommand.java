package welcome.llama.welcome;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class JoinBroadcastCommand implements CommandExecutor {
	
	MainClass configGetter;
        public JoinBroadcastCommand(MainClass plugin) {
                plugin.getServer().getPluginManager().registerEvents(this, plugin);
                configGetter = plugin;
        }

	@Override
	//Command WelcomeBc
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {	
		if (cmd.getName().equalsIgnoreCase("swjoinbc") && sender instanceof Player) {
			Player player = (Player) sender;
			if (!player.hasPermission("serverwelcome.joinbcoverride")) {
				String coloredJoinBroadcast = ChatColor.translateAlternateColorCodes('&', configGetter.getConfig().getString("Player Join Broadcast"));
				player.sendMessage(coloredJoinBroadcast);
			}
			return true;
		}
		return false;
	}
}
