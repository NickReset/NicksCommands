package me.nickrest.util;

import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

@UtilityClass
public class NameTagEdit {

    public static void setNameTag(Player player, String name) {
        Team team = player.getScoreboard().getTeam(player.getName());
        if (team == null) {
            team = player.getScoreboard().registerNewTeam(player.getName());
        }
        team.setPrefix(name);
        team.setDisplayName(name);
        team.setAllowFriendlyFire(false);
        team.setCanSeeFriendlyInvisibles(true);
        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
        team.setOption(Team.Option.DEATH_MESSAGE_VISIBILITY, Team.OptionStatus.NEVER);
        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
    }
}
