package io.github.Dinner1111.RageQuit;

import io.github.Dinner1111.ChatThemes.ChatThemes;
import io.github.Dinner1111.ChatThemes.ChatThemes.ThemeType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RageQuitPlugin extends JavaPlugin implements CommandExecutor {
	int task;
	int n = 0;
	ChatThemes ct = new ChatThemes(this);
	io.github.Dinner1111.ChatThemes.ThemeColors theme = ct.ThemeColor(ThemeType.COOL_BLUE);
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
						getServer().broadcastMessage(p.getDisplayName() + theme.color3 + " has " + theme.color1 + "rage quit" + theme.color3 + "!");
						p.kickPlayer(theme.color3 + "You " + theme.color1 + "rage quit" + theme.color3 + "!");
						getLogger().info(p.getDisplayName() + " rage quit. Hah.");
						return true;
					}
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("-c") && sender.hasPermission("RageQuit.ConsoleRage")) {
							consoleRQ();
							return true;
						} else {
							sender.sendMessage(theme.color3 + "Invalid flag.");
							sender.sendMessage(theme.color3 + "Usage: " + theme.color1 + "/rq [-c]");
							return true;
						}
					} else {
						sender.sendMessage(theme.color3 + "Too many arguments.");
						sender.sendMessage(theme.color3 + "Usage: " + theme.color1 + "/rq [-c]");
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
                    getServer().broadcastMessage(theme.color3 + "Oh no! " + ChatColor.GOLD + "\u269D" + ChatColor.RED + "Console" + theme.color3 + " seems to be building up rage!");
                    n++;
                    break;
                case 1:
                    getServer().broadcastMessage(theme.color3 + "Oh my... " + ChatColor.GOLD + "\u269D" + ChatColor.RED + "Console" + theme.color3 + " is boiling with rage...");
                    n++;
                    break;
                case 2:
                    getServer().broadcastMessage(theme.color3 + "OH NO, EVERYONE RUN, " + ChatColor.GOLD + "\u269D" + ChatColor.RED + "Console" + theme.color3 + " IS GOING TO RAGE!!!");
                    n++;
                    break;
                case 3:
                    getServer().broadcastMessage(theme.color3 + "NOOOOOOOOO " + ChatColor.GOLD + "\u269D" + ChatColor.RED + "Console" + theme.color3 + " HAS RAGE QUIT!!!!!");
                    n++;
                    break;
                case 4:
                    for (Player p : Bukkit.getOnlinePlayers())
                        p.kickPlayer(ChatColor.GOLD + "\u269D" + ChatColor.DARK_RED + "Console " + theme.color3 + "has rage quit!");
                    Bukkit.getServer().shutdown();
                }
            }
        }, 0, 40);
	}
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
