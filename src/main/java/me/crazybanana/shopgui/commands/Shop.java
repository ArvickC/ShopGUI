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
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.ChatColor.*;

public class Shop implements CommandExecutor, Listener {
    // Vars
    public Inventory shopMenuInv;
    private String title = AQUA + "[" + GOLD + "Shop" + AQUA + "]";

    // Items
    private Integer workStation = 12;
    private Integer ores = 13;
    private Integer disc = 14;
    private Integer block = 19;
    private Integer farm = 20;
    private Integer mob = 21;
    private Integer enchant = 22;
    private Integer dye = 23;
    private Integer other = 24;
    private Integer food = 25;
    private Integer sea = 30;
    private Integer spawn = 31;
    private Integer redstone = 32;
    private Integer potion = 40;
    private Integer close = 44;
    private Integer money = 36;

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
        // Work Station
        shopMenuInv.setItem(workStation, createItem(Material.STONECUTTER, "Work Stations", null, DARK_GRAY));
        // Ores
        shopMenuInv.setItem(ores, createItem(Material.IRON_INGOT, "Ores", null, WHITE));
        // Disc
        shopMenuInv.setItem(disc, createItem(Material.MUSIC_DISC_STAL, "Music Discs", "", GOLD));
        // Block
        shopMenuInv.setItem(block, createItem(Material.GRASS_BLOCK, "Blocks", null, DARK_GREEN));
        // Farm
        shopMenuInv.setItem(farm, createItem(Material.WHEAT, "Farming", null, GREEN));
        // Mob
        shopMenuInv.setItem(mob, createItem(Material.GUNPOWDER, "Mob Drops", null, GRAY));
        // Enchant
        shopMenuInv.setItem(enchant, createItem(Material.ENCHANTED_BOOK, "Enchants", null, LIGHT_PURPLE));
        // Dye
        shopMenuInv.setItem(dye, createItem(Material.POPPY, "Dyes", null, RED));
        // Other
        shopMenuInv.setItem(other, createItem(Material.TOTEM_OF_UNDYING, "Others", null, GOLD));
        // Food
        shopMenuInv.setItem(food, createItem(Material.APPLE, "Food", null, RED));
        // Sea
        shopMenuInv.setItem(sea, createItem(Material.TUBE_CORAL, "Ocean", null, BLUE));
        // Spawn
        shopMenuInv.setItem(spawn, createItem(Material.SPAWNER, "Spawners", null, WHITE));
        // Redstone
        shopMenuInv.setItem(redstone, createItem(Material.SPAWNER, "Redstone", null, RED));
        // Potion
        shopMenuInv.setItem(potion, createItem(Material.POTION, "Potions", null, WHITE));

        // Close
        shopMenuInv.setItem(close, createItem(Material.BARRIER, "Close", null, RED));
        // Money
        shopMenuInv.setItem(money, createItem(Material.EMERALD, "Balance", null, GREEN));

    }

    public ItemStack createItem(Material m, String name, String lore, ChatColor c) {
        ItemStack is = new ItemStack(m, 1);
        ItemMeta isM = is.getItemMeta();
        isM.setDisplayName(c + name);
        if(lore != null) {
            ArrayList<String> isL = new ArrayList<String>();
            isL.add(AQUA + lore);
            isM.setLore(isL);
        }
        is.setItemMeta(isM);
        return is;
    }
}