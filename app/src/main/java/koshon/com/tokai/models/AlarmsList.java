package koshon.com.tokai.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class AlarmsList implements Serializable {
    private ArrayList<Alarm> alarms;
    private int currentIndex;
    private int maxIndex;

    public AlarmsList() {
        maxIndex=0;
        alarms = new ArrayList<>();
    }

    public ArrayList<Alarm> getAllAlarms() {
        return alarms;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void addAlarm(String target, Date alarmTime, long alarmTerm, boolean isDirect){
        currentIndex=maxIndex;
        Alarm alarm = new Alarm(currentIndex, target, alarmTime, alarmTerm, isDirect, AlarmStatus.active);
        alarms.add(alarm);
        maxIndex++;
    }
}
