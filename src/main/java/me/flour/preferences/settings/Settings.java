package me.flour.preferences.settings;


import org.bukkit.Sound;
import org.mineacademy.fo.model.SimpleSound;
import org.mineacademy.fo.remain.CompItemFlag;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.settings.SimpleSettings;

public class Settings extends SimpleSettings {
	@Override
	protected int getConfigVersion() {
		return 4;

	}





	public static Integer MENU_SIZE;
	public static Integer VISIBILITY_SLOT;
	public static Integer CHARACTERINFO_SLOT;
	public static Integer IGNORE_LOCAL_SLOT;
	public static Integer HEARING_DISTANCE_SLOT;
	public static Boolean PLAYERHEADS;
	public static String MENUCOMMAND;
	public static Boolean VISIBLE_BOOLEAN;

	// menu settings
	public static SimpleSound OPEN_SOUND;
	public static Integer OPEN_VOLUME;
	public static Integer OPEN_PITCH;
	public static String PERM;


	// character button settings
	public static CompMaterial CHARACTER_MATERIAL;

	// hearing button settings


	public static CompMaterial HEARING_MATERIAL;
	public static Integer HEARING_MAX;
	public static Integer HEARING_MIN;
	public static Integer HEARING_ADD;


	// Language settings

	public static String MENU_TITLE;


	// Visibility button
	public static String VISIBILITY_TITLE;
	public static String VISIBILITYLORE1;
	public static String VISIBILITYLORE2;
	public static String VISIBILITYLORE3;
	public static String VISIBILITYDEFTRUE;
	public static String VISIBILITYDEFFALSE;
	public static String VISIBILITY_ANIMATE_TRUE;
	public static String VISIBILITY_ANIMATE_FALSE;
	public static CompMaterial VISIBILITY_TRUE_MAT;
	public static CompMaterial VISIBILITY_FALSE_MAT;


	// Character Info button
	public static String CHARACTER_TITLE;
	public static String CHARACTER_LORE1;
	public static String CHARACTER_LORE2;
	public static String CHARACTER_LORE3;
	public static String CHARACTER_LORE4;


	// Ignore Local Chat Button
	public static String IGNORE_LOCAL_TITLE;
	public static String IGNORE_LOCAL_LORE1;
	public static String IGNORE_LOCAL_LORE2;
	public static String IGNORE_LOCAL_DEF_TRUE;
	public static String IGNORE_LOCAL_DEF_FALSE;
	public static String IGNORE_LOCAL_ANIMATE_TRUE;
	public static String IGNORE_LOCAL_ANIMATE_FALSE;
	public static CompMaterial IGNORE_LOCAL_TRUE_MATERIAL;
	public static CompMaterial IGNORE_LOCAL_FALSE_MATERIAL;


	// Hearing distance button
	public static String HEARING_TITLE;
	public static String HEARING_LORE1;
	public static String HEARING_LORE2;
	public static String HEARING_LORE3;
	public static String HEARING_LORE4;
	public static String HEARING_LORE5;
	public static String HEARING_LORE6;
	public static String HEARING_LORE7;
	public static String HEARING_LORE8;
	public static String HEARING_ANIMATE;



	private static void init() {
		VISIBLE_BOOLEAN = getBoolean("RolePlay_Menu_Settings.Visibility_Button_Settings.Use");
		MENU_SIZE = getInteger("RolePlay_Menu_Settings.Menu_Size");
		PLAYERHEADS = getBoolean("RolePlay_Menu_Settings.Player_Heads");
		MENUCOMMAND = getString("RolePlay_Menu_Settings.Command");
		VISIBILITY_SLOT = getInteger("RolePlay_Menu_Settings.Visibility_Button_Settings.Slot");
		IGNORE_LOCAL_SLOT = getInteger("RolePlay_Menu_Settings.Ignore_Local_Chat_Button_Settings.Slot");
		HEARING_DISTANCE_SLOT = getInteger("RolePlay_Menu_Settings.Hearing_Distance_Button_Settings.Slot");
		CHARACTERINFO_SLOT = getInteger("RolePlay_Menu_Settings.Character_Information_Button_Settings.Slot");

		// general menu settings
		OPEN_SOUND = getSound("Roleplay_Menu_Settings.Opening_Settings.Sound");
		OPEN_VOLUME = getInteger("Roleplay_Menu_Settings.Opening_Settings.Volume");
		OPEN_PITCH = getInteger("Roleplay_Menu_Settings.Opening_Settings.Pitch");
		PERM = getString("Roleplay_Menu_Settings.Permission");


		// character settings
		CHARACTER_MATERIAL = getMaterial("Roleplay_Menu_Settings.Character_Information_Button_Settings.Material");



		// Hearing distance button settings
		HEARING_MATERIAL = getMaterial("Roleplay_Menu_Settings.Hearing_Distance_Button_Settings.Material");
		HEARING_ADD = getInteger("Roleplay_Menu_Settings.Hearing_Distance_Button_Settings.Adds");
		HEARING_MIN = getInteger("Roleplay_Menu_Settings.Hearing_Distance_Button_Settings.Min");
		HEARING_MAX = getInteger("Roleplay_Menu_Settings.Hearing_Distance_Button_Settings.Max");



		// Language settings

		MENU_TITLE = getString("Roleplay_Menu_Language_Preferences.Menu_Title");


		// VISIBILITY
		VISIBILITY_TITLE = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Title");
		VISIBILITYLORE1 = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Lore1");
		VISIBILITYLORE2 = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Lore2");
		VISIBILITYLORE3 = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Lore3");
		VISIBILITYDEFTRUE = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Definition_Of_True");
		VISIBILITYDEFFALSE = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Definition_Of_False");
		VISIBILITY_ANIMATE_TRUE = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Animation_Of_Button_To_True");
		VISIBILITY_ANIMATE_FALSE = getString("Roleplay_Menu_Language_Preferences.Visibility_Button_Language.Animation_Of_Button_To_False");
		VISIBILITY_TRUE_MAT = getMaterial("Roleplay_Menu_Settings.Visibility_Button_Settings.True_Material");
		VISIBILITY_FALSE_MAT = getMaterial("Roleplay_Menu_Settings.Visibility_Button_Settings.False_Material");


		// CHARACTER
		CHARACTER_TITLE = getString("Roleplay_Menu_Language_Preferences.Character_Information_Button_Language.Title");
		CHARACTER_LORE1 = getString("Roleplay_Menu_Language_Preferences.Character_Information_Button_Language.Lore1");
		CHARACTER_LORE2 = getString("Roleplay_Menu_Language_Preferences.Character_Information_Button_Language.Lore2");
		CHARACTER_LORE3 = getString("Roleplay_Menu_Language_Preferences.Character_Information_Button_Language.Lore3");
		CHARACTER_LORE4 = getString("Roleplay_Menu_Language_Preferences.Character_Information_Button_Language.Lore4");

		// IGNORE RP
		IGNORE_LOCAL_TITLE = getString("Roleplay_Menu_Language_Preferences.Ignore_Local_Chat_Button_Language.Title");
		IGNORE_LOCAL_LORE1 = getString("Roleplay_Menu_Language_Preferences.Ignore_Local_Chat_Button_Language.Lore1");
		IGNORE_LOCAL_LORE2 = getString("Roleplay_Menu_Language_Preferences.Ignore_Local_Chat_Button_Language.Lore2");
		IGNORE_LOCAL_DEF_TRUE = getString("Roleplay_Menu_Language_Preferences.Ignore_Local_Chat_Button_Language.Definition_Of_True");
		IGNORE_LOCAL_DEF_FALSE = getString("Roleplay_Menu_Language_Preferences.Ignore_Local_Chat_Button_Language.Definition_Of_False");
		IGNORE_LOCAL_ANIMATE_TRUE = getString("Roleplay_Menu_Language_Preferences.Ignore_Local_Chat_Button_Language.Animation_Of_Button_To_True");
		IGNORE_LOCAL_ANIMATE_FALSE = getString("Roleplay_Menu_Language_Preferences.Ignore_Local_Chat_Button_Language.Animation_Of_Button_To_False");
		IGNORE_LOCAL_TRUE_MATERIAL = getMaterial("Roleplay_Menu_Settings.Ignore_Local_Chat_Button_Settings.True_Material");
		IGNORE_LOCAL_FALSE_MATERIAL = getMaterial("Roleplay_Menu_Settings.Ignore_Local_Chat_Button_Settings.False_Material");


		// HEARING
		HEARING_TITLE = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Title");
		HEARING_LORE1 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore1");
		HEARING_LORE2 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore2");
		HEARING_LORE3 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore3");
		HEARING_LORE4 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore4");
		HEARING_LORE5 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore5");
		HEARING_LORE6 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore6");
		HEARING_LORE7 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore7");
		HEARING_LORE8 = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Lore8");
		HEARING_ANIMATE = getString("Roleplay_Menu_Language_Preferences.Hearing_Distance_Button_Language.Animation_Of_Button");







	}
}
