package com.ruichaoqun

import android.content.ComponentName
import android.os.Bundle

class LuckyMediaBrowser {

    interface MediaBrowserImpl{
        fun connect()
        fun disconnect()
        fun isConnected():Boolean
        fun getServiceComponent(): ComponentName
        fun getRoot():String
        fun getExtras():Bundle

    }
}