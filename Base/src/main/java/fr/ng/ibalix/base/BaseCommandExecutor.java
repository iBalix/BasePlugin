package main.java.fr.ng.ibalix.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BaseCommandExecutor implements CommandExecutor {

    private final Base p;

    public BaseCommandExecutor(Base p) {
        this.p = p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		/*
		 * Commande upgrade
		 * Check si le joueur doit upgrade
		 */
        if (cmd.getName().equalsIgnoreCase("test")) {
            p.getLogger().info("Ceci est le plugin de base");
            return true;
        }
        return false;
    }
}
