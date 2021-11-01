// IMediaBrowserService.aidl
package com.ruichaoqun.bindertestapplication;
import android.content.res.Configuration;
import com.ruichaoqun.bindertestapplication.IMediaBrowserServiceCallbacks;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;

// Declare any non-default types here with import statements

oneway interface IMediaBrowserService {
        void connect(String pkg, in Bundle rootHints, IMediaBrowserServiceCallbacks callbacks);
       void disconnect(IMediaBrowserServiceCallbacks callbacks);

       void addSubscriptionDeprecated(String uri, IMediaBrowserServiceCallbacks callbacks);
       void removeSubscriptionDeprecated(String uri, IMediaBrowserServiceCallbacks callbacks);

       void getMediaItem(String uri, in ResultReceiver cb, IMediaBrowserServiceCallbacks callbacks);
       void addSubscription(String uri, in IBinder token, in Bundle options,
               IMediaBrowserServiceCallbacks callbacks);
       void removeSubscription(String uri, in IBinder token, IMediaBrowserServiceCallbacks callbacks);
}