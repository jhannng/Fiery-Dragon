package org.example.fierydragon;

/***
 * A class that represent Game
 * Created by: Jui Kai
 * @author Jui Kai
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

    private GameBoard gameBoard;
    private ArrayList<Player> gamePlayers = new ArrayList<>();
    private ArrayList<ChitCard> dragonCard = new ArrayList<>();
    private Player currentPlayer;
    private ArrayList<Subscriber> subscribers = new ArrayList<>();

    /**
     * Constructor
     *
     * @param numberOfPlayer
     * @param playerName
     * @param subscriber
     */
    public Game(int numberOfPlayer, ArrayList<String> playerName, Subscriber subscriber) {
        this.gameBoard = new GameBoard();

        this.initialiseChitCard(new BatChitCardFactory(), 1, 3);
        this.initialiseChitCard(new SpiderChitCardFactory(), 1, 3);
        this.initialiseChitCard(new DragonChitCardFactory(), 1, 3);
        this.initialiseChitCard(new SalamanderChitCardFactory(), 1, 3);
        this.initialiseChitCard(new DragonPirateChitCardFactory(), 2, 2);

        long seed = 322;
        Collections.shuffle(this.dragonCard, new Random(seed));

        this.initialisePlayer(numberOfPlayer, playerName);
        this.initialiseCaveToken();

        this.subscribe(subscriber);
    }

    /**
     * This method add the subscriber
     *
     * @param subscriber
     */
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    /**
     * This method remove the subscriber
     * @param subscriber
     */
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    /**
     * This method will invoke all the subscriber
     *
     * @param gameBoard
     * @param currentPlayer
     */
    public void notifySubscribe(GameBoard gameBoard, Player currentPlayer) {
        for (Subscriber subscriber: this.subscribers) {
            subscriber.update(gameBoard, currentPlayer);
        }
    }

    /**
     * This method initialise the ChitCard
     *
     * @param chitCardFactory
     * @param cardQuantity
     * @param moveStep
     */
    private void initialiseChitCard(ChitCardFactory chitCardFactory, int cardQuantity, int moveStep) {
        for (int quantity = 0; quantity < cardQuantity; quantity = quantity + 1) {
            for (int step = 1; step <= moveStep; step = step + 1) {
                ChitCard newChitCard = chitCardFactory.createChitCard(step);
                this.dragonCard.add(newChitCard);
            }
        }
    }

    /**
     * This method initialise Player
     *
     * @param numberOfPlayer
     * @param playerName
     */
    private void initialisePlayer(int numberOfPlayer, ArrayList<String> playerName) {
        for (int idx = 1; idx <= numberOfPlayer; idx = idx + 1) {
            Player newPlayer = new Player(idx, playerName.get(idx - 1));
            this.gamePlayers.add(newPlayer);
        }

        this.currentPlayer = gamePlayers.get(0);
    }

    /**
     * This method initialise caveToken
     */
    private void initialiseCaveToken() {
        Square currentSquare;

        for (int i = 0; i < gameBoard.getGameBoard().size(); i ++) {
            for (int j = 0; j < gameBoard.getGameBoard().get(i).getVolcanoCard().size(); j ++) {
                currentSquare = gameBoard.getGameBoard().get(i).getVolcanoCard().get(j);

                if (currentSquare.isHasCave()) {
                    int tokenIdx = currentSquare.getCave().getCaveID();
                    Token tokenPlayer = gamePlayers.get(tokenIdx - 1).getToken();

                    currentSquare.getCave().addCaveToken(tokenPlayer);
                }
            }
        }
    }

    /**
     * This method return gameBoard
     *
     * @return a list of volcanoCard
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * This method will run the mockGame for Sprint 2
     */
    public void runMockGame() {
        this.currentPlayer = this.gamePlayers.get(0);

        Action moveForward = new MoveForward(this.currentPlayer, 23);
        moveForward.executeAction(this.gameBoard);

        this.notifySubscribe(this.gameBoard, currentPlayer);
    }

    /**
     * This method will run the Simulator based on pre defined scenario for Sprint 2
     */
    public void runSimulator() {
        this.currentPlayer = this.gamePlayers.get(0);

        Action moveForward = new MoveForward(this.currentPlayer, 2);
        moveForward.executeAction(this.gameBoard);

        this.notifySubscribe(this.gameBoard, currentPlayer);
    }

    @Override
    public String toString() {
        String gamePlayers = "";

        for (int idx = 0; idx < this.gamePlayers.size(); idx = idx + 1) {
            gamePlayers += this.gamePlayers.get(idx).toString() + " ";
        };

        String chitCard = "";

        for (int idx = 0; idx < this.dragonCard.size(); idx = idx + 1) {
            chitCard = chitCard + this.dragonCard.get(idx).toString();
        }

        return String.format("Fiery Dragon Game \nGame Players: %s \nCurrent Player: %s", gamePlayers, currentPlayer.toString());
    }
}
