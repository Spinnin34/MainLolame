package p.mainlolame.Manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class BlockCommandsManger {
    private File blockCommandFile;
    private FileConfiguration blockCommandConfig;

    public BlockCommandsManger(File dataFolder) {
        this.blockCommandFile = new File(dataFolder, "blockcommand.yml");
        if (!blockCommandFile.exists()) {
            blockCommandConfig = new YamlConfiguration();
            blockCommandConfig.set("blockedcommands", Collections.emptyList());
            saveConfig();
        } else {
            blockCommandConfig = YamlConfiguration.loadConfiguration(blockCommandFile);
        }
    }
    public  boolean isCommandBlocked(String command) {
        List<String> blockedCommands = blockCommandConfig.getStringList("blockedCommands");
        return blockedCommands.contains(command);
    }
    public void addBlockedCommand(String command) {
        List<String> blockedCommands = blockCommandConfig.getStringList("blockedCommands");
        if (!blockedCommands.contains(command)) {
            blockedCommands.add(command);
            blockCommandConfig.set("blockedCommands",  blockedCommands);
            saveConfig();
        }
    }
    public void removeBlockCommand(String command) {
        List<String> blockedCommands = blockCommandConfig.getStringList("blockedCommands");
        if (blockedCommands.contains(command)) {
            blockedCommands.remove(command);
            blockCommandConfig.set("blockedCommands", blockedCommands);
            saveConfig();
        }
    }
    private void saveConfig() {
        try {
            blockCommandConfig.save(blockCommandFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
