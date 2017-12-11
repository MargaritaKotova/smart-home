package ru.sbt.mipt.oop;

/**
 * Created by 11007139 on 10.12.2017.
 */
public class AlarmSystemOffState implements AlarmSystemState {
    private AlarmSystem alarmSystem;

    public AlarmSystemOffState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.OFF;
    }

    @Override
    public void turnOn() {
       alarmSystem.setState(new AlarmSystemOnState(alarmSystem) );
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
alarmSystem.setState(new AlarmSystemWaitingState(alarmSystem));
    }

    @Override
    public void enterPassword(String password) {

    }
}
