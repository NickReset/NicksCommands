package me.nickrest.util;

import lombok.experimental.UtilityClass;
import org.bukkit.BanList;
import org.bukkit.Bukkit;

import java.util.Date;
import java.util.Objects;

@UtilityClass
public class BanUtils {

    public static void banPlayer(String playerName, String reason, String banner) {
        Bukkit.getBanList(BanList.Type.NAME).addBan(playerName, reason, null, banner);
        if(Bukkit.getPlayer(playerName) != null) {
            Objects.requireNonNull(Bukkit.getPlayer(playerName)).kickPlayer(reason);
        }
    }

    public static void tempBanPlayer(String playerName, String reason, String banner, String time) {
        Date date = DataFormater.format(time);
        Bukkit.getBanList(BanList.Type.NAME).addBan(playerName, reason, date, banner);
        if(Bukkit.getPlayer(playerName) != null) {
            Objects.requireNonNull(Bukkit.getPlayer(playerName)).kickPlayer(reason);
        }
    }
}
