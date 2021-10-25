package me.flour.preferences.menu;


import lombok.Getter;
import lombok.Setter;
import me.flour.character.API.CharacterAPI;
import me.flour.preferences.PreferencesPlugin;

import me.flour.preferences.data.PlayerCache;
import me.flour.preferences.settings.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.MathUtil;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.MenuQuantitable;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.menu.model.MenuQuantity;
import org.mineacademy.fo.remain.CompItemFlag;
import org.mineacademy.fo.remain.CompMaterial;


public class MainMenu extends Menu {


	private final Button VisibilityButton;
	private final Button CharacterButton;
	private final Button IgnoreRPButton;
	private final Button HearingLevel;



	public MainMenu(final Player player) {

		setSize(9*3);


		setTitle("&bPreferences...");



		HearingLevel = new Button() {
			@Override
			public void onClickedInMenu(final Player player, final Menu menu, final ClickType clickType) {
				final PlayerCache cache = PlayerCache.getCache(getViewer());

				int nextDistance = 0;


				if (clickType.isRightClick()) {
					nextDistance = MathUtil.range(cache.getHearingDistance() + 1 , 5, 1000);
				} else if (clickType.isLeftClick()) {
					nextDistance = MathUtil.range(cache.getHearingDistance() - 1 , 5, 1000);
				} else {
					nextDistance = cache.getHearingDistance() + 1;
				}

				cache.setHearingDistance(nextDistance);
				restartMenu("&aChanged hearing to " + nextDistance);
				redraw();

			}

			@Override
			public ItemStack getItem() {
				final PlayerCache cache = PlayerCache.getCache(getViewer());

				return ItemCreator.of(CompMaterial.NOTE_BLOCK,
								"&aChange your hearing",
								"",
								"&bChange the distance of hearing",
								"&bRoleplay Chat",
								"",
								"&bCurrent: " + cache.getHearingDistance(),
								"",
								"&8(&bMouse click&8)",
								"&b< -1 +1 >")

						.build().make();
			}
		};

		IgnoreRPButton = new Button() {
			@Override
			public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
				PlayerCache cache = PlayerCache.getCache(player);
				if (cache.getIgnoreRP() == false) {
					cache.setIgnoreRP(true);
					restartMenu("&aChat RP: Ignored.");
				} else if (cache.getIgnoreRP() == true) {
					cache.setIgnoreRP(false);
					restartMenu("&aChat RP: Visible.");
				}
				redraw();
			}

			@Override
			public ItemStack getItem() {
				PlayerCache cache = PlayerCache.getCache(player);
				return ItemCreator.of((cache.getIgnoreRP() ? CompMaterial.RED_DYE : CompMaterial.PURPLE_DYE),"&aRP Settings",
						"&bShould you receive RP messages?",
						"&bSetting: " + (cache.getIgnoreRP() ? "&cIgnoring RP Chat" : "&aSeeing RP Chat")).build().make();
			}
		};

		CharacterButton = new Button() {
			@Override
			public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
				CharacterAPI.openCharacterMenu(player,player);
			}

			@Override
			public ItemStack getItem() {
				if (Settings.PLAYERHEADS) {
					return ItemCreator.of(CompMaterial.PLAYER_HEAD,"&aCharacter Information",
							"&bCheck your character information by",
							"&bclicking this button or",
							"&busing command",
							"&b/character info").skullOwner(player.getName()).build().make();
				} else {
					return ItemCreator.of(CompMaterial.ENCHANTED_BOOK,"&aCharacter Information",
							"&bCheck your character information by",
							"&bclicking this button or",
							"&busing command",
							"&b/character info").flag(CompItemFlag.HIDE_ENCHANTS).build().make();
				}

			}
		};

		VisibilityButton = new Button() {
			@Override
			public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {

				me.flour.preferences.data.PlayerCache cache = me.flour.preferences.data.PlayerCache.getCache(player);


				if (cache.getVisibility() == true) {
					for (Player players : Bukkit.getOnlinePlayers()) {
						player.hidePlayer(PreferencesPlugin.getPlugin(PreferencesPlugin.class),players);
						cache.setVisibility(false);
						restartMenu("&aVisibility: Invisible");
					}
				} else if (cache.getVisibility() == false) {
					for (Player players : Bukkit.getOnlinePlayers()) {
						player.showPlayer(PreferencesPlugin.getPlugin(PreferencesPlugin.class),players);
						cache.setVisibility(true);
						restartMenu("&aVisibility: Visible");
					}
				}
				redraw();




			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of((me.flour.preferences.data.PlayerCache.getCache(player).getVisibility() ? CompMaterial.LIME_DYE : CompMaterial.GRAY_DYE),"&aVisibility settings",
						"&bShould you be able to see",
						"&bother players?",
						"&bVisibility: " + (PlayerCache.getCache(player).getVisibility() ? "&aVisible" : "&cNot visible"
						)).build().make();
			}
		};











	}

	@Override
	public ItemStack getItemAt(final int slot) {

		if (slot == Settings.VISIBILITY_SLOT && Settings.VISIBLE_BOOLEAN) {
			return VisibilityButton.getItem();
		}
		if (slot == Settings.CHARACTERINFO_SLOT) {
			return CharacterButton.getItem();
		}
		if (slot == Settings.HEARING_DISTANCE_SLOT) {
			return HearingLevel.getItem();
		}
		if (slot == Settings.IGNORE_LOCAL_SLOT) {
			return IgnoreRPButton.getItem();
		}


		return null;
	}





}



// 		final PlayerCache cache = PlayerCache.getCache(event.getPlayer());