package com.funlerz.greeterplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.funlerz.greeterplugin.GreeterPlugin;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		String playerName = event.getPlayer().getName();
		if (GreeterPlugin.config.getString("join_message") != null) {
			String message = GreeterPlugin.config.getString("join_message");
			if (message.contains("{name}")) {
				message = message.replaceAll("\\{name\\}", playerName);
			}
			event.setJoinMessage(message);
		} else {
			event.setJoinMessage("Welcome to the server, " + playerName + "!");
		}
	}
	
}
