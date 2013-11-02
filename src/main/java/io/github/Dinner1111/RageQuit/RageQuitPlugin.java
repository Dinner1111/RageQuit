package io.github.Dinner1111.RageQuit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RageQuitPlugin extends JavaPlugin implements CommandExecutor {
    int task;
    int n = 0;
    @Override
    public void onEnable() {
        getLogger().info("Time to rage!");
    }
    @Override
    public void onDisable() {
        getLogger().info("Had enough rage?");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLine, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rq")) {
            if (sender.hasPermission("RageQuit.Rage")) {
                if (sender instanceof Player) {
                    if (args.length == 0) {
                        Player p = (Player) sender;
                        getServer().broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " has " + ChatColor.AQUA + "rage quit" + ChatColor.GRAY + "!");
                        p.kickPlayer(ChatColor.GRAY + "You " + ChatColor.AQUA + "rage quit" + ChatColor.GRAY + "!");
                        getLogger().info(p.getDisplayName() + " rage quit. Hah.");
                        return true;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("-c") && sender.hasPermission("RageQuit.ConsoleRage")) {
                            consoleRQ();
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.GRAY + "Invalid flag.");
                            sender.sendMessage(ChatColor.GRAY + "Usage: " + ChatColor.AQUA + "/rq [-c]");
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.GRAY + "Too many arguments.");
                        sender.sendMessage(ChatColor.GRAY + "Usage: " + ChatColor.AQUA + "/rq [-c]");
                        return true;
                    }
                } else {
                    consoleRQ();
                    return true;
                }
            }
        }
        return false;
    }
    public void consoleRQ() {
        task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                switch (n) {
                case 0:
                    getServer().broadcastMessage(ChatColor.GRAY + "Oh no! " + ChatColor.GOLD + "*" + ChatColor.RED + "Console" + ChatColor.GRAY + " seems to be building up rage!");
                    n++;
                    break;
                case 1:
                    getServer().broadcastMessage(ChatColor.GRAY + "Oh my... " + ChatColor.GOLD + "*" + ChatColor.RED + "Console" + ChatColor.GRAY + " is boiling with rage...");
                    n++;
                    break;
                case 2:
                    getServer().broadcastMessage(ChatColor.GRAY + "OH NO, EVERYONE RUN, " + ChatColor.GOLD + "*" + ChatColor.RED + "Console" + ChatColor.GRAY + " IS GOING TO RAGE!!!");
                    n++;
                    break;
                case 3:
                    getServer().broadcastMessage(ChatColor.GRAY + "NOOOOOOOOO " + ChatColor.GOLD + "*" + ChatColor.RED + "Console" + ChatColor.GRAY + " HAS RAGE QUIT!!!!!");
                    n++;
                    break;
                case 4:
                    for (Player p : Bukkit.getOnlinePlayers())
                        p.kickPlayer(ChatColor.DARK_RED + "Console " + ChatColor.GRAY + "has rage quit!");
                    Bukkit.getServer().shutdown();
                }
            }
        }, 0, 40);
    }
}
