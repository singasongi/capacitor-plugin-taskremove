package com.nodetalks.plugins.taskremove;

import android.util.Log;
import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.content.Intent;
import android.os.Handler;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import android.content.Context;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.NotificationChannel;

public class TRServiceOreo extends Service {
    public final String TAG = "TaskRemoveServiceOreo";
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Service onBind");
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service Started");
        NotificationManager  notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Context context = getApplicationContext();
            NotificationChannel channel = new NotificationChannel("Background", "Service", NotificationManager.IMPORTANCE_LOW);
            notificationManager.createNotificationChannel(channel);

            Notification notification = new NotificationCompat.Builder(context,"Background")
                    .setContentTitle("")
                    .setContentText("").build();
            startForeground(1, notification);


            Intent serviceIntent = new Intent(context, TRService.class);
            context.startService(serviceIntent);

            stopForeground(true);
            stopSelf();

        }
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
    }
}