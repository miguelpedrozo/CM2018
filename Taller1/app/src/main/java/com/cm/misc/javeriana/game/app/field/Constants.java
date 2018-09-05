package com.cm.misc.javeriana.game.app.field;

public class Constants {
    /**
     * GitHub URL
     */
    public static final String GITHUB_FLAGS_URL =
            "https://raw.githubusercontent.com/miguelpedrozo/CM2018/master/flags/{0}.png";

    /**
     * Min range number allowed in guess game option
     */
    public static final int MIN_RANGE_NUMBER = 0;
    /**
     * Max range number allowed in guess game option
     */
    public static final int MAX_RANGE_NUMBER = 1000;
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
     * Country fields for activity - country name
     */
    public static final String FIELD_COUNTRY_NAME = "countryName";
    /**
     * Country fields for activity - country capitol
     */
    public static final String FIELD_COUNTRY_CAPITOL = "countryCapitol";
    /**
     * Country fields for activity - country international name
     */
    public static final String FIELD_COUNTRY_INT_NAME = "countryIntName";
    /**
     * Country fields for activity - country short code
     */
    public static final String FIELD_COUNTRY_SHORT_CODE = "countryShortCode";
    /**
     * Country fields for activity - country flag url
     */
    public static final String FIELD_COUNTRY_FLAG_URL = "countryFlagUrl";

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
