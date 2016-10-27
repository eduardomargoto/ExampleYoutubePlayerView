package br.com.etm.exampleyoutubeplayerview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EDUARDO_MARGOTO on 10/27/2016.
 */

public class VideosActivity extends YouTubeBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_videos);

        ListView listView = (ListView) findViewById(R.id.listView);
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("Unravel", "gQMmVCv8P3w"));
        videos.add(new Video("Eir Aoi - Ignite", "mTCESSzPZSw"));
        videos.add(new Video("Eir Aoi - INNOCENCE (Music Video)", "hAJM3DatBJY"));

        listView.setAdapter(new VideoAdapter(this, videos));
    }


}
