package ru.sbt.mipt.oop;

/**
 * Created by 11007139 on 10.12.2017.
 */
public class AlarmSystemStateAlarm implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateAlarm(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }


    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ALARM;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {

    }
}
