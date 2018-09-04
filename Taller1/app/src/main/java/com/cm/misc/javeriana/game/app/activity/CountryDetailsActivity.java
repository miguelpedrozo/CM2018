package com.cm.misc.javeriana.game.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.cm.misc.javeriana.game.app.R;
import com.cm.misc.javeriana.game.app.field.Constants;
import com.cm.misc.javeriana.game.app.task.DownloadImageTask;

public class CountryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_details_layout);
        buildComponents();
    }

    private void buildComponents() {
        Intent intent = getIntent();
        String countryName = intent.getStringExtra(Constants.FIELD_COUNTRY_NAME);
        String countryIntName = intent.getStringExtra(Constants.FIELD_COUNTRY_INT_NAME);
        String countryShortCode = intent.getStringExtra(Constants.FIELD_COUNTRY_SHORT_CODE);
        String countryCapitol = intent.getStringExtra(Constants.FIELD_COUNTRY_CAPITOL);
        String countryFlagUrl = Constants.GITHUB_FLAGS_URL.replace("{0}", countryShortCode.toLowerCase());

        TextView txvCDACountryName = findViewById(R.id.txvCDACountryName);
        txvCDACountryName.setText(countryName);

        TextView txvCDACapitol = findViewById(R.id.txvCDACapitol);
        txvCDACapitol.setText(countryCapitol);

        TextView txvCDAIntCountryName = findViewById(R.id.txvCDAIntCountryName);
        txvCDAIntCountryName.setText(countryIntName);

        TextView txvCDAShortName = findViewById(R.id.txvCDAShortName);
        txvCDAShortName.setText(countryShortCode);

        ImageView imageView = findViewById(R.id.imvCDACountryFlag);
        new DownloadImageTask(imageView).execute(countryFlagUrl);
    }
}
