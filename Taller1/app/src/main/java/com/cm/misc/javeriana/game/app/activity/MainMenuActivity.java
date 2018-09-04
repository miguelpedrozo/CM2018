package com.cm.misc.javeriana.game.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cm.misc.javeriana.game.app.R;
import com.cm.misc.javeriana.game.app.field.Constants;
import com.cm.misc.javeriana.game.app.utils.UIUtils;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main_menu);
        buildComponents();
    }

    /**
     * Configures the components within this activity
     */
    private void buildComponents() {
        ImageView imvGuessGame = findViewById(R.id.imvAMMGuessGameImage);
        imvGuessGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextStepInGuessGame();
            }
        });

        ImageView imvCountriesList = findViewById(R.id.imvAMMCountriesListImage);
        imvCountriesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCountryListing();
            }
        });
    }

    /**
     * Validates the input from the user and starts the next activity in the game flow
     */
    private void startNextStepInGuessGame() {
        String minNumber = String.valueOf(Constants.MIN_RANGE_NUMBER);
        String maxNumber = ((EditText) findViewById(R.id.txfAMMGuessEndRangeNumber)).getText().toString();

        if (validateInput(maxNumber)) {
            Intent intent = new Intent(this, GuessGameMainActivity.class);
            intent.putExtra(Constants.FIELD_RANGE_MIN, minNumber);
            intent.putExtra(Constants.FIELD_RANGE_MAX, maxNumber);
            startActivity(intent);
        }
    }

    /**
     * Starts the country listing option
     */
    private void startCountryListing() {
        Intent intent = new Intent(this, CountriesListActivity.class);
        startActivity(intent);
    }

    /**
     * Validates the current input from the user
     *
     * @param maxNumber the <code>int</code> provided by the user
     * @return <code>true</code> if the input provided by the user is ok,
     * <code>false</code> otherwise
     */
    private boolean validateInput(String maxNumber) {
        boolean isValid = false;
        String message = null;
        if (maxNumber == null) {
            message = "Debe ingresar el rango maximo para iniciar el juego!";
        } else if (maxNumber.isEmpty()) {
            message = "Debe ingresar el rango maximo para iniciar el juego!";
        } else if ((Integer.parseInt(maxNumber) < Constants.MIN_RANGE_NUMBER )) {
            message = "El rango maximo debe ser mayor a cero!";
        } else if ((Integer.parseInt(maxNumber) > Constants.MAX_RANGE_NUMBER )) {
            message = String.format("El rango maximo es %s!", Constants.MAX_RANGE_NUMBER);
        } else {
            isValid = true;
        }
        if (!isValid) {
            UIUtils.showToast(this, message, Toast.LENGTH_LONG);
        }
        return isValid;
    }
}
