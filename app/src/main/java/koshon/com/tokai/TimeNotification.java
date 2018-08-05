package koshon.com.tokai;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class TimeNotification extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Notification text")
                        .setAutoCancel(true)
                // .setOngoing(true)
                // .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                ;
        // alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        //builder.setSound(alarmSound);

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);


        Intent intentTL = new Intent(context, MainActivity.class);

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + AlarmManager.INTERVAL_DAY, pendingIntent);
    }

}
