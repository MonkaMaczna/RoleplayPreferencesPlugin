package me.flour.preferences.Commands;

import me.flour.preferences.menu.MainMenu;
import me.flour.preferences.settings.Settings;
import org.bukkit.Sound;
import org.mineacademy.fo.command.SimpleCommand;

public class MenuCommand extends SimpleCommand {
	public MenuCommand(String label) {
		super(label);
	}

	@Override
	protected void onCommand() {
		checkPerm(Settings.PERM);
		getPlayer().playSound(getPlayer().getLocation(), Settings.OPEN_SOUND.getSound(), Settings.OPEN_VOLUME,Settings.OPEN_PITCH);
		new MainMenu(getPlayer()).displayTo(getPlayer());
	}
}
