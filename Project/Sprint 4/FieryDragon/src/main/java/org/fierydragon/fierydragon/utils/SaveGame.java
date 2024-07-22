package org.fierydragon.fierydragon.utils;

import org.fierydragon.fierydragon.GameUI;
import org.fierydragon.fierydragon.Player;
import org.fierydragon.fierydragon.TurnManager;
import org.fierydragon.fierydragon.chitcard.ChitCard;
import org.fierydragon.fierydragon.tile.Square;
import org.fierydragon.fierydragon.volcano.Volcano;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * A class that use to save the previous game stats in the game.
 * Created by:
 *  @author Lim Jian Tao and Lee Yi Mei
 */
public class SaveGame {
    /**
     * The path that store the use to store the text file
     */
    private Path filePath;
    /**
     * The content that use to store the stats of the game
     */
    private ArrayList<String> content;

    /**
     * Constructor
     */
    public SaveGame() {
        this.filePath = Paths.get("src/main/resources/savedGame.txt");
        this.content = new ArrayList<>();
    }

    /**
     * This is a method that use to save the game when player opt to leave the game.
     */
    public void saveGame(ArrayList<Volcano> volcanoes, ArrayList<Player> players, ArrayList<ChitCard> chitCards) {
        int[] playerPos = new int[players.size()];
        int squareCount = 0;
        int caveCount = -1;

        // Theme
        this.content.add(String.valueOf(GameUI.theme));

        // Chit Card
        this.content.add(String.valueOf(chitCards.size()));
        for (ChitCard chitCard: chitCards) {
            this.content.add(chitCard.getAnimal().toString() + ',' + chitCard.getAmountOfAnimal());
        }

        // Volcano
        this.content.add(String.valueOf(volcanoes.size()));
        for (Volcano volcano : volcanoes) {
            // If volcano has cave
            if (volcano.hasCave()) {
                this.content.add("true");
                this.content.add(volcano.getCave().getAnimal().toString());

                // Store player position if eligible
                if (volcano.getCave().isOccupied()) {
                    // Find out which player it is
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).getPlayerToken() == volcano.getCave().getToken()) {
                            playerPos[i] = caveCount;
                            break;
                        }
                    }
                }
                caveCount--;
            } else {
                this.content.add("false");
            }

            // Square
            this.content.add(String.valueOf(volcano.getSquares().size()));
            for (Square square: volcano.getSquares()) {
                this.content.add(square.getAnimal().toString());

                // Store player position if eligible
                if (square.isOccupied()) {
                    // Find out which player it is
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).getPlayerToken() == square.getToken()) {
                            playerPos[i] = squareCount;
                            break;
                        }
                    }
                }
                squareCount++;
            }
        }

        // Player
        this.content.add(String.valueOf(players.size()));
        for (int i = 0; i < players.size(); i++) {
            this.content.add(players.get(i).getName());
            this.content.add(String.valueOf(playerPos[i]));
            this.content.add(String.valueOf(players.get(i).getPlayerToken().getTotalDisplacement()));
        }

        // Current turn
        this.content.add(String.valueOf(TurnManager.getInstance().getTurn()));

        try {
            Files.write(this.filePath, String.join("\n", content).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}