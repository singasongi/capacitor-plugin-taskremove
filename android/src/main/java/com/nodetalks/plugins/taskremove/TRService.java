package com.nodetalks.plugins.taskremove;

import android.util.Log;
import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.content.Intent;
import android.os.Handler;
import android.content.Context;

public class TRService extends Service {
    public final String TAG = "TaskRemoveService";

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Service onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service Started");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }

    //@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d(TAG, "Service onTaskRemoved");
        this.stopSelf();
        super.onTaskRemoved(rootIntent);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}