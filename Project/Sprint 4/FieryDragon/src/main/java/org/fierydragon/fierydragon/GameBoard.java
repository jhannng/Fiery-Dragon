package org.fierydragon.fierydragon;

import org.fierydragon.fierydragon.animal.*;
import org.fierydragon.fierydragon.chitcard.*;
import org.fierydragon.fierydragon.tile.Cave;
import org.fierydragon.fierydragon.tile.Square;
import org.fierydragon.fierydragon.tile.Tile;
import org.fierydragon.fierydragon.volcano.Volcano;
import org.fierydragon.fierydragon.volcano.VolcanoBuilder;
import org.fierydragon.fierydragon.volcano.VolcanoDirector;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that represent the GameBoard in the game.
 * Created by:
 *  @author Hang Jui Kai
 */
public class GameBoard {
    /**
     * Chit cards within the game board
     */
    private ArrayList<ChitCard> chitCards;
    /**
     * Volcano cards within the game board
     */
    private ArrayList<Volcano> volcanoCards;
    /**
     * The distance between both caves in volcano cards
     */
    private final int caveVolcanoDistance = 2;
    /**
     * Indicator of square index
     */
    private int squareIndex = 0;
    /**
     * Indicator of cave index
     */
    private int caveIndex = -1;

    /**
     * Constructor
     */
    public GameBoard() {
        this.chitCards = new ArrayList<>();
        this.initialiseChitCards();

        this.volcanoCards = new ArrayList<>();
        this.initialiseVolcanoCards();
    }

    public GameBoard(ArrayList<ChitCard> chitCards, ArrayList<Volcano> volcanoes) {
        this.chitCards = chitCards;
        this.volcanoCards = volcanoes;
    }

    /**
     * Getter method for volcano cards
     *
     * @return the volcano cards within this game board
     */
    public ArrayList<Volcano> getVolcanoCards() {
        return this.volcanoCards;
    }

    /**
     * Getter method for chit cards
     *
     * @return the chit cards within this game board
     */
    public ArrayList<ChitCard> getChitCards() {
        return chitCards;
    }

    /**
     * This method will initialise the chit cards in the game
     */
    private void initialiseChitCards() {
        createChitCard(new Animal1ChitCardFactory(), 1, 1, 2, 3);
        createChitCard(new Animal2ChitCardFactory(), 1, 1, 2, 3);
        createChitCard(new Animal3ChitCardFactory(), 1, 1, 2, 3);
        createChitCard(new Animal4ChitCardFactory(),1, 1, 2, 3);
        createChitCard(new BadAnimal1ChitCardFactory(), 2, 1, 2);
        createChitCard(new SpecialAnimal1ChitCardFactory(), 1, 1);
        createChitCard(new GoodAnimal1ChitCardFactory(), 1, 2);

        // Collections.shuffle(chitCards);
    }

    /**
     * This method will initialise the volcano cards in the game
     */
    private void initialiseVolcanoCards() {
        ArrayList<Volcano> volcanoWithoutCave = new ArrayList<>();
        ArrayList<Volcano> volcanoWithCave = new ArrayList<>();
        VolcanoDirector director = new VolcanoDirector();
        VolcanoBuilder builder = new VolcanoBuilder();

        // generate respective animals
        ArrayList<Animal> animals = new ArrayList<>();
        Animal1 animal1 = new Animal1();
        Animal2 animal2 = new Animal2();
        Animal3 animal3 = new Animal3();
        Animal4 animal4 = new Animal4();

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        Collections.shuffle(animals);

        volcanoWithoutCave.add(director.constructVolcano(builder, animal4, animal2, animal3));
        volcanoWithoutCave.add(director.constructVolcano(builder, animal1, animal3, animal2));
        volcanoWithoutCave.add(director.constructVolcano(builder, animal2, animal1, animal3));
        volcanoWithoutCave.add(director.constructVolcano(builder, animal3, animal1, animal4));

        volcanoWithCave.add(director.constructCaveVolcano(builder, animals.remove(0), animal1, animal2, animal4));
        volcanoWithCave.add(director.constructCaveVolcano(builder, animals.remove(0), animal3, animal4, animal2));
        volcanoWithCave.add(director.constructCaveVolcano(builder, animals.remove(0), animal4, animal3, animal1));
        volcanoWithCave.add(director.constructCaveVolcano(builder, animals.remove(0), animal2, animal4, animal1));

        // shuffle volcano cards
        Collections.shuffle(volcanoWithoutCave);
        Collections.shuffle(volcanoWithCave);

        for (int i = 0; i < volcanoWithCave.size(); i ++) {
            volcanoCards.add(volcanoWithCave.get(i));
            volcanoCards.add(volcanoWithoutCave.get(i));
        }

        createLinks();
    }

    public void createLinks() {
        // link volcano squares and cave together
        for (int i = 0; i < volcanoCards.size(); i++) {
            Volcano currentVolcano = volcanoCards.get(i);
            currentVolcano.getSquares().get(0).setTileID(this.squareIndex++);

            // link volcano's squares together
            for (int j = 1; j < currentVolcano.getSquaresNumber(); j++) {
                Square squarePrevious = currentVolcano.getSquares().get(j - 1);
                Square squareCurrent = currentVolcano.getSquares().get(j);

                squarePrevious.setFrontTile(squareCurrent);
                squareCurrent.setBackTile(squarePrevious);
                squareCurrent.setTileID(this.squareIndex++);
            }

            // link cave with respecting square
            if (i % 2 == 0) {
                Square centerSquare = currentVolcano.getSquares().get(currentVolcano.getSquaresNumber() / 2);

                Cave currentCave = currentVolcano.getCave();
                centerSquare.setCave(currentCave);
                currentCave.setFrontTile(centerSquare);
                currentCave.setTileID(this.caveIndex--);
            }
        }

        // link volcano card squares together
        for (int i = 0; i < volcanoCards.size(); i++) {
            Volcano currentVolcano = volcanoCards.get(i);
            Volcano previousVolcano;

            if (i > 0) {
                previousVolcano = volcanoCards.get(i - 1);

            }
            else {
                previousVolcano = volcanoCards.get(volcanoCards.size() - 1);
            }
            Square currentVolcanoFirstSquare = currentVolcano.getSquares().get(0);
            Square previousVolcanoLastSquare = previousVolcano.getSquares().get(previousVolcano.getSquaresNumber() - 1);

            currentVolcanoFirstSquare.setBackTile(previousVolcanoLastSquare);
            previousVolcanoLastSquare.setFrontTile(currentVolcanoFirstSquare);
        }
    }

    /**
     * This method will assign player to specific cave
     *
     * @param players The players that in the game
     */
    public void assignPlayersCave(ArrayList<Player> players) {
        int index = 0;

        for (Player player : players) {
            Token token = player.getPlayerToken();
            volcanoCards.get(index).getCave().setToken(token);
            token.setTile(volcanoCards.get(index).getCave());

            // first division of 2 is because only half of the volcano card has caves
            // the next division of 2 is to see if the player will occupy more than half caves or not to assign cave properly
            if (players.size() <= (volcanoCards.size() / 2) / 2) {
                index += (caveVolcanoDistance * 2);
            }
            else {
                index += caveVolcanoDistance;
            }
        }
    }

    /**
     * This method will create chit card in this game
     *
     * @param chitCardFactory The chit card factory that is required to use to create the respective chit card
     * @param set The number of set is required for the set of chit cards in this game
     * @param count The number of set being occurred
     */
    public void createChitCard(ChitCardFactory chitCardFactory, int set, int... count) {
        for (int i = 0; i < set; i++) {
            for (int num: count) {
                chitCards.add(chitCardFactory.createChitCard(num));
            }
        }
    }

    /**
     * This method will return a tile given an index
     * Square index is a non-negative number
     * Tile index is a negative number
     *
     * @param index The index of the tile
     * @return The tile at position of index
     */
    public Tile getTileByIndex(int index) {
        if (index >= 0) {
            for (Volcano volcanoCard : volcanoCards) {
                if (index < volcanoCard.getSquaresNumber()) {
                    return volcanoCard.getSquares().get(index);
                }
                index -= volcanoCard.getSquaresNumber();
            }
        } else {
            for (Volcano volcanoCard : volcanoCards) {
                if (volcanoCard.hasCave()) {
                    if (index == -1) {
                        return volcanoCard.getCave();
                    }
                    index++;
                }
            }
        }

        return null;
    }

    /**
     * This method return the string that represent the GameBoard
     *
     * @return the string representation of this class
     */
    @Override
    public String toString() {
        String result = "";

        result += "Game Board with chit cards: " + chitCards + "\n";
        result += "Volcano in Game Board:" + volcanoCards;

        return result;
    }
}