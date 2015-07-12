package com.ganttech.udacity.spotifystreamer;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by JMan13 on 7/12/15.
 */
public class StreamTrackService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public StreamTrackService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
