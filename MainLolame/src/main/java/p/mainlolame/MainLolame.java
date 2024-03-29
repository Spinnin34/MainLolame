package p.mainlolame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import p.mainlolame.Commad.NumeroCommad;
import p.mainlolame.Listener.PlayerJoinListener;
import p.mainlolame.Manager.BlockCommandsManger;
import p.mainlolame.papi.PlaholderAPI;

public final class MainLolame extends JavaPlugin {

    private BlockCommandsManger blockCommandsManger;

    @Override
    public void onEnable() {
        getLogger().info("Plugin habilitado Developer ©Spinnin34");

        new PlayerJoinListener(this);
        getCommand("numero").setExecutor(new NumeroCommad());

        blockCommandsManger = new BlockCommandsManger(getDataFolder());

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaholderAPI(this).register();
        } else {
            getLogger().warning("PlaceholderAPI no encontrado. Algunos placeholders no funcionarán.");
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin deshabilitado Developer ©Spinnin34");
        // Plugin shutdown logic
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    public BlockCommandsManger getBlockCommandsManger() {
        return blockCommandsManger;
    }
}
