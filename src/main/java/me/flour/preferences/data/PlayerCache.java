package me.flour.preferences.data;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.model.ConfigSerializable;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class PlayerCache extends YamlSectionConfig implements ConfigSerializable {

	private static final Map<UUID, PlayerCache> cacheMap = new HashMap<>();



	Boolean visibility;
	Boolean ignoreRP;
	Integer hearingDistance;



	protected PlayerCache(final String uuid) {

		// This will prepend this cache with the players unique id just like you use pathPrefix in SimpleSettings
		super(uuid);

		// Load our player cache from the disk however do not use any default file
		// from our source code
		loadConfiguration(null, "data.db");
	}

	@Override
	protected void onLoadFinish() {

		if (isSet("Hearing"))
			hearingDistance = getInteger("Hearing");
		else if (!isSet("Hearing"))
			hearingDistance = 100;

		if (isSet("IgnoreRP"))
			ignoreRP = getBoolean("IgnoreRP");
		else if (!isSet("IgnoreRP"))
			ignoreRP = false;
		if (isSet("Visibility"))
			visibility = getBoolean("Visibility");
		else if (!isSet("Visibility"))
			visibility = true;





	}


	public void setHearingDistance(final Integer hearing) {
		this.hearingDistance = hearing;
		save("Hearing",hearing);
	}
	public void setIgnoreRP(final Boolean ignoreRP) {
		this.ignoreRP = ignoreRP;
		save("IgnoreRP", ignoreRP);
	}
	public void setVisibility(final Boolean visibility) {
		this.visibility = visibility;
		save("Visibility",visibility);
	}





	@Override
	public SerializedMap serialize() {
		final SerializedMap map = new SerializedMap();

		map.put("IgnoreRP", ignoreRP);
		map.put("Visibility", visibility);
		map.put("Hearing",hearingDistance);
		map.put("Uuid", getSection());

		return map;
	}


	public static PlayerCache getCache(final Player player) {
		PlayerCache cache = cacheMap.get(player.getUniqueId());

		if (cache == null) {
			cache = new PlayerCache(player.getUniqueId().toString());

			cacheMap.put(player.getUniqueId(), cache);
		}

		return cache;
	}
}
