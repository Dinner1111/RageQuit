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
        boolean canRQ = true;
        if (cmd.getName().equalsIgnoreCase("rq")) {
            if (sender.hasPermission("RageQuit.Rage")) {
                if (sender instanceof Player) {
                    if (args.length == 1 ) {
                        if (args[0].equalsIgnoreCase("-c") && sender.hasPermission("RageQuit.Rage.Console")) {
                            canRQ = false;
                            consoleRQ();
                        } else {
                            sender.sendMessage(ChatColor.DARK_RED + "Invalid flag.");
                            sender.sendMessage(ChatColor.DARK_RED + "Usage: /rq [-c]");
                        }
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + "Too many arguments.");
                        sender.sendMessage(ChatColor.DARK_RED + "Usage: /rq [-c]");
                    }
                    Player p = (Player) sender;
                    if (canRQ == true) {
                        getServer().broadcastMessage(ChatColor.AQUA + p.getName() + ChatColor.GRAY + " has " + ChatColor.DARK_RED + "rage quit" + ChatColor.GRAY + "!");
                        p.kickPlayer(ChatColor.GRAY + "You " + ChatColor.DARK_RED + "rage quit" + ChatColor.GRAY + "!");
                        getLogger().info(p.getName() + " rage quit. Hah.");
                        
                    }
                    return true;
                } else {
                    consoleRQ();
                }
            }
        }
        return true;
    }
    public void consoleRQ() {
        task = Bukkit.getServer().getScheduler()
                .scheduleSyncRepeatingTask(this, new Runnable() {
                    public void run() {
                        switch (n) {
                        case 0:
                            getServer().broadcastMessage(ChatColor.GRAY + "Oh no! " + ChatColor.DARK_RED + "Console " + ChatColor.GRAY + "seems to be building up rage!");
                            n = n + 1;
                            break;
                        case 1:
                            getServer().broadcastMessage(ChatColor.GRAY + "Oh my... " + ChatColor.DARK_RED + "Console" + ChatColor.GRAY + " is boiling with rage...");
                            n = n + 1;
                            break;
                        case 2:
                            getServer().broadcastMessage(ChatColor.GRAY + "OH NO, EVERYONE RUN," + ChatColor.DARK_RED + " CONSOLE" + ChatColor.GRAY + " IS GOING TO RAGE!!!");
                            n = n + 1;
                            break;
                        case 3:
                            getServer().broadcastMessage(ChatColor.GRAY + "NOOOOOOOOO " + ChatColor.DARK_RED + "CONSOLE" + ChatColor.GRAY + " HAS RAGE QUIT!!!!!");
                            n = n + 1;
                            break;
                        case 4:
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                p.kickPlayer(ChatColor.DARK_RED + "Console " + ChatColor.GRAY + "has rage quit!");
                                Bukkit.getServer().shutdown();
                            }
                        }
                    }
                }, 0, 40);
    }
}
