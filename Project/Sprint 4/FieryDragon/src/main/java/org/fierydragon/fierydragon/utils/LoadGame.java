package org.fierydragon.fierydragon.utils;

import org.fierydragon.fierydragon.GameBoard;
import org.fierydragon.fierydragon.GameUI;
import org.fierydragon.fierydragon.Player;
import org.fierydragon.fierydragon.animal.*;
import org.fierydragon.fierydragon.chitcard.ChitCard;
import org.fierydragon.fierydragon.tile.Tile;
import org.fierydragon.fierydragon.volcano.Volcano;
import org.fierydragon.fierydragon.volcano.VolcanoBuilder;
import org.fierydragon.fierydragon.volcano.VolcanoDirector;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A class that use to load the previous game stats in the game.
 * Created by:
 *  @author Lim Jian Tao and Lee Yi Mei
 */
public class LoadGame {
    /**
     * The path that store the use to store the text file
     */
    private Path filePath;
    /**
     * The game board that store in the game
     */
    private GameBoard gameBoard;
    /**
     * The players in the game
     */
    private ArrayList<Player> players;
    /**
     * The turn that indicate current player
     */
    private int currPlayerTurn;

    /**
     * Constructor
     */
    public LoadGame() {
        this.filePath = Paths.get("src/main/resources/savedGame.txt");
        this.players = new ArrayList<>();
    }

    /**
     * This is a method that use to load the game when player opt to continue previous game.
     */
    public void loadGame() {
        try (Scanner scanner = new Scanner(filePath)) {
            ArrayList<Volcano> volcanoes = new ArrayList<>();
            ArrayList<ChitCard> chitCards = new ArrayList<>();

            // Animals
            Animal1 animal1 = new Animal1();
            Animal2 animal2 = new Animal2();
            Animal3 animal3 = new Animal3();
            Animal4 animal4 = new Animal4();
            BadAnimal1 badAnimal1 = new BadAnimal1();
            GoodAnimal1 goodAnimal1 = new GoodAnimal1();
            SpecialAnimal1 specialAnimal1 = new SpecialAnimal1();
            HashMap<String, Animal> animalHashMap = new HashMap<>();
            animalHashMap.put(AnimalType.ANIMAL1.toString(), animal1);
            animalHashMap.put(AnimalType.ANIMAL2.toString(), animal2);
            animalHashMap.put(AnimalType.ANIMAL3.toString(), animal3);
            animalHashMap.put(AnimalType.ANIMAL4.toString(), animal4);
            animalHashMap.put(AnimalType.BAD_ANIMAL1.toString(), badAnimal1);
            animalHashMap.put(AnimalType.GOOD_ANIMAL1.toString(), goodAnimal1);
            animalHashMap.put(AnimalType.SPECIAL_ANIMAL1.toString(), specialAnimal1);

            // Theme
            GameUI.theme = Theme.valueOf(scanner.nextLine());

            // Chit Card
            int chitCardCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < chitCardCount; i++) {
                String[] animalInfo = scanner.nextLine().split(",");

                // Create chit card
                ChitCard chitCard = new ChitCard(animalHashMap.get(animalInfo[0]), Integer.parseInt(animalInfo[1]));
                chitCards.add(chitCard);
            }

            // Volcano
            VolcanoDirector director = new VolcanoDirector();
            VolcanoBuilder builder = new VolcanoBuilder();
            int volcanoCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < volcanoCount; i++) {
                // If volcano has cave
                Animal caveAnimal = null;
                boolean hasCave = Boolean.parseBoolean(scanner.nextLine());
                if (hasCave) {
                    caveAnimal = animalHashMap.get(scanner.nextLine());
                }

                // Square
                int squareCount = Integer.parseInt(scanner.nextLine());
                Animal[] squareAnimal = new Animal[squareCount];
                for (int j = 0; j < squareCount; j++) {
                    squareAnimal[j] = animalHashMap.get(scanner.nextLine());
                }

                if (hasCave) {
                    volcanoes.add(director.constructCaveVolcano(builder, caveAnimal, squareAnimal));
                } else {
                    volcanoes.add(director.constructVolcano(builder, squareAnimal));
                }
            }

            this.gameBoard = new GameBoard(chitCards, volcanoes);
            this.gameBoard.createLinks();

            // Player
            int playerCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < playerCount; i++) {
                // Initialise player (with name)
                Player player = new Player(scanner.nextLine(), i+1);

                // Match tile
                Tile currTile = gameBoard.getTileByIndex(Integer.parseInt(scanner.nextLine()));
                currTile.setToken(player.getPlayerToken());
                player.getPlayerToken().setTile(currTile);

                // Assign total displacement
                player.getPlayerToken().displacementDone(Integer.parseInt(scanner.nextLine()));

                players.add(player);
            }

            // Current player turn
            this.currPlayerTurn = Integer.parseInt(scanner.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter method that return a list of players
     *
     * @return A list of players that store in the game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Getter method that return the game board in the game
     *
     * @return Game Board that store in the game
     */
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    /**
     * Getter method that return the turn of current player
     *
     * @return Current player turn in the game
     */
    public int getCurrPlayerTurn() {
        return this.currPlayerTurn;
    }
}