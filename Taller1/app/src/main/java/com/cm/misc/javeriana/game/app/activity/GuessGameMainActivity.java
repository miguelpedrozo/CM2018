package com.cm.misc.javeriana.game.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cm.misc.javeriana.game.app.R;
import com.cm.misc.javeriana.game.app.adapter.GuessHistoryListAdapter;
import com.cm.misc.javeriana.game.app.controller.GuessController;
import com.cm.misc.javeriana.game.app.exception.InputNotValidException;
import com.cm.misc.javeriana.game.app.field.Constants;
import com.cm.misc.javeriana.game.app.utils.UIUtils;

public class GuessGameMainActivity extends AppCompatActivity {

    private GuessController guessController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_game_main_layout);
        buildComponents();
        updateTitle();
        updateHistory();
    }

    private void buildComponents() {
        Button butMGACheckNumber = findViewById(R.id.butMGACheckNumber);
        butMGACheckNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etxMGANumberToGuess = findViewById(R.id.etxMGANumberToGuess);
                String enteredNumber = etxMGANumberToGuess.getText().toString();
                try {
                    if (guessController.validateAttempt(enteredNumber)) {
                        UIUtils.showToast(
                                view.getContext(),
                                String.format("Acertaste! El numero secreto era: %s", enteredNumber),
                                Toast.LENGTH_LONG);
                    } else {
                        updateHistory();
                    }
                } catch (InputNotValidException e) {
                    Log.e("GuessGameMainActivity", "Error trying validate attempt", e);
                    UIUtils.showToast(view.getContext(), e.getMessage(), Toast.LENGTH_LONG);
                }
            }
        });
        int minNumber = Integer.parseInt(getIntent().getStringExtra(Constants.FIELD_RANGE_MIN));
        int maxNumber = Integer.parseInt(getIntent().getStringExtra(Constants.FIELD_RANGE_MAX));
        guessController = new GuessController(minNumber, maxNumber);
    }

    private void updateHistory() {
        ListView listView = findViewById(R.id.lsvMGAGuessHistory);
        listView.setAdapter(null);
        listView.setAdapter(
                new GuessHistoryListAdapter(this, guessController.getGameHistoryDetails()));
    }

    private void updateTitle() {
        TextView txvMGALegendGuessNumber = findViewById(R.id.txvMGALegendGuessNumber);
        String text = txvMGALegendGuessNumber.getText().toString();
        text = text.replace("{0}", String.valueOf(guessController.getMinNumber()))
                .replace("{1}", String.valueOf(guessController.getMaxNumber()));
        txvMGALegendGuessNumber.setText(text);
    }
}
