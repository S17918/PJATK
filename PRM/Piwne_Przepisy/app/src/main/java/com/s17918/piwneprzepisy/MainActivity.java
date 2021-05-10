package com.s17918.piwneprzepisy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenRecipe(View view){

        Spinner beer_spinner = (Spinner) findViewById(R.id.beer_name_spinner);
        String beer_name = String.valueOf(beer_spinner.getSelectedItem());

        long id = beer_spinner.getSelectedItemId();

        GetVariables.getBeerName_Brew(beer_name);
        GetVariables.getBeerId_Brew(id);

        TextView SpinnerError = (TextView)findViewById(R.id.SpinnerError);

        if(id!=0){
            Intent intent = new Intent(this, IngredientsActivity.class);
            startActivity(intent);
            SpinnerError.setText(R.string.noerror);
        }else {
            SpinnerError.setText(R.string.error);
        }


    }
}
