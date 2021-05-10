package com.example.checkyourcessna152;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFlight(View view){
        Intent intent = new Intent(this, BeforeFlightCheck_Activity.class);
        startActivity(intent);
    }

    public void exit(View view){
        finish();
        System.exit(0);
    }
}
