package ru.sbt.mipt.oop;

/**
 * Created by 11007139 on 17.11.2017.
 */
public class AlarmSystem  {
    private AlarmSystem alarmSystem;
    private AlarmSystemState state;
    private String password;

    public AlarmSystem(){
        state = new AlarmSystemOffState(this);
    }


    public AlarmSystemStateEnum getState() {
        return state.getState();
    }

    public void turnOn(){
        state.turnOn();
    }

   public void onSensorEvent(SensorEvent event) {
        //if (state.getState() == AlarmSystemStateEnum.OFF) return;
        state.onSensorEvent(event);
    }

    public void setState(AlarmSystemState state){
        this.state=state;
    }

}
