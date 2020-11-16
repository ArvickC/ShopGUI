package me.crazybanana.shopgui.commands;

import me.crazybanana.shopgui.ShopGUI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.ChatColor.*;

public class Shop implements CommandExecutor, Listener {
    // Vars
    public Inventory shopMenuInv;
    public Inventory workStationInv;
    public Inventory oresInv;
    public Inventory discInv;
    public Inventory blockInv;
    public Inventory blockInvP2;
    public Inventory blockInvP3;

    private String title = AQUA + "[" + GOLD + "Shop" + AQUA + "]";
    private String wsTitle = AQUA + "[" + GOLD + "Shop - Work Stations" + AQUA + "]";
    private String oTitle = AQUA + "[" + GOLD + "Shop - Ores" + AQUA + "]";
    private String dTitle = AQUA + "[" + GOLD + "Shop - Disc's" + AQUA + "]";
    private String bTitle = AQUA + "[" + GOLD + "Shop - Blocks" + AQUA + "]";

    private OfflinePlayer cmdSender = null;
    private ConsoleCommandSender console = Bukkit.getConsoleSender();

    Economy economy = ShopGUI.getEconomy();

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
                cmdSender = (OfflinePlayer) sender;
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
        if(event.getInventory().equals(shopMenuInv) || event.getInventory().equals(workStationInv) || event.getInventory().equals(oresInv)) {
            if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

            if(event.getInventory().equals(shopMenuInv))  {
                // Work Stations
                if(event.getCurrentItem().equals(shopMenuInv.getItem(workStation))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(workStationInv);
                    return;
                }
                // Ores
                if(event.getCurrentItem().equals(shopMenuInv.getItem(ores))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(oresInv);
                    return;
                }
                // Disc
                if(event.getCurrentItem().equals(shopMenuInv.getItem(disc))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(discInv);
                    return;
                }
                // Blocks
                if(event.getCurrentItem().equals(shopMenuInv.getItem(block))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(blockInv);
                    return;
                }
            }

            // Close
            if(event.getInventory().equals(workStationInv)) {
                if(event.getCurrentItem().equals(workStationInv.getItem(26))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(shopMenuInv);
                    return;
                }
            }
            if(event.getInventory().equals(oresInv)) {
                if(event.getCurrentItem().equals(oresInv.getItem(35))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(shopMenuInv);
                    return;
                }
            }
            if(event.getInventory().equals(discInv)) {
                if(event.getCurrentItem().equals(discInv.getItem(26))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(shopMenuInv);
                    return;
                }
            }
            if(event.getInventory().equals(blockInv)) {
                if(event.getCurrentItem().equals(blockInv.getItem(53))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(shopMenuInv);
                    return;
                }
            }

            // Pages
            if(event.getInventory().equals(blockInv)) {
                if(event.getCurrentItem().equals(blockInv.getItem(50))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(blockInvP2);
                    return;
                }
            }
            if(event.getInventory().equals(blockInvP2)) {
                if(event.getCurrentItem().equals(blockInvP2.getItem(50))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(blockInvP3);
                    return;
                }
                if(event.getCurrentItem().equals(blockInvP2.getItem(48))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(blockInv);
                    return;
                }
            }
            if(event.getInventory().equals(blockInvP3)) {
                if(event.getCurrentItem().equals(blockInvP3.getItem(50))) {
                    event.getWhoClicked().closeInventory();
                    event.getWhoClicked().openInventory(blockInvP2);
                    return;
                }
            }

            // Exit
            if(event.getCurrentItem().equals(shopMenuInv.getItem(44))) {
                event.getWhoClicked().closeInventory();
            }
            event.setCancelled(true);
        }
    }

    @EventHandler()
    public void onOpen(InventoryOpenEvent event) {
        // Check
        if(event.getInventory().equals(shopMenuInv) || event.getInventory().equals(workStationInv)) {
            String bal = String.valueOf((economy.getBalance(cmdSender)));

            if(event.getInventory().equals(shopMenuInv)) {
                event.getInventory().setItem(money, createItem(Material.EMERALD, "Balance", bal, GREEN));
            } else if(event.getInventory().equals(workStationInv) || event.getInventory().equals(discInv)) {
                event.getInventory().setItem(18, createItem(Material.EMERALD, "Balance", bal, GREEN));
            } else if (event.getInventory().equals(oresInv)) {
                event.getInventory().setItem(27, createItem(Material.EMERALD, "Balance", bal, GREEN));
            } else if (event.getInventory().equals(blockInv) || event.getInventory().equals(blockInvP2) || event.getInventory().equals(blockInvP3)) {
                event.getInventory().setItem(45, createItem(Material.EMERALD, "Balance", bal, GREEN));
            }
        }
    }

    // Inventory Creation *ShopMenu*
    public void createInvShopMenu() {
        // Creation
        shopMenuInv = Bukkit.createInventory(null, 54, title);

        // LightBlueGlass *Empty*
        ItemStack empty = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName(BLACK + "");
        empty.setItemMeta(emptyMeta);


        // Placing items
        // Empty
        for(int i=0;i<9;i++) {
            shopMenuInv.setItem(i, empty);
        }
        for(int i=45;i<54;i++) {
            shopMenuInv.setItem(i, empty);
        }
        // Work Station
        shopMenuInv.setItem(workStation, createItem(Material.STONECUTTER, "Work Stations", null, DARK_GRAY));
        // Ores
        shopMenuInv.setItem(ores, createItem(Material.IRON_INGOT, "Ores", null, WHITE));
        // Disc
        shopMenuInv.setItem(disc, createItem(Material.MUSIC_DISC_STAL, "Music Discs", null, GOLD));
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
        shopMenuInv.setItem(redstone, createItem(Material.REDSTONE, "Redstone", null, RED));
        // Potion
        shopMenuInv.setItem(potion, createItem(Material.POTION, "Potions", null, WHITE));

        // Close
        shopMenuInv.setItem(close, createItem(Material.BARRIER, "Close", null, RED));

    }

    public void createWorkStationShopMenu() {
        // Creation
        workStationInv = Bukkit.createInventory(null, 27, wsTitle);

        // Utilities
        workStationInv.setItem(21, createItem(Material.GRAY_STAINED_GLASS_PANE, "Previous Page", null, RED));
        workStationInv.setItem(22, createItem(Material.COMPASS, "Pages: &81/1", null, GRAY));
        workStationInv.setItem(23, createItem(Material.GRAY_STAINED_GLASS_PANE, "Next Page", null, BLUE));
        workStationInv.setItem(26, createItem(Material.BARRIER, "Exit", null, RED));
    }

    public void createOresShopMenu() {
        // Creation
        oresInv = Bukkit.createInventory(null, 36, oTitle);

        // Utilities
        oresInv.setItem(30, createItem(Material.GRAY_STAINED_GLASS_PANE, "Previous Page", null, RED));
        oresInv.setItem(31, createItem(Material.COMPASS, "Pages: &81/1", null, GRAY));
        oresInv.setItem(32, createItem(Material.GRAY_STAINED_GLASS_PANE, "Next Page", null, BLUE));
        oresInv.setItem(35, createItem(Material.BARRIER, "Exit", null, RED));
    }

    public void createDiscShopMenu() {
        // Creation
        discInv = Bukkit.createInventory(null, 27, dTitle);

        // Utilities
        discInv.setItem(21, createItem(Material.GRAY_STAINED_GLASS_PANE, "Previous Page", null, RED));
        discInv.setItem(22, createItem(Material.COMPASS, "Pages: &81/1", null, GRAY));
        discInv.setItem(23, createItem(Material.GRAY_STAINED_GLASS_PANE, "Next Page", null, BLUE));
        discInv.setItem(26, createItem(Material.BARRIER, "Exit", null, RED));
    }

    public void createBlocksShopMenuP1() {
        // Creation
        blockInv = Bukkit.createInventory(null, 54, bTitle);

        // Utilities
        blockInv.setItem(48, createItem(Material.GRAY_STAINED_GLASS_PANE, "Previous Page", null, RED));
        blockInv.setItem(49, createItem(Material.COMPASS, "Pages: &81/3", null, GRAY));
        blockInv.setItem(50, createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, "Next Page", null, BLUE));
        blockInv.setItem(53, createItem(Material.BARRIER, "Exit", null, RED));
    }

    public void createBlocksShopMenuP2() {
        // Creation
        blockInvP2 = Bukkit.createInventory(null, 54, bTitle);

        // Utilities
        blockInvP2.setItem(48, createItem(Material.RED_STAINED_GLASS_PANE, "Previous Page", null, RED));
        blockInvP2.setItem(49, createItem(Material.COMPASS, "Pages: &82/3", null, GRAY));
        blockInvP2.setItem(50, createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, "Next Page", null, BLUE));
        blockInvP2.setItem(53, createItem(Material.BARRIER, "Exit", null, RED));
    }

    public void createBlocksShopMenuP3() {
        // Creation
        blockInvP3 = Bukkit.createInventory(null, 54, bTitle);

        // Utilities
        blockInvP3.setItem(48, createItem(Material.RED_STAINED_GLASS_PANE, "Previous Page", null, RED));
        blockInvP3.setItem(49, createItem(Material.COMPASS, "Pages: &83/3", null, GRAY));
        blockInvP3.setItem(50, createItem(Material.GRAY_STAINED_GLASS_PANE, "Next Page", null, BLUE));
        blockInvP3.setItem(53, createItem(Material.BARRIER, "Exit", null, RED));
    }

    public ItemStack createItem(Material m, String name, String lore, ChatColor c) {
        ItemStack is = new ItemStack(m, 1);
        ItemMeta isM = is.getItemMeta();
        isM.setDisplayName(ChatColor.translateAlternateColorCodes('&', c + name));
        if(lore != null) {
            ArrayList<String> isL = new ArrayList<String>();
            isL.add(AQUA + lore);
            isM.setLore(isL);
        }
        is.setItemMeta(isM);
        return is;
    }
}