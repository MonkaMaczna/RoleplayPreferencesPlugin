package me.flour.preferences.Events;


import me.flour.preferences.PreferencesPlugin;
import me.flour.preferences.data.PlayerCache;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {


	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		for (Player players : Bukkit.getOnlinePlayers()) {
			PlayerCache cache = PlayerCache.getCache(players);
			if (!cache.getVisibility()) {
				players.hidePlayer(PreferencesPlugin.getPlugin(PreferencesPlugin.class), event.getPlayer());
			} else if (cache.getVisibility()) {
				players.showPlayer(PreferencesPlugin.getPlugin(PreferencesPlugin.class), event.getPlayer());
			}
		}
	}
}
