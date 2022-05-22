package me.nickrest.util;

import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

@UtilityClass
public class NameTagEdit {

    public static void setNameTag(Player player, String name) {
        String prefix = name.split(" ")[0];

        // if the name equals the player's name remove the player's team
        if (Objects.equals(player.getName(), name)) {
            Team team = player.getScoreboard().getTeam(player.getName());
            if (team != null) {
                team.unregister();
            }
            player.setDisplayName(player.getName());
            player.setPlayerListName(player.getName());
            return;
        }

        // if the team is in use remove it
        if (player.getScoreboard().getTeam(prefix + " " + player.getName()) != null) {
            Objects.requireNonNull(player.getScoreboard().getTeam(prefix + " " + player.getName())).unregister();
        }

        // create a new team
        Team team = player.getScoreboard().registerNewTeam(prefix + " " + player.getName());



        team.setPrefix(prefix);
        team.addEntry(player.getName());
        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
    }

    public static void removeNameTag(Player player) {
        Team team = player.getScoreboard().getTeam(player.getName());
        if (team != null) {
            team.unregister();
        }
        player.setDisplayName(player.getName());
        player.setPlayerListName(player.getName());
    }
}
