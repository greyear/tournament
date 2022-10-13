package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        if (players.containsKey(player.getName())) {
            return;
        }
        players.put(player.getName(), player);
    }

    public HashMap<String, Player> getRegisteredPlayers() {
        return players;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = null;
        Player player2 = null;

        if (players.containsKey(playerName1)) {
            player1 = players.get(playerName1);
        }

        if (players.containsKey(playerName2)) {
            player2 = players.get(playerName2);
        }

        if (player1 == null) {
            throw new NotRegisteredException("Player " + player1 + "is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player " + player2 + "is not registered");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;

    }

}
