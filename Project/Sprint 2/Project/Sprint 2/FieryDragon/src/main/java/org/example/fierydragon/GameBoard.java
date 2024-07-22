package org.example.fierydragon;

/***
 * A class that represent GameBoard
 * Created by: Jui Kai
 * @author Jui Kai
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameBoard {
    private ArrayList<VolcanoCard> gameBoard = new ArrayList<>();
    private final Cave[] defaultCave = {new Cave(new Bat(), 1), new Cave(new Dragon(), 2), new Cave(new Salamander(), 3), new Cave(new Spider(), 4)};

    /**
     * Constructor
     */
    public GameBoard() {
        this.initialiseVolcanoCard();
        this.connectVolcanoSquare();
    }

    /**
     * This method initialise the volcanoCard
     */
    private void initialiseVolcanoCard() {
        ArrayList<VolcanoCard> volcanoCardsContainCave = new ArrayList<>();
        ArrayList<VolcanoCard> volcanoCardsWithoutCave = new ArrayList<>();

        VolcanoCard batSpiderBabyDragon = new VolcanoCard(new SquareFactory[] {new BatSquareFactory(), new SpiderSquareFactory(), new DragonSquareFactory()}, defaultCave[3]);
        VolcanoCard babyDragonBatSpider = new VolcanoCard(new SquareFactory[] {new DragonSquareFactory(), new BatSquareFactory(), new SpiderSquareFactory()}, defaultCave[0]);
        VolcanoCard salamanderSpiderBat = new VolcanoCard(new SquareFactory[] {new SalamanderSquareFactory(), new SpiderSquareFactory(), new BatSquareFactory()}, defaultCave[1]);
        VolcanoCard spiderSalamanderBabyDragon = new VolcanoCard(new SquareFactory[] {new SpiderSquareFactory(), new SalamanderSquareFactory(), new DragonSquareFactory()}, defaultCave[2]);

        volcanoCardsContainCave.add(babyDragonBatSpider);
        volcanoCardsContainCave.add(salamanderSpiderBat);
        volcanoCardsContainCave.add(batSpiderBabyDragon);
        volcanoCardsContainCave.add(spiderSalamanderBabyDragon);

        VolcanoCard spiderBatSalamander = new VolcanoCard(new SquareFactory[] {new SpiderSquareFactory(), new BatSquareFactory(), new SalamanderSquareFactory()}, null);
        VolcanoCard babyDragonSalamanderBat = new VolcanoCard(new SquareFactory[] {new DragonSquareFactory(), new SalamanderSquareFactory(), new BatSquareFactory()}, null);
        VolcanoCard batBabyDragonSalamander = new VolcanoCard(new SquareFactory[] {new BatSquareFactory(), new DragonSquareFactory(), new SalamanderSquareFactory()}, null);
        VolcanoCard salamanderBabyDragonSpider = new VolcanoCard(new SquareFactory[] {new SalamanderSquareFactory(), new DragonSquareFactory(), new SpiderSquareFactory()}, null);

        volcanoCardsWithoutCave.add(spiderBatSalamander);
        volcanoCardsWithoutCave.add(batBabyDragonSalamander);
        volcanoCardsWithoutCave.add(babyDragonSalamanderBat);
        volcanoCardsWithoutCave.add(salamanderBabyDragonSpider);

        long seed = 322;
        Collections.shuffle(volcanoCardsContainCave, new Random(seed));
        Collections.shuffle(volcanoCardsWithoutCave, new Random(seed));

        for (int idx = 0; idx < volcanoCardsContainCave.size(); idx ++) {
            gameBoard.add(volcanoCardsContainCave.get(idx));
            gameBoard.add(volcanoCardsWithoutCave.get(idx));
        }
    }

    /**
     * This method connect the volcanoSquare
     */
    private void connectVolcanoSquare() {
        Square currentSquare;
        Square nextSquare;

        for (int i = 0; i < this.gameBoard.size(); i++) {
            int nextVolcano = (i + 1) % (this.gameBoard.size());
            for (int j = 0; j < this.gameBoard.get(i).getVolcanoCard().size(); j++) {
                if (j < 2) {
                    currentSquare = this.gameBoard.get(i).getVolcanoCard().get(j);
                    nextSquare = this.gameBoard.get(i).getVolcanoCard().get(j + 1);

                    currentSquare.setRightSquare(nextSquare);
                    nextSquare.setLeftSquare(currentSquare);

                    if (currentSquare.isHasCave()) {
                        currentSquare.getCave().setExitSquare(currentSquare);
                    }

                } else if (j == 2) {
                    currentSquare = this.gameBoard.get(i).getVolcanoCard().get(j);
                    nextSquare = this.gameBoard.get(nextVolcano).getVolcanoCard().get(0);

                    currentSquare.setRightSquare(nextSquare);
                    nextSquare.setLeftSquare(currentSquare);
                }
            }
        }
    }

    /**
     * This method return the gameBoard
     *
     * @return a list of volcanoCard
     */
    public ArrayList<VolcanoCard> getGameBoard() {
        return gameBoard;
    }
}
