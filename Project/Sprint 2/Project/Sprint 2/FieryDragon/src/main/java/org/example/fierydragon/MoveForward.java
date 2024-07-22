package org.example.fierydragon;

/***
 * A class that represent MoveForward
 * Created by: Jui Kai
 * @author Jui Kai
 */
public class MoveForward extends Action {

    private int moveStep;
    private int tokenID;
    private Cave currentCave;
    private Square currentSquare;
    private boolean winStatus;

    /**
     * Constructor
     *
     * @param currentPlayer
     * @param moveStep
     */
    public MoveForward(Player currentPlayer, int moveStep) {
        super(currentPlayer);
        this.moveStep = moveStep;
        this.tokenID = currentPlayer.getToken().getTokenID();
    }

    /**
     * This method will execute moveForward action
     *
     * @param gameBoard
     */
    public void executeAction(GameBoard gameBoard) {
        int currentPosition = super.getCurrentPlayer().getToken().getTokenPosition();
        int retrieveToken;
        boolean loopBreak = false;

        // loop through the game board to find the token
        for (int i = 0; i < gameBoard.getGameBoard().size(); i++) {
            for (int j = 0; j < gameBoard.getGameBoard().get(i).getVolcanoCard().size(); j++) {
                this.currentSquare = gameBoard.getGameBoard().get(i).getVolcanoCard().get(j);

                if (currentPosition == 0) {
                    if (this.currentSquare.isHasCave()) {
                        this.currentCave = this.currentSquare.getCave();

                        if (this.currentCave.getToken() != null) {
                            retrieveToken = this.currentCave.getToken().getTokenID();

                            if (retrieveToken == this.tokenID) {
                                loopBreak = true;
                                break;
                            }
                        }
                    }

                } else if (currentPosition > 0) {
                    if (this.currentSquare.getToken() != null) {
                        retrieveToken = this.currentSquare.getToken().getTokenID();

                        if (retrieveToken == this.tokenID) {
                            loopBreak = true;
                            break;
                        }
                    }
                }
            }

            if (loopBreak) {
                break;
            }
        }

        // loop through the game board to move the token
        for (int move = 0; move < this.moveStep; move++) {
            currentPosition = super.getCurrentPlayer().getToken().getTokenPosition();

            if (currentPosition == 0) {
                Square nextStep = this.currentCave.getExitSquare();

                this.currentCave.removeCaveToken();
                nextStep.addCurrentToken(super.getCurrentPlayer().getToken());

                this.currentSquare = nextStep;
                super.getCurrentPlayer().getToken().increaseTokenPosition();

            } else if (currentPosition > 0) {
                Square nextStep = this.currentSquare.getRightSquare();

                this.currentSquare.removeCurrentToken();
                nextStep.addCurrentToken(super.getCurrentPlayer().getToken());

                this.currentSquare = nextStep;
                super.getCurrentPlayer().getToken().increaseTokenPosition();
            }
        }

        if ((super.getCurrentPlayer().getToken().getTokenPosition()) > 24) {
            super.getCurrentPlayer().updateStatus();
        }
    }
}
