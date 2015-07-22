package com.funlerz.greeterplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.funlerz.greeterplugin.listeners.PlayerListener;

public class GreeterPlugin extends JavaPlugin {
	
	public static FileConfiguration config;
	
	@Override
	public void onEnable() {
		config = getConfig();
		config.addDefault("join_message", "Welcome to the server, {name}!");
		config.options().copyDefaults(true);
		saveConfig();
		
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	}
	
	@Override
	public void onDisable() {
		// TODO: disable stuff.
	}
	
}
