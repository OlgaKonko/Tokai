package koshon.com.tokai.controler;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import koshon.com.tokai.models.Alarm;
import koshon.com.tokai.models.AlarmStatus;
import koshon.com.tokai.models.AlarmsList;

public class AlarmsWorker {
    private AlarmsList alarms;

    public AlarmsWorker() {
        try {
            System.out.println("LOG start loading alarms");
            loadAlarms();
            System.out.println("LOG end loading alarms");
        }
        catch (Exception e){
            System.out.println("LOG create new alarms");
            alarms = new AlarmsList();
        }
    }

    public AlarmsList getAlarmManager() {
        return alarms;
    }

    public void addAlarm(String target, Date alarmTime, long alarmTerm, boolean isDirect){
        alarms.addAlarm(target, alarmTime, alarmTerm, isDirect);
    }

    private void loadAlarms() throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
            fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        alarms = (AlarmsList) oin.readObject();
    }

    private void saveAlarms(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(alarms);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
