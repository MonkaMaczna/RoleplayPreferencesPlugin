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

		setSize(Settings.MENU_SIZE);


		setTitle(Settings.MENU_TITLE);



		HearingLevel = new Button() {
			@Override
			public void onClickedInMenu(final Player player, final Menu menu, final ClickType clickType) {
				final PlayerCache cache = PlayerCache.getCache(getViewer());

				int nextDistance = 0;


				if (clickType.isRightClick()) {
					nextDistance = MathUtil.range(cache.getHearingDistance() + Settings.HEARING_ADD , Settings.HEARING_MIN, Settings.HEARING_MAX);
				} else if (clickType.isLeftClick()) {
					nextDistance = MathUtil.range(cache.getHearingDistance() - Settings.HEARING_ADD , Settings.HEARING_MIN, Settings.HEARING_MAX);
				} else {
					nextDistance = cache.getHearingDistance() + Settings.HEARING_ADD;
				}

				cache.setHearingDistance(nextDistance);
				restartMenu(Settings.HEARING_ANIMATE + nextDistance);
				redraw();

			}

			@Override
			public ItemStack getItem() {
				final PlayerCache cache = PlayerCache.getCache(getViewer());

				return ItemCreator.of(Settings.HEARING_MATERIAL,
								Settings.HEARING_TITLE,
								Settings.HEARING_LORE1,
								Settings.HEARING_LORE2,
								Settings.HEARING_LORE3,
								Settings.HEARING_LORE4,
								Settings.HEARING_LORE5 + cache.getHearingDistance(),
								Settings.HEARING_LORE6,
								Settings.HEARING_LORE7,
								Settings.HEARING_LORE8)

						.build().make();
			}
		};

		IgnoreRPButton = new Button() {
			@Override
			public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
				PlayerCache cache = PlayerCache.getCache(player);
				if (cache.getIgnoreRP() == false) {
					cache.setIgnoreRP(true);
					restartMenu(Settings.IGNORE_LOCAL_ANIMATE_TRUE);
				} else if (cache.getIgnoreRP() == true) {
					cache.setIgnoreRP(false);
					restartMenu(Settings.IGNORE_LOCAL_ANIMATE_FALSE);
				}
				redraw();
			}

			@Override
			public ItemStack getItem() {
				PlayerCache cache = PlayerCache.getCache(player);
				return ItemCreator.of((cache.getIgnoreRP() ? Settings.IGNORE_LOCAL_TRUE_MATERIAL : Settings.IGNORE_LOCAL_FALSE_MATERIAL),Settings.IGNORE_LOCAL_TITLE,
						Settings.IGNORE_LOCAL_LORE1,
						Settings.IGNORE_LOCAL_LORE2 + (cache.getIgnoreRP() ? Settings.IGNORE_LOCAL_DEF_TRUE : Settings.IGNORE_LOCAL_DEF_FALSE)).build().make();
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
					return ItemCreator.of(CompMaterial.PLAYER_HEAD,Settings.CHARACTER_TITLE,
							Settings.CHARACTER_LORE1,
							Settings.CHARACTER_LORE2,
							Settings.CHARACTER_LORE3,
							Settings.CHARACTER_LORE4).skullOwner(player.getName()).build().make();
				} else {
					return ItemCreator.of(Settings.CHARACTER_MATERIAL,Settings.CHARACTER_TITLE,
							Settings.CHARACTER_LORE1,
							Settings.CHARACTER_LORE2,
							Settings.CHARACTER_LORE3,
							Settings.CHARACTER_LORE4).flag(CompItemFlag.HIDE_ENCHANTS).build().make();
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
						restartMenu(Settings.VISIBILITY_ANIMATE_FALSE);
					}
				} else if (cache.getVisibility() == false) {
					for (Player players : Bukkit.getOnlinePlayers()) {
						player.showPlayer(PreferencesPlugin.getPlugin(PreferencesPlugin.class),players);
						cache.setVisibility(true);
						restartMenu(Settings.VISIBILITY_ANIMATE_TRUE);
					}
				}
				redraw();




			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of((me.flour.preferences.data.PlayerCache.getCache(player).getVisibility() ? Settings.VISIBILITY_TRUE_MAT : Settings.VISIBILITY_FALSE_MAT),Settings.VISIBILITY_TITLE,
						Settings.VISIBILITYLORE1,
						Settings.VISIBILITYLORE2,
						Settings.VISIBILITYLORE3 + (PlayerCache.getCache(player).getVisibility() ? Settings.VISIBILITYDEFTRUE : Settings.VISIBILITYDEFFALSE
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