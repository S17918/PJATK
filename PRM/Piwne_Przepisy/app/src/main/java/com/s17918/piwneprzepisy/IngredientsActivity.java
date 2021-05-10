package com.s17918.piwneprzepisy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IngredientsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        String id_string = String.valueOf(GetVariables.beer_ID);
        String malt_id = ("malt_" + id_string);
        String hops_id = ("hops_" + id_string);
        String additives_id = ("additives_" + id_string);

        int ID_malt = getResources().getIdentifier(malt_id, "array", getPackageName());
        int ID_hops = getResources().getIdentifier(hops_id, "array", getPackageName());
        int ID_additives = getResources().getIdentifier(additives_id, "array", getPackageName());

        StringBuilder builder_malt = new StringBuilder();
        StringBuilder builder_hops = new StringBuilder();
        StringBuilder builder_additives = new StringBuilder();

        String malt_list[] = getResources().getStringArray(ID_malt);
        String hops_list[] = getResources().getStringArray(ID_hops);
        String additives_list[] = getResources().getStringArray(ID_additives);

        TextView maltView = (TextView)findViewById(R.id.malt);
        TextView hopsView = (TextView)findViewById(R.id.hops);
        TextView additivesView = (TextView)findViewById(R.id.additives);
        TextView beer_name = (TextView)findViewById(R.id.beer_name);
        beer_name.setText(GetVariables.beerName);

        for(String malt : malt_list){
            builder_malt.append(malt).append("\n\n");
        }
        maltView.setText(builder_malt);

        for(String hops : hops_list){
            builder_hops.append(hops).append("\n\n");
        }
        hopsView.setText(builder_hops);

        for(String additives : additives_list){
            builder_additives.append(additives).append("\n\n");
        }
        additivesView.setText(builder_additives);


    }

    public void OpenMashing(View view){
        Intent intent = new Intent(this, MashingActivity.class);
        startActivity(intent);
    }
}
