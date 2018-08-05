package koshon.com.tokai;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import java.util.Date;

import koshon.com.tokai.controler.AlarmsWorker;
import koshon.com.tokai.models.Alarm;

public class MainActivity extends ActionBarActivity {
    AlarmManager am;
    Date stamp;
    NotificationManager nm;
    AlarmsWorker alarmsWorker;
    Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stamp = new Date();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true);
        loadAlarms();
    }

    private void loadAlarms() {
    alarmsWorker= new AlarmsWorker();
    if (alarmsWorker.getAlarmManager().getMaxIndex()>0)
    for (int index = 0; index< alarmsWorker.getAlarmManager().getAllAlarms().size(); index++){
        Alarm alarm = alarmsWorker.getAlarmManager().getAllAlarms().get(index);
    drawer.addDrawerItems(
                new PrimaryDrawerItem().withName(alarm.getTarget()).withIdentifier(alarm.getId()));
    }
        drawer.build();

    }

    private void restartNotify() {
        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, TimeNotification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT );
        am.cancel(pendingIntent);
        am.set(AlarmManager.RTC_WAKEUP, stamp.getTime(), pendingIntent);
    }

    public void setAlarm(View view) {
        stamp.setTime(new Date().getTime()+10);
        restartNotify();
    }
}
