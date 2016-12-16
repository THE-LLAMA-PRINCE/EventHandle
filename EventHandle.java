package eventhandle.plugin.eventhandle;

import org.bukkit.plugin.java.JavaPlugin;

public class EventHandle extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new PlayerListener(this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
