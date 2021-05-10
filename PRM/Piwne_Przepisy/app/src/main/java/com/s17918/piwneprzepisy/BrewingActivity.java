package com.s17918.piwneprzepisy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BrewingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brewing);

        TextView beer_name = (TextView)findViewById(R.id.beer_name_3);
        beer_name.setText(GetVariables.beerName);

        String id_string = String.valueOf(GetVariables.beer_ID);
        String brew = ("brew_" + id_string);
        int ID_brew = getResources().getIdentifier(brew, "string", getPackageName());
        String brewText = getResources().getString(ID_brew);

        TextView brewViev = (TextView)findViewById(R.id.brew);
        brewViev.setText(brewText);

    }

    public void OpenFerment(View view){

        Intent intent = new Intent(this, FermentingActivity.class);
        startActivity(intent);

    }
}
