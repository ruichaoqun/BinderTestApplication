// IMediaBrowserServiceCallbacks.aidl
package com.ruichaoqun.bindertestapplication;

import android.content.pm.ParceledListSlice;
import android.graphics.Bitmap;
import android.media.session.MediaSession;
import android.os.Bundle;

// Declare any non-default types here with import statements

oneway interface IMediaBrowserServiceCallbacks {
        void onConnect(String root, in MediaSession.Token session, in Bundle extras);
       void onConnectFailed();
       void onLoadChildren(String mediaId, in ParceledListSlice list);
       void onLoadChildrenWithOptions(String mediaId, in ParceledListSlice list, in Bundle options);
}