package com.cm.misc.javeriana.game.app.model;

import com.cm.misc.javeriana.game.app.field.Constants;

import java.util.Date;

/**
 * Class that defines data related to the Game's History
 */
public class GameHistoryDetail {
    private int attempts;
    private Date lastAttemptDate;
    private Constants.NumberType numberType;

    /**
     * Constructor. Creates a new instance of {@link GameHistoryDetail}
     *
     * @param attempts        the current user's attempts
     * @param lastAttemptDate date of the last attempt form the user
     * @param numberType      {@link com.cm.misc.javeriana.game.app.field.Constants.NumberType}
     *                        the type of number provided by the user
     */
    public GameHistoryDetail(int attempts, Date lastAttemptDate, Constants.NumberType numberType) {
        this.attempts = attempts;
        this.lastAttemptDate = lastAttemptDate;
        this.numberType = numberType;
    }

    /**
     * Returns the user's number of attempts
     *
     * @return int
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * Sets the user's number of attempts
     *
     * @param attempts the quantity of attempts
     */
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    /**
     * Returns the date of the last attempt form the user
     *
     * @return {@link Date}
     */
    public Date getLastAttemptDate() {
        return lastAttemptDate;
    }

    /**
     * Sets the date of the last attempt form the user
     *
     * @param lastAttemptDate
     */
    public void setLastAttemptDate(Date lastAttemptDate) {
        this.lastAttemptDate = lastAttemptDate;
    }

    /**
     * The type of number provided by the use
     *
     * @return {@link com.cm.misc.javeriana.game.app.field.Constants.NumberType}
     */
    public Constants.NumberType getNumberType() {
        return numberType;
    }

    /**
     * Sets the type of number provided by the use
     *
     * @param numberType
     */
    public void setNumberType(Constants.NumberType numberType) {
        this.numberType = numberType;
    }
}
