package me.crazybanana.shopgui.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.ChatColor.*;

public class Shop implements CommandExecutor, Listener {
    // Vars
    public Inventory shopMenuInv;
    private String title = AQUA + "[" + GOLD + "Shop" + AQUA + "]";

    // Command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Player?
        if(sender instanceof Player) {
            // Perm?
            if(sender.hasPermission("shop.use")) {
                // GUI Open *Shop Menu*
                ((Player) sender).openInventory(shopMenuInv);
                return true;
            }
        }
        return false;
    }

    // Click Event Handler
    @EventHandler()
    public void onClick(InventoryClickEvent event) {
        // Checks
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "essentials:bc I'm in the onClick");
        if(!event.getInventory().equals(shopMenuInv)) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);
    }

    // Inventory Creation *ShopMenu*
    public void createInvShopMenu() {
        // Creation
        shopMenuInv = Bukkit.createInventory(null, 54, title);

        // Create item
        // LightBlueGlass *Empty*
        ItemStack empty = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName(BLACK + "");
        empty.setItemMeta(emptyMeta);
        // Work Stations *ws*
        ItemStack ws = new ItemStack(Material.STONECUTTER, 1);
        ItemMeta wsM = ws.getItemMeta();
        wsM.setDisplayName(GOLD + "Work Stations");
        ArrayList<String> wsL = new ArrayList<String>();
        wsL.add(AQUA + "Have your villager get professions");
        wsM.setLore(wsL);
        ws.setItemMeta(wsM);

        // Placing items
        // Empty
        // Top
        shopMenuInv.setItem(0, empty);
        shopMenuInv.setItem(1, empty);
        shopMenuInv.setItem(2, empty);
        shopMenuInv.setItem(3, empty);
        shopMenuInv.setItem(4, empty);
        shopMenuInv.setItem(5, empty);
        shopMenuInv.setItem(6, empty);
        shopMenuInv.setItem(7, empty);
        shopMenuInv.setItem(8, empty);
        // Bottom
        shopMenuInv.setItem(45, empty);
        shopMenuInv.setItem(46, empty);
        shopMenuInv.setItem(47, empty);
        shopMenuInv.setItem(48, empty);
        shopMenuInv.setItem(49, empty);
        shopMenuInv.setItem(50, empty);
        shopMenuInv.setItem(51, empty);
        shopMenuInv.setItem(52, empty);
        shopMenuInv.setItem(53, empty);
        // Placing Items
        Integer workStation = 12;
    }
}
