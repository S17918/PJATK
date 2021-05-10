package android.stoper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int time = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            time = savedInstanceState.getInt("time");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("time", time);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onStop(){
        super.onStop();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(wasRunning){
            running = wasRunning;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(wasRunning){
            running = wasRunning;
        }
    }

    public void onClickStart(View view){
        running = true;
    }

    public void onClickStop(View view){
        running = false;
    }

    public void onClickClear(View view){
        running = false;
        time = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = time/3600;
                int minutes = (time%3600)/60;
                int seconds = time%60;

                String result = String.format("%d:%02d:%02d", hours, minutes, seconds);
                timeView.setText(result);
                if(running){
                    time++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
