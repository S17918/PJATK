package com.s17918.piwnydoradca;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class FindBeerActivity extends Activity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void FindBeer(View view){
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());

        List<String> brands_list = expert.getBrands(beerType);
        StringBuilder brands_formatted = new StringBuilder();

        for(String brand : brands_list){
            brands_formatted.append(brand).append('\n');
        }

        brands.setText(brands_formatted);
    }
}
