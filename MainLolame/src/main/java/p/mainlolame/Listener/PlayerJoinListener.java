package p.mainlolame.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;


public class PlayerJoinListener implements Listener {

    private final JavaPlugin plugin;
    private final Map<String, Integer> playerSuffixMap;

    public PlayerJoinListener(JavaPlugin plugin) {
        this.plugin = plugin;
        this.playerSuffixMap = new HashMap<>();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        int suffixNumber = playerSuffixMap.getOrDefault(playerName, 1) + 1;
        playerSuffixMap.put(playerName, suffixNumber);
        event.getPlayer().setDisplayName(playerName + "§x§0§5§B§6§8§6#" +  suffixNumber);
    }
}
