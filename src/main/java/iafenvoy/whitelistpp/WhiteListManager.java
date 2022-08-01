package iafenvoy.whitelistpp;

import net.md_5.bungee.api.ProxyServer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WhiteListManager {
    public static final WhiteListManager INSTANCE = new WhiteListManager();
    private List<String> players = new ArrayList<>();
    private List<String> ops = new ArrayList<>();
    private static final String configPath = "./whitelistPP.txt";
    private static final String opPath = "./whitelistPP_OP.txt";

    public WhiteListManager() {
    }

    public void load() {
        players = FileUtil.readFile(configPath);
        ops = FileUtil.readFile(opPath);
    }

    public void save() {
        FileUtil.writeFile(configPath, players);
        FileUtil.writeFile(opPath, players);
    }

    public void addPlayer(String name) {
        players.add(name);
    }

    public boolean removePlayer(String name) {
        if (!players.contains(name)) return false;
        players.remove(name);
        return true;
    }

    public void addOP(String name) {
        ops.add(name);
    }

    public boolean removeOP(String name) {
        if (!ops.contains(name)) return false;
        ops.remove(name);
        return true;
    }

    public String getWhiteList() {
        if (players.isEmpty())
            return "No player in white list";
        StringBuilder sb = new StringBuilder();
        sb.append(players.get(0));
        for (int i = 1; i < players.size(); i++) {
            sb.append("\n");
            sb.append(players.get(i));
        }
        return sb.toString();
    }

    public boolean hasPermission(String name) {
        return ops.contains(name);
    }

    public boolean isInWhiteList(String name) {
        return players.contains(name);
    }
}
