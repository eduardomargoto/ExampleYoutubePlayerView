package br.com.etm.exampleyoutubeplayerview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    public static final String VIDEO_ID = "gQMmVCv8P3w";
    public static final String VIDEO = "https://www.youtube.com/watch?v=gQMmVCv8P3w";


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        YouTubePlayerView youtubePlayer = (YouTubePlayerView) findViewById(R.id.youtubePlayer);
        youtubePlayer.initialize(getResources().getString(R.string.keyAPIYoutube), this);

        Button button = (Button) findViewById(R.id.nextExample);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(v.getContext(), VideosActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Log.i("APIYOUTUBE", "onInitializationSuccess");
        youTubePlayer.cueVideo(VIDEO_ID);
//        youTubePlayer.loadVideo(VIDEO);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.i("APIYOUTUBE", "onInitializationFailure");
        Toast.makeText(this, "Falha ao inicializar", Toast.LENGTH_SHORT).show();
    }

}
