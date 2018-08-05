package com.cm.misc.javeriana.game.app.field;

public class Constants {
    /**
     * Used to map the min number when starting the entry point intent
     * {@link com.cm.misc.javeriana.game.app.activity.InitialGameConfigActivity}
     */
    public static final String FIELD_RANGE_MIN = "minNumber";
    /**
     * Used to map the max number when starting the entry point intent
     * {@link com.cm.misc.javeriana.game.app.activity.InitialGameConfigActivity}
     */
    public static final String FIELD_RANGE_MAX = "maxNumber";

    /**
     * Enumeration used to define the types of numeric inputs from the user
     */
    public enum NumberType {
        HIGHER("Mayor"),
        LESSER("Menor");

        String type;

        NumberType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
