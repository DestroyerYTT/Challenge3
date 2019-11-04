package co.edu.icesi.challenge3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.edu.icesi.challenge3.R;
import co.edu.icesi.challenge3.model.SongComplete;

public class SongActivity extends AppCompatActivity {

    private TextView title, artist, album, duration;
    private Button listen;
    private ImageView picture, left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        SongComplete songComplete  = (SongComplete) getIntent().getSerializableExtra("track");
        title = findViewById(R.id.titleSong);
        artist = findViewById(R.id.artistSong);
        album = findViewById(R.id.albumSong);
        duration = findViewById(R.id.durationSong);
        listen = findViewById(R.id.listenSong);
        picture = findViewById(R.id.pictureSong);
        left = findViewById(R.id.leftSong);

        title.setText(songComplete.getTitle());
        artist.setText(songComplete.getArtist().getName());
        album.setText(songComplete.getAlbum().getTitle());
        Picasso.get().load(songComplete.getAlbum().getCover_small()).into(picture);
        duration.setText(""+songComplete.getDuration());
        listen.setOnClickListener(
                view -> {
                    Uri uri = Uri.parse(songComplete.getLink());
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
        );
        left.setOnClickListener(
                view -> {
                    super.onBackPressed();
                }
        );
    }
}
