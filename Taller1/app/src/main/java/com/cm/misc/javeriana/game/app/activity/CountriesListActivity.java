package com.cm.misc.javeriana.game.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cm.misc.javeriana.game.app.R;
import com.cm.misc.javeriana.game.app.adapter.CountriesListAdapter;
import com.cm.misc.javeriana.game.app.field.Constants;
import com.cm.misc.javeriana.game.app.model.Country;
import com.cm.misc.javeriana.game.app.model.CountryList;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class CountriesListActivity extends AppCompatActivity {

    private CountryList countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadCountrySet();
        setContentView(R.layout.countries_list_layout);
        buildComponents();
    }

    private void buildComponents() {
        ListView listView = findViewById(R.id.lvwCLACountriesListView);
        listView.setAdapter(null);
        listView.setAdapter(new CountriesListAdapter(this, countryList.getCountries()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                Country country = countryList.getCountries().get(index);
                Intent intent = createIntent(country);
                startActivity(intent);
            }
        });
    }

    private Intent createIntent(Country country) {
        Intent intent = new Intent(getBaseContext(), CountryDetailsActivity.class);
        intent.putExtra(Constants.FIELD_COUNTRY_NAME, country.getCountryName());
        intent.putExtra(Constants.FIELD_COUNTRY_CAPITOL, country.getCapitol());
        intent.putExtra(Constants.FIELD_COUNTRY_INT_NAME, country.getIntCountryName());
        intent.putExtra(Constants.FIELD_COUNTRY_SHORT_CODE, country.getShortName());
        return intent;
    }

    private void loadCountrySet() {
        String json = loadJSONFromAsset();
        Gson gson = new Gson();
        CountryList countries = gson.fromJson(json, CountryList.class);
        countryList = countries;
    }

    /**
     * @return
     */
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.e("loadJSONFromAsset", ex.getMessage());
        }
        return json;
    }
}
