package me.flour.preferences.Events;

import me.flour.preferences.menu.MainMenu;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RightClickEvent implements Listener {
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {



		ItemStack itemStack = new ItemStack(Material.BLAZE_ROD,1);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.BLUE + "Preferences");
		itemStack.setItemMeta(itemMeta);

		if (event.getPlayer().getInventory().getItemInMainHand() == itemStack) {
			new MainMenu(event.getPlayer()).displayTo(event.getPlayer());

		}

	}
}
