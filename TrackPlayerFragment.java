package com.ganttech.udacity.spotifystreamer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


/**
 * A placeholder fragment containing a simple view.
 */
public class TrackPlayerFragment extends Fragment {
    String streamingUrl;
    private final String LOG_TAG = TrackPlayer.class.getSimpleName();

    public TrackPlayerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_track_player, container, false);

        TextView textView;  // Textview to find all views
        Log.v(LOG_TAG, "Before get Intent");
        // Get the artist name from the intent Extra
        Intent intent = getActivity().getIntent();
        String[] trackInfo = intent.getStringArrayExtra(TopTracksFragment.TRACK_QUERY_EXTRA);
//        String artistName = trackInfo[0];
        String albumName = trackInfo[0];
        String albumImg = trackInfo[1];
        String trackName = trackInfo[2];
        streamingUrl = trackInfo[3];

        // Artist Name
        Log.v(LOG_TAG, "Album Name:" + albumImg +"\nAlbum Image:"+albumImg+"\nTrackName:"+trackName
        +"\nStreamingURL:"+streamingUrl);
        textView = (TextView) getActivity().findViewById(R.id.trackplyr_artist_name_textview);
//        textView.setText(artistName);


        // Get the album name from the intent Extra
        textView = (TextView) getActivity().findViewById(R.id.trackplyr_album_name_textview);
        textView.setText(albumName);

        // Get the album image from the intent Extra
        ImageView imageView = (ImageView) getActivity().findViewById(R.id
                .trackplyr_album_imageview);
//        imageView.set

        // Get the track name from the intent Extra
        textView = (TextView) getActivity().findViewById(R.id.trackplyr_track_name_textview);
        textView.setText(trackName);

        // Get the album name from the intent Extra
        PlayTrack(streamingUrl);

        return rootView;
    }

    public void PlayTrack(String url){
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
}
