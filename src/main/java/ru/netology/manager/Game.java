package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        for (Player player1 : players) {
            if (player.equals(player1)) return;
        }
        players.add(player);
    }

    public List<Player> getRegisteredPlayers() {
        return players;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
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
