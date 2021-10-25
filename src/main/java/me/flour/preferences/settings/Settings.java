package me.flour.preferences.settings;


import org.mineacademy.fo.settings.SimpleSettings;

public class Settings extends SimpleSettings {
	@Override
	protected int getConfigVersion() {
		return 3;

	}





	public static Integer MENU_SIZE;
	public static Integer VISIBILITY_SLOT;
	public static Integer CHARACTERINFO_SLOT;
	public static Integer IGNORE_LOCAL_SLOT;
	public static Integer HEARING_DISTANCE_SLOT;
	public static Boolean PLAYERHEADS;
	public static String MENUCOMMAND;
	public static Boolean VISIBLE_BOOLEAN;



	private static void init() {
		VISIBLE_BOOLEAN = getBoolean("RolePlay_Menu_Settings.Visibility_Button_Settings.Use");
		MENU_SIZE = getInteger("RolePlay_Menu_Settings.Menu_Size");
		PLAYERHEADS = getBoolean("RolePlay_Menu_Settings.Player_Heads");
		MENUCOMMAND = getString("RolePlay_Menu_Settings.Command");
		VISIBILITY_SLOT = getInteger("RolePlay_Menu_Settings.Visibility_Button_Settings.Slot");
		IGNORE_LOCAL_SLOT = getInteger("RolePlay_Menu_Settings.Ignore_Local_Chat_Button_Settings.Slot");
		HEARING_DISTANCE_SLOT = getInteger("RolePlay_Menu_Settings.Hearing_Distance_Button_Settings.Slot");
		CHARACTERINFO_SLOT = getInteger("RolePlay_Menu_Settings.Character_Information_Button_Settings.Slot");





	}
}
