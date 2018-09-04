package com.cm.misc.javeriana.game.app.controller;

import android.util.Log;

import com.cm.misc.javeriana.game.app.exception.InputNotValidException;
import com.cm.misc.javeriana.game.app.field.Constants;
import com.cm.misc.javeriana.game.app.model.GameHistoryDetail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * Class that implements all the logic for the Guess Game
 */
public class GuessController {

    private int attemptCounter = 1;
    private int minNumber = 0;
    private int maxNumber = 0;
    private int randomNumberToGuess = 0;
    private Constants.NumberType numberType;
    private ArrayList<GameHistoryDetail> gameHistoryDetails;

    /**
     * Constructor. Creates a new instance of {@link GuessController}
     *
     * @param minNumber the minimum number of the range
     * @param maxNumber the maximum number of the range
     */
    public GuessController(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        gameHistoryDetails = new ArrayList<>();
        createRandomNumber();
    }

    /**
     * Creates the random number based on the min and max numbers
     */
    private void createRandomNumber() {
        Random random = new Random();
        randomNumberToGuess = random.nextInt((maxNumber - minNumber) + 1) + minNumber;
        Log.i("GuessController", String.format("Random number generated: %d", randomNumberToGuess));
    }

    /**
     * Update the user attempts to guess the secret number
     */
    private void updateAttempts() {
        attemptCounter++;
    }

    /**
     * Validates the current user atttempt to find the secret number
     *
     * @param enteredNumber the number provided by the user
     * @return <code>true</code> if the user found the secret number, <code>false</code> otherwise
     * @throws InputNotValidException if the number provided by the user is not valid
     */
    public boolean validateAttempt(String enteredNumber) throws InputNotValidException {
        if (validateInput(enteredNumber)) {
            int number = Integer.parseInt(enteredNumber);
            if (number == randomNumberToGuess) {
                return true;
            } else {
                updateHistory(number);
            }
        }
        updateAttempts();
        return false;
    }

    /**
     * Updates the user's attempt history
     *
     * @param number the current number provided by the user
     */
    private void updateHistory(int number) {
        Constants.NumberType numberType;
        if (number > randomNumberToGuess) {
            numberType = Constants.NumberType.HIGHER;
        } else {
            numberType = Constants.NumberType.LESSER;
        }
        GameHistoryDetail detail =
                new GameHistoryDetail(
                        attemptCounter,
                        Calendar.getInstance().getTime(),
                        numberType);
        gameHistoryDetails.add(0, detail);
    }

    /**
     * Validates the current user's input
     *
     * @param enteredNumber the current number provided by the user
     * @return <code>true</code> if the input is ok, <code>false</code> otherwise
     * @throws InputNotValidException if the number provided by the user is not valid
     */
    private boolean validateInput(String enteredNumber) throws InputNotValidException {
        if (enteredNumber == null) {
            throw new InputNotValidException("Debes ingresar un numero valido para adivinar!");
        } else if (enteredNumber.isEmpty()) {
            throw new InputNotValidException("Debes ingresar un numero valido para adivinar!");
        } else if (Integer.parseInt(enteredNumber) < minNumber) {
            throw new InputNotValidException(
                    String.format("El numero no puede ser menor a %d!", minNumber));
        } else if (Integer.parseInt(enteredNumber) > maxNumber) {
            throw new InputNotValidException(
                    String.format("El numero no puede ser mayor a %d!", maxNumber));
        } else {
            return true;
        }
    }

    /**
     * Returns the current min number of the range
     *
     * @return int
     */
    public int getMinNumber() {
        return minNumber;
    }

    /**
     * Returns the current max number of the range
     *
     * @return int
     */
    public int getMaxNumber() {
        return maxNumber;
    }

    /**
     * Returns the current game history list {@link ArrayList<GameHistoryDetail>}
     *
     * @return an {@link ArrayList<GameHistoryDetail>} object
     */
    public ArrayList<GameHistoryDetail> getGameHistoryDetails() {
        return gameHistoryDetails;
    }
}
