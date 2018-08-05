package koshon.com.tokai.models;

import java.io.Serializable;
import java.util.Date;

public class Alarm implements Serializable {
    private int id;
    private String target;
    private Date alarmTime;
    private long alarmTerm;
    private boolean isDirect;
    private AlarmStatus status;

    public Alarm(int id, String target, Date alarmTime, long alarmTerm, boolean isDirect, AlarmStatus status) {
        this.id = id;
        this.target = target;
        this.alarmTime = alarmTime;
        this.alarmTerm = alarmTerm;
        this.isDirect = isDirect;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public long getAlarmTerm() {
        return alarmTerm;
    }

    public void setAlarmTerm(long alarmTerm) {
        this.alarmTerm = alarmTerm;
    }

    public boolean isDirect() {
        return isDirect;
    }

    public void setDirect(boolean direct) {
        isDirect = direct;
    }

    public AlarmStatus getStatus() {
        return status;
    }

    public void setStatus(AlarmStatus status) {
        this.status = status;
    }
}
