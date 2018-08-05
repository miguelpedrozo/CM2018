package com.cm.misc.javeriana.game.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cm.misc.javeriana.game.app.R;
import com.cm.misc.javeriana.game.app.field.Constants;
import com.cm.misc.javeriana.game.app.utils.UIUtils;

/**
 * Activity that is the starting point of the app
 */
public class InitialGameConfigActivity extends AppCompatActivity {

    /**
     * Called when the activity is created
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_game_config);
        buildComponents();
    }

    /**
     * Configures the components within this activity
     */
    private void buildComponents() {
        Button butIGAStartGame = findViewById(R.id.butIGAStartGame);
        butIGAStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNextStepInGame();
            }
        });
    }

    /**
     * Validates the input from the user and starts the next activity in the game flow
     */
    private void startNextStepInGame() {
        String maxNumber = ((EditText) findViewById(R.id.etvIGAMaxNumber)).getText().toString();
        String minNumber = ((EditText) findViewById(R.id.etvIGAMinNumber)).getText().toString();
        if (validateInput(minNumber, maxNumber)) {
            Intent intent = new Intent(this, MainGameActivity.class);
            intent.putExtra(Constants.FIELD_RANGE_MIN, minNumber);
            intent.putExtra(Constants.FIELD_RANGE_MAX, maxNumber);
            startActivity(intent);
        }
    }

    /**
     * Validates the current input from the user
     *
     * @param maxNumber the <code>int</code> provided by the user
     * @param minNumber the <code>int</code> provided by the user
     * @return <code>true</code> if the input provided by the user is ok,
     * <code>false</code> otherwise
     */
    private boolean validateInput(String minNumber, String maxNumber) {
        boolean isValid = false;
        String message = null;
        if (minNumber == null) {
            message = "Debe ingresar el rango minimo para iniciar el juego!";
        } else if (minNumber.isEmpty()) {
            message = "Debe ingresar el rango minimo para iniciar el juego!";
        } else if (maxNumber == null) {
            message = "Debe ingresar el rango maximo para iniciar el juego!";
        } else if (maxNumber.isEmpty()) {
            message = "Debe ingresar el rango maximo para iniciar el juego!";
        } else if ((Integer.parseInt(minNumber) >= Integer.parseInt(maxNumber))) {
            message = "El numero inicial debe ser mayor al numero final!";
        } else {
            isValid = true;
        }
        if (!isValid) {
            UIUtils.showToast(this, message, Toast.LENGTH_LONG);
        }
        return isValid;
    }
}
