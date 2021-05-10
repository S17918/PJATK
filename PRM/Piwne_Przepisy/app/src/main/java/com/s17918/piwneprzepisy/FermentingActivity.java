package com.s17918.piwneprzepisy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FermentingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fermenting);

        TextView beer_name = (TextView)findViewById(R.id.beer_name_4);
        beer_name.setText(GetVariables.beerName);

        String id_string = String.valueOf(GetVariables.beer_ID);
        String ferment_burzliwa_id = ("ferment_burzliwa_" + id_string);
        String ferment_cicha_id = ("ferment_cicha_"+ id_string);
        String ferment_add_id =("ferment_add_"+ id_string);
        String bottle_id = ("bottle_" + id_string);

        int ID_ferment_burzliwa = getResources().getIdentifier(ferment_burzliwa_id, "string", getPackageName());
        int ID_ferment_cicha = getResources().getIdentifier(ferment_cicha_id, "string", getPackageName());
        int ID_ferment_add = getResources().getIdentifier(ferment_add_id, "string", getPackageName());
        int ID_bottle = getResources().getIdentifier(bottle_id, "string", getPackageName());

        String fermentBurzliwaText = getResources().getString(ID_ferment_burzliwa);
        String fermentCichaText = getResources().getString(ID_ferment_cicha);
        String fermentAddText = getResources().getString(ID_ferment_add);
        String bottleText = getResources().getString(ID_bottle);

        TextView fermentBurzliwaView = (TextView)findViewById(R.id.ferment_burzliwa);
        TextView fermentCichaView = (TextView)findViewById(R.id.ferment_cicha);
        TextView fermentAddView = (TextView)findViewById(R.id.additiational);
        TextView bottleView = (TextView)findViewById(R.id.bottle);

        fermentBurzliwaView.setText(fermentBurzliwaText);
        fermentCichaView.setText(fermentCichaText);
        fermentAddView.setText(fermentAddText);
        bottleView.setText(bottleText);

    }

    public void BackToMenu(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
