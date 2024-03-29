package p.mainlolame.papi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import p.mainlolame.MainLolame;

public class PlaholderAPI extends PlaceholderExpansion {

    private MainLolame plugin;
    public PlaholderAPI(MainLolame plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "MainLolame";
    }

    @Override
    public String getAuthor() {
        return "Spinnin34";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) {
            return ""; //%lolame_numero%
        }
        return null;
    }
}
