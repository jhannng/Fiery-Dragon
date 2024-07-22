package org.fierydragon.fierydragon;
import java.util.ArrayList;

/**
 * A class that represent the Game in FieryDragon application.
 * Created by:
 *  @author Teoh You Xian, Lim Jian Tao, Hang Jui Kai, Lee Yi Mei
 */
public class Game {
    /**
     * The list of players in the game
     */
    private ArrayList<Player> players;
    /**
     * The game board that being used in the game
     */
    private GameBoard gameBoard;

    /**
     * Constructor
     */
    public Game() {
        this.players = new ArrayList<>();
        this.gameBoard = new GameBoard();
    }

    /**
     * This method will initialise the player in the game
     *
     * @param numOfPlayers The number of player in the game
     */
    public void createPlayers(int numOfPlayers){
        for (int i = 0; i < numOfPlayers; i++){
            // TODO: this section require to change in the future
            Player newPlayer = new Player(String.format("Player %s", i + 1), i + 1);
            this.players.add(newPlayer);
        }

        this.gameBoard.assignPlayersCave(this.players);
    }

    /**
     * Getter method that return a list of player in the game
     *
     * @return a list player in the game
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * Getter method that return the game board that used in the game
     *
     * @return the game board that declare in the game
     */
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }
}
