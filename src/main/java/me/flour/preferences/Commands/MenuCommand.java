package me.flour.preferences.Commands;

import me.flour.preferences.menu.MainMenu;
import org.bukkit.Sound;
import org.mineacademy.fo.command.SimpleCommand;

public class MenuCommand extends SimpleCommand {
	public MenuCommand(String label) {
		super(label);
	}

	@Override
	protected void onCommand() {
		checkPerm("menu.open");
		getPlayer().playSound(getPlayer().getLocation(), Sound.BLOCK_ANVIL_FALL,3,0);
		new MainMenu(getPlayer()).displayTo(getPlayer());
	}
}
