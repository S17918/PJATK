package piwne.przepisy.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(MainMenuActivity.this, BeerCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };

        ListView listView = (ListView)findViewById(R.id.menu_list);
        listView.setOnItemClickListener(itemClickListener);

    }


}
