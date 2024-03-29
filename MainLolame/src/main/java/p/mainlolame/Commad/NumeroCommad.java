package p.mainlolame.Commad;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import p.mainlolame.Manager.MessageUtils;

public class NumeroCommad implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("lolame.admin.numero")) {
            sender.sendMessage("§f[§cLolame Main§f] §cNo tienes permisos.");
            return true;
        }
        if (command.getName().equalsIgnoreCase("numero")) {
            if (args.length < 1 || args.length > 2) {
                sender.sendMessage("Uso: /numero <numero> [jugador]");
                return true;
            }
            int numero;
            try {
                numero = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                sender.sendMessage("§f[§x§0§5§B§6§8§6L§x§1§3§B§D§8§9o§x§2§1§C§3§8§Cl§x§2§F§C§A§8§Fa§x§3§D§D§1§9§2m§x§4§B§D§7§9§5e §x§5§A§D§E§9§8S§x§6§8§E§4§9§Bt§x§7§6§E§B§9§Eu§x§8§4§F§2§A§1d§x§9§2§F§8§A§4i§x§A§0§F§F§A§7o§f] §cEse numero no es valido");
                return true;
            }

            if (args.length == 1) {
                if (!(sender instanceof Player)){
                    sender.sendMessage("§f[§x§0§5§B§6§8§6L§x§1§3§B§D§8§9o§x§2§1§C§3§8§Cl§x§2§F§C§A§8§Fa§x§3§D§D§1§9§2m§x§4§B§D§7§9§5e §x§5§A§D§E§9§8S§x§6§8§E§4§9§Bt§x§7§6§E§B§9§Eu§x§8§4§F§2§A§1d§x§9§2§F§8§A§4i§x§A§0§F§F§A§7o§f] §cDebes ser un jugador para usar este comando sin especificar un jugador");
                    return true;
                }
                Player player = (Player) sender;
                player.setDisplayName(player.getName() + "§x§0§5§B§6§8§6#" + numero);
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
                sender.sendMessage(MessageUtils.sendCenteredMessage("§x§0§5§B§6§8§6L§x§1§3§B§D§8§9o§x§2§1§C§3§8§Cl§x§2§F§C§A§8§Fa§x§3§D§D§1§9§2m§x§4§B§D§7§9§5e §x§5§A§D§E§9§8S§x§6§8§E§4§9§Bt§x§7§6§E§B§9§Eu§x§8§4§F§2§A§1d§x§9§2§F§8§A§4i§x§A§0§F§F§A§7o"));
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
                sender.sendMessage(MessageUtils.sendCenteredMessage("§fTu numero ha sido establecido como §x§0§5§B§6§8§6#" + numero));
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
                sender.sendMessage(MessageUtils.sendCenteredMessage("§7Developer ©Spinnin34"));
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
            } else {
                Player target = Bukkit.getPlayer(args[1]);
                if (target == null || !target.isOnline()) {
                    sender.sendMessage("§f[§x§0§5§B§6§8§6L§x§1§3§B§D§8§9o§x§2§1§C§3§8§Cl§x§2§F§C§A§8§Fa§x§3§D§D§1§9§2m§x§4§B§D§7§9§5e §x§5§A§D§E§9§8S§x§6§8§E§4§9§Bt§x§7§6§E§B§9§Eu§x§8§4§F§2§A§1d§x§9§2§F§8§A§4i§x§A§0§F§F§A§7o§f] §cNo se encotro al jugador");
                    return true;
                }
                target.setDisplayName(target.getName() + "§x§0§5§B§6§8§6#" + numero);
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
                sender.sendMessage(MessageUtils.sendCenteredMessage("§x§0§5§B§6§8§6L§x§1§3§B§D§8§9o§x§2§1§C§3§8§Cl§x§2§F§C§A§8§Fa§x§3§D§D§1§9§2m§x§4§B§D§7§9§5e §x§5§A§D§E§9§8S§x§6§8§E§4§9§Bt§x§7§6§E§B§9§Eu§x§8§4§F§2§A§1d§x§9§2§F§8§A§4i§x§A§0§F§F§A§7o"));
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
                sender.sendMessage(MessageUtils.sendCenteredMessage("§7El numero de §c" + target.getName() + "§7 ha sido establecido como §x§0§5§B§6§8§6#" + numero));
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
                sender.sendMessage(MessageUtils.sendCenteredMessage("§7Developer ©Spinnin34"));
                sender.sendMessage(MessageUtils.sendCenteredMessage(" "));
            }

            return true;
        }
        return false;
    }
}
