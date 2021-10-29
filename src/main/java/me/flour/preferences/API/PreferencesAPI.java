package me.flour.preferences.API;

import me.flour.preferences.data.PlayerCache;
import me.flour.preferences.menu.MainMenu;
import org.bukkit.entity.Player;

public class PreferencesAPI {

	public static void openMainMenu(Player player) {
		new MainMenu(player).displayTo(player);
	}
	public static Boolean checkIgnoreRP(Player player) {
		PlayerCache cache = PlayerCache.getCache(player);
		return cache.getIgnoreRP();
	}
	public static Boolean getVisibility(Player player) {
		PlayerCache cache = PlayerCache.getCache(player);
		return cache.getVisibility();
	}
	public static Integer getHearingDistance(Player player) {
		PlayerCache cache = PlayerCache.getCache(player);
		return  cache.getHearingDistance();
	}
	

}
