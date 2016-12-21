package welcome.llama.welcome;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class LeaveBroadcastCommand implements CommandExecutor {
	
	MainClass configGetter;

	@Override
	//Command LeaveBc
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {	
		if (cmd.getName().equalsIgnoreCase("swleavebc") && sender instanceof Player) {
		Player player = (Player) sender;
			if (!player.hasPermission("serverwelcome.joinbcoverride")) {
				String coloredLeaveBroadcast = ChatColor.translateAlternateColorCodes('&', configGetter.getConfig().getString("Player Leave Broadcast"));
				player.sendMessage(coloredLeaveBroadcast);
			}
			return true;
		}
		return false;
	}
}
