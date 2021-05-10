package com.s17918.piwneprzepisy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MashingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mashing);

        TextView beer_name = (TextView)findViewById(R.id.beer_name_2);
        beer_name.setText(GetVariables.beerName);

        String id_string = String.valueOf(GetVariables.beer_ID);
        String mash_id = ("mash_" + id_string);
        String mash_out_id = ("mash_out_" + id_string);

        int ID_mash = getResources().getIdentifier(mash_id, "string", getPackageName());
        int ID_mash_out = getResources().getIdentifier(mash_out_id, "string", getPackageName());

        String mashText = getResources().getString(ID_mash);
        String mash_outText = getResources().getString(ID_mash_out);

        TextView mash = (TextView)findViewById(R.id.mash);
        TextView mash_out = (TextView)findViewById(R.id.mash_out);

        mash.setText(mashText);
        mash_out.setText(mash_outText);
    }

    public void OpenBrewing(View view){
        Intent intent = new Intent(this, BrewingActivity.class);
        startActivity(intent);
    }
}
