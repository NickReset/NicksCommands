package me.nickrest;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    /* instance */
    @Getter
    private static Plugin instance;

    public void onEnable() {
        instance = this;
    }

}
