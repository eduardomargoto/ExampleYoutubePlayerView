package br.com.etm.exampleyoutubeplayerview;

/**
 * Created by EDUARDO_MARGOTO on 10/27/2016.
 */

public class Video {

    String title;
    String video_id;

    public Video(String title, String video_id) {
        this.title = title;
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }
}
