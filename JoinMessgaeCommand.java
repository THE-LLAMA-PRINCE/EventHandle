package welcome.llama.welcome;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class JoinMessgaeCommand implements CommandExecutor {
	
	MainClass configGetter;
        public JoinMessgaeCommand(MainClass plugin) {
                plugin.getServer().getPluginManager().registerEvents(this, plugin);
                configGetter = plugin;
        }

	@Override
	//Command WelcomeMsg
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {	
		if (cmd.getName().equalsIgnoreCase("swjoinmsg") && sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("serverwelcome.joinmsgcommand")) {
				String coloredJoinMessage = ChatColor.translateAlternateColorCodes('&', configGetter.getConfig().getString("Player Join Message"));
				player.sendMessage(coloredJoinMessage);
			}
			return true;
		}
		return false;
	}
}
