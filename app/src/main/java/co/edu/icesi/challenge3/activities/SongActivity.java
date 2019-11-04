package co.edu.icesi.challenge3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.icesi.challenge3.R;
import co.edu.icesi.challenge3.model.ItemComplete;

public class SongActivity extends AppCompatActivity {

    private TextView title;
    private TextView artist;
    private TextView album;
    private TextView duration;
    private ImageView image;
    private ImageView backImage;
    private Button listenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        ItemComplete itemComplete = (ItemComplete) getIntent().getSerializableExtra("list");
    }

}
