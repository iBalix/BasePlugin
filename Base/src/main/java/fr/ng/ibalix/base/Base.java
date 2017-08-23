package main.java.fr.ng.ibalix.base;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import java.io.File;
import java.io.IOException;

public class Base extends JavaPlugin {

    public Permission permission;
    public Economy econ = null;
    public FileConfiguration dataConfig = null;
    public File dataFile = null;

    @Override
    public void onEnable() {
        getLogger().info("Plugin Base activé");

        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        setupPermissions();
        setupEconomy();

        // Génération config
        this.saveDefaultConfig();

        // Load data config
        this.dataFile = new File(this.getDataFolder(), "data.yml");
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        this.dataConfig = YamlConfiguration.loadConfiguration(dataFile);

        // Initialisation des Commandes
        this.getCommand("test").setExecutor(new BaseCommandExecutor(this));
    }

    // Activation du plugin
    @Override
    public void onDisable() {
        getLogger().info("Plugin Base désactivé");
    }

    private void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        permission = rsp.getProvider();
    }

    private void setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        econ = rsp.getProvider();
    }
}
