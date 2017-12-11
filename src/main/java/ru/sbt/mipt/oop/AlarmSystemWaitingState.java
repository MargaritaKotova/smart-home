package ru.sbt.mipt.oop;


public class AlarmSystemWaitingState  implements AlarmSystemState{

    private AlarmSystem alarmSystem;

    public AlarmSystemWaitingState(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public AlarmSystemWaitingState() {

    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
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
        if(password.equals("pass"))
            alarmSystem.setState(new AlarmSystemOffState(alarmSystem));
                }


}
