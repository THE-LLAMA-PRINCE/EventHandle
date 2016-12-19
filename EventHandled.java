package minecraft.llama.minecraft;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EventHandled extends JavaPlugin {
	public Permission playerPermission = new Permission("OnlyBuyBuckets.override");
	@Override
	public void onEnable() {
		new PlayerListener(this);
		//adding the permission to the plugin manager
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(playerPermission);
		//adding stuff to the config
		this.getConfig().addDefault("Enable Only Buy Buckets" , true);
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable() {
		//Saving config on close
		saveConfig();
		saveDefaultConfig();
		
	}
}