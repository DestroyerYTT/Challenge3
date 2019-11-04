package co.edu.icesi.challenge3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;

import co.edu.icesi.challenge3.ListAdapter;
import co.edu.icesi.challenge3.R;
import co.edu.icesi.challenge3.model.Item;
import co.edu.icesi.challenge3.model.ItemComplete;
import co.edu.icesi.challenge3.model.PlayLists;
import co.edu.icesi.challenge3.util.HTTPSWebUtilDomi;

public class MainActivity extends AppCompatActivity {

    private ImageButton searchBtn;
    private EditText searchBar;
    private ListView list;
    private ListAdapter listAdapter;
    private PlayLists playLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAdapter = new ListAdapter();
        searchBtn =  findViewById(R.id.search_button_ib);
        searchBar = findViewById(R.id.search_bar_et);
        list = findViewById(R.id.list_item_lv);
        list.setAdapter(listAdapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String parameter = searchBar.getText().toString();
                String url = "https://api.deezer.com/search/playlist?q="+parameter;
                new Thread(
                        () -> {
                            try {
                              HTTPSWebUtilDomi utilDomi = new HTTPSWebUtilDomi();
                              String answer = utilDomi.GETrequest(url);
                              Gson json = new Gson();
                                runOnUiThread(
                                        () -> {
                                         playLists = json.fromJson(answer, PlayLists.class);
                                         listAdapter.setList(playLists.getData());
                                        }
                                );

                            } catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                ).start();
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Item item = (Item)listAdapter.getItem(i);
                        long parameter = item.getId();
                        Intent intent = new Intent(getApplicationContext(), PlayListActivity.class);
                        String url = "https://api.deezer.com/playlist/"+parameter;
                        new Thread(
                                () -> {
                                    try {
                                        HTTPSWebUtilDomi utilDomi = new HTTPSWebUtilDomi();
                                        String answer = utilDomi.GETrequest(url);
                                        Gson json = new Gson();
                                        runOnUiThread(
                                                () -> {
                                                    ItemComplete itemComplete = json.fromJson(answer, ItemComplete.class);
                                                    Log.e(">>", "Description"+itemComplete.getDescription());
                                                    intent.putExtra("list", itemComplete);
                                                    startActivity(intent);

                                                }
                                        );

                                    } catch (IOException e){
                                        e.printStackTrace();
                                    }
                                }
                        ).start();
                    }
                }
        );
    }




}
