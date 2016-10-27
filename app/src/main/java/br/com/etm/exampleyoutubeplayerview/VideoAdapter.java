package br.com.etm.exampleyoutubeplayerview;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

/**
 * Created by EDUARDO_MARGOTO on 10/27/2016.
 */

public class VideoAdapter extends BaseAdapter {

    Activity activity;
    List<Video> videos;

    public VideoAdapter(Activity activity, List<Video> videos) {
        this.activity = activity;
        this.videos = videos;
    }

    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_video, parent, false);
        view.setTag(videos.get(position).getVideo_id());

        TextView title = (TextView) view.findViewById(R.id.title);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.youtubePlayerView);

        youTubePlayerView.setTag(videos.get(position).getVideo_id());

        youTubePlayerView.initialize(activity.getResources().getString(R.string.keyAPIYoutube), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(videos.get(position).getVideo_id());
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(activity, "Falha ao inicializar", Toast.LENGTH_SHORT).show();
            }
        });
        title.setText(videos.get(position).getTitle());


        return view;
    }
}
