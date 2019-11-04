package co.edu.icesi.challenge3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import co.edu.icesi.challenge3.R;
import co.edu.icesi.challenge3.SongAdapter;
import co.edu.icesi.challenge3.model.ItemComplete;
import co.edu.icesi.challenge3.model.Song;
import co.edu.icesi.challenge3.model.SongComplete;
import co.edu.icesi.challenge3.util.HTTPSWebUtilDomi;

public class PlayListActivity extends AppCompatActivity {

    private TextView title, description, songs, fans;
    private ImageView picture, left;
    private ListView tracks;
    private SongAdapter songAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        ItemComplete itemComplete = (ItemComplete) getIntent().getSerializableExtra("list");
        songAdapter = new SongAdapter();
        title = findViewById(R.id.titleList);
        description = findViewById(R.id.descriptionList);
        songs = findViewById(R.id.songsList);
        fans = findViewById(R.id.fansList);
        picture = findViewById(R.id.pictureList);
        tracks = findViewById(R.id.tracksList);
        left = findViewById(R.id.leftPlayList);

        title.setText(itemComplete.getTitle());
        description.setText(itemComplete.getDescription());
        fans.setText(""+itemComplete.getNb_fans());
        songs.setText(""+itemComplete.getNb_tracks());
        Picasso.get().load(itemComplete.getPicture_small()).into(picture);
        tracks.setAdapter(songAdapter);
        songAdapter.setList(itemComplete.getTracks().getData());
        tracks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = (Song)songAdapter.getItem(i);
                long parameter = song.getId();
                Intent intent = new Intent(getApplicationContext(), SongActivity.class);
                String url = "https://api.deezer.com/track/"+parameter;
                new Thread(
                        () -> {
                            try {
                                HTTPSWebUtilDomi utilDomi = new HTTPSWebUtilDomi();
                                String answer = utilDomi.GETrequest(url);
                                Gson json = new Gson();
                                runOnUiThread(
                                        () -> {
                                            SongComplete songComplete = json.fromJson(answer, SongComplete.class);
                                            intent.putExtra("track", songComplete);
                                            startActivity(intent);

                                        }
                                );

                            } catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                ).start();
            }
        });
        left.setOnClickListener(
                view -> {
                    super.onBackPressed();
                }
        );
    }
}
