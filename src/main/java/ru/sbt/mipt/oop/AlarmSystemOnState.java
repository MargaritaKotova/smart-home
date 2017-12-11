package ru.sbt.mipt.oop;

/**
 * Created by 11007139 on 10.12.2017.
 */
public class AlarmSystemOnState implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemOnState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ON;
    }

    @Override
    public void turnOn() {}

    @Override
    public void turnOff() {
        alarmSystem.setState(new AlarmSystemWaitingState(alarmSystem));
    }

    @Override
    public void onSensorEvent(SensorEvent sensorEvent) {
        alarmSystem.setState(new AlarmSystemWaitingState(alarmSystem));
    }

    @Override
    public void enterPassword(String password) {

    }


}
