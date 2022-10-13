package ru.netology.manager;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player testPlayer1 = new Player(1, "Vasya", 5);
    Player testPlayer2 = new Player(2, "Petya", 10);
    Player testPlayer3 = new Player(8, "Masha", 3);
    Player testPlayer4 = new Player(4, "Vova", 5);

    @Test
    public void emptyRegisterTest() {
        Game game = new Game();
        List<Player> actual = game.getRegisteredPlayers();
        List<Player> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    public void singleRegisterTest() {
        Game game = new Game();
        game.register(testPlayer1);
        List<Player> actual = game.getRegisteredPlayers();
        List<Player> expected = List.of(testPlayer1);
        assertEquals(expected, actual);
    }

    @Test
    public void multipleRegisterTest() {
        Game game = new Game();
        game.register(testPlayer1);
        game.register(testPlayer2);
        List<Player> actual = game.getRegisteredPlayers();
        List<Player> expected = List.of(testPlayer1, testPlayer2);
        assertEquals(expected, actual);
    }

    @Test
    public void multipleRegisterWithRepeatTest() {
        Game game = new Game();
        game.register(testPlayer1);
        game.register(testPlayer1);
        List<Player> actual = game.getRegisteredPlayers();
        List<Player> expected = List.of(testPlayer1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotRegisteredExceptionPlayer1() {
        Game game = new Game();
        game.register(testPlayer1);
        game.register(testPlayer2);
        assertThrows(NotRegisteredException.class, () -> game.round("Vova", "Vasya"));
    }

    @Test
    public void shouldThrowNotRegisteredExceptionPlayer2() {
        Game game = new Game();
        game.register(testPlayer1);
        game.register(testPlayer2);
        assertThrows(NotRegisteredException.class, () -> game.round("Petya", "Masha"));
    }

    @Test
    public void roundTestFirstPlayerIsStronger() {
        Game game = new Game();
        game.register(testPlayer1);
        game.register(testPlayer2);
        game.register(testPlayer3);
        game.register(testPlayer4);
        assertEquals(game.round("Vova", "Masha"),1);
    }

    @Test
    public void roundTestSecondPlayerIsStronger() {
        Game game = new Game();
        game.register(testPlayer1);
        game.register(testPlayer2);
        game.register(testPlayer3);
        game.register(testPlayer4);
        assertEquals(game.round("Vasya", "Petya"),2);
    }

    @Test
    public void roundTestStrengthIsEqual() {
        Game game = new Game();
        game.register(testPlayer1);
        game.register(testPlayer2);
        game.register(testPlayer3);
        game.register(testPlayer4);
        assertEquals(game.round("Vasya", "Vova"),0);
    }

}