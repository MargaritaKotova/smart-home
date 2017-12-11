package ru.sbt.mipt.oop;

/**
 * Created by 11007139 on 17.11.2017.
 */
public interface AlarmSystemState {
    AlarmSystemStateEnum getState();

    public void turnOn();

    void turnOff();

    void onSensorEvent(SensorEvent sensorEvent);

    public void enterPassword(String password);
}
