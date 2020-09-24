package me.crazybanana.shopgui;

import me.crazybanana.shopgui.commands.Shop;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShopGUI extends JavaPlugin implements Listener {
    // Var
    Shop s = new Shop();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(s, this);
        getCommand("shop").setExecutor(s);
        s.createInvShopMenu();
    }
}
