package welcome.llama.welcome;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import welcome.llama.welcome.JoinBroadcastCommand;
import welcome.llama.welcome.JoinMessgaeCommand;
import welcome.llama.welcome.LeaveBroadcastCommand;
import welcome.llama.welcome.JoinListener;

public class MainClass extends JavaPlugin {
	
	//PERMISSIONS
	public Permission joinmsgoverride = new Permission("serverwelcome.msgoverride");
	public Permission joinbcoverride = new Permission("serverwelcome.joinbcoverride");
	public Permission leavebcoverride = new Permission("serverwelcome.leavebcoverride");
	public Permission joinmsgcommand = new Permission("serverwelcome.joinmsgcommand");
	public Permission joinbccommand = new Permission("serverwelcome.joinbccommand");
	public Permission leavebccommand = new Permission("serverwelcome.leavebccommand");
	
	//ON PLUGIN ENABLE
	@Override
	public void onEnable() {
		//MAKES THE NEW LISTENER
		new JoinListener(this);
		//ADDS PERMISSIONS
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(joinmsgoverride);
		pm.addPermission(joinbcoverride);
		pm.addPermission(leavebcoverride);
		pm.addPermission(joinmsgcommand);
		pm.addPermission(joinbccommand);
		pm.addPermission(leavebccommand);
		//WHAT THE CONSOLE SAYS WHEN YOU RUN THE PLUGIN
		getLogger().info("The plugin is up and running :D");
		//CONFIG FILE JUNK
		this.getConfig().addDefault("Server Welcome Version" , 1.0);
		this.getConfig().addDefault("Enable Server Welcome", true);
		this.getConfig().addDefault("Enable Player Join Message", true);
		this.getConfig().addDefault("Player Join Message", "&bThis is the default Join Message, change it!");
		this.getConfig().addDefault("Enable Player Join Broadcast", true);
		this.getConfig().addDefault("Player Join Broadcast", "&aThis is the default Join Broadcast, change it!");
		this.getConfig().addDefault("Enable Player Leave Broadcast", true);
		this.getConfig().addDefault("Player Leave Broadcast", "&6This is the default Leave Broadcast, change it!");
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		this.saveDefaultConfig();
		//GETTING COMMANDS FROM OTHER CLASSES
		getCommand("swjoinmsg").setExecutor(new JoinMessgaeCommand());
		getCommand("swjoinbc").setExecutor(new JoinBroadcastCommand());
		getCommand("swleavebc").setExecutor(new LeaveBroadcastCommand());
	}
	@Override
	public void onDisable() {
	}
}