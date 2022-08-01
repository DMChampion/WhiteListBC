package iafenvoy.whitelistpp;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class WhiteListCommand extends Command {
    public WhiteListCommand() {
        super("whitelistbc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!WhiteListManager.INSTANCE.hasPermission(sender.getName())) {
            sender.sendMessage(new ComponentBuilder("You don't have permission to do that").color(ChatColor.RED).create());
            return;
        }
        if (args.length == 0) {
            sender.sendMessage(new ComponentBuilder("Require at least 1 arguments").color(ChatColor.RED).create());
            return;
        }
        final String key = args[0];
        if (key.equals("add")) {
            if (args.length == 1) {
                sender.sendMessage(new ComponentBuilder("Require player name").color(ChatColor.RED).create());
                return;
            }
            String name = args[1];
            WhiteListManager.INSTANCE.addPlayer(name);
            sender.sendMessage(new ComponentBuilder("Succeeded add player named " + name).color(ChatColor.GREEN).create());
        } else if (key.equals("remove")) {
            if (args.length == 1) {
                sender.sendMessage(new ComponentBuilder("Require player name").color(ChatColor.RED).create());
                return;
            }
            String name = args[1];
            boolean success = WhiteListManager.INSTANCE.removePlayer(name);
            if (success)
                sender.sendMessage(new ComponentBuilder("Succeeded remove player named " + name).color(ChatColor.GREEN).create());
            else
                sender.sendMessage(new ComponentBuilder("Can't find player named " + name).color(ChatColor.RED).create());
        } else if (key.equals("list"))
            sender.sendMessage(new ComponentBuilder(WhiteListManager.INSTANCE.getWhiteList()).color(ChatColor.WHITE).create());
        if (key.equals("op")) {
            if (args.length == 1) {
                sender.sendMessage(new ComponentBuilder("Require player name").color(ChatColor.RED).create());
                return;
            }
            String name = args[1];
            WhiteListManager.INSTANCE.addOP(name);
            sender.sendMessage(new ComponentBuilder("Succeeded oped player named " + name).color(ChatColor.GREEN).create());
        } else if (key.equals("deop")) {
            if (args.length == 1) {
                sender.sendMessage(new ComponentBuilder("Require player name").color(ChatColor.RED).create());
                return;
            }
            String name = args[1];
            boolean success = WhiteListManager.INSTANCE.removeOP(name);
            if (success)
                sender.sendMessage(new ComponentBuilder("Succeeded deop player named " + name).color(ChatColor.GREEN).create());
            else
                sender.sendMessage(new ComponentBuilder("Can't find player named " + name).color(ChatColor.RED).create());
        } else {
            sender.sendMessage(new ComponentBuilder("Usage").color(ChatColor.WHITE).create());
            sender.sendMessage(new ComponentBuilder("/whitelistbc add <playername>  Add a player to white list").color(ChatColor.WHITE).create());
            sender.sendMessage(new ComponentBuilder("/whitelistbc remove <playername>  Remove a player from white list").color(ChatColor.WHITE).create());
            sender.sendMessage(new ComponentBuilder("/whitelistbc list  Show players in white list").color(ChatColor.WHITE).create());
        }
    }
}
