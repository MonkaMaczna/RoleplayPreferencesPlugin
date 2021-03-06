package me.flour.preferences;

import me.flour.character.Events.RightClickEvent;
import me.flour.character.UpdateChecker;
import me.flour.preferences.Commands.MenuCommand;
import me.flour.preferences.settings.Settings;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.Arrays;
import java.util.List;

public class PreferencesPlugin extends SimplePlugin {
	@Override
	protected void onPluginStart() {



		if (getServer().getPluginManager().getPlugin("LocalChatManager") == null || getServer().getPluginManager().getPlugin("RoleplayCharacterInformation") == null) {
			Common.log("&cDependecies not found!!!",
					"&cNeeded plugins: LocalChatManager, RoleplayCharacterInformation",
					"&cYou can download these from my spigotmc profile: https://www.spigotmc.org/members/monkakokosowa.1262056/",
					"&cRoleplayCharacterInformation: https://www.spigotmc.org/resources/roleplay-character-information.97031/",
					"&cLocalChat: https://www.spigotmc.org/resources/local-chat-plugin-for-short-distance-chatting.97027/",
					"&cDisabling Plugin...");
			getServer().getPluginManager().disablePlugin(this);
		} else {

			final org.mineacademy.fo.metrics.Metrics metrics = new org.mineacademy.fo.metrics.Metrics(this, 13129);
			Common.log("&5[Roleplay Preferences Plugin] Loaded Preferences Plugin. ", "&5Plugin was made by Wheat Flour");

			if (me.flour.character.settings.Settings.CHECK_UPDATE) {
				new UpdateChecker(this, 97138).getVersion(version -> {
					if (this.getDescription().getVersion().equals(version)) {
						Common.log("&c[Roleplay Preferences Plugin] &cThere aren't any new updates for Preferences Plugin");
					} else {
						Common.log("&cThere's a new update avalaible for Preferences Plugin",
								"&cLink to update: https://www.spigotmc.org/resources/roleplay-preferences-plugin.97138/",
								"&cPlease download regularly updates because they are fixing many bugs and add many new features.");

					}
				});
			}

			registerCommand(new MenuCommand(Settings.MENUCOMMAND));
			registerEvents(new RightClickEvent());
		}









	}
	@Override
	public List<Class<? extends YamlStaticConfig>> getSettings() {
		return Arrays.asList(Settings.class);
	}
}
