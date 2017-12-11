import org.junit.Test;
import ru.sbt.mipt.oop.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by 11007139 on 17.11.2017.
 */
public class AlarmSystemTest {

    @Test
    public void testNewSystemIsOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());

    }

    @Test
    public void testTurnOnSetsOnState() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }

    @Test
    public void testWaitsForPasswordWhenSensorEvent(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(
            SensorEventType.DOOR_OPEN,
            "1");
       alarmSystem.onSensorEvent(event);
       assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState()
);
        }

     @Test
    public void test2(){
         AlarmSystem alarmSystem = new AlarmSystem();
         alarmSystem.turnOn();
         SensorEvent event = new SensorEvent(
                 SensorEventType.DOOR_OPEN,
                 "1");
         alarmSystem.onSensorEvent(event);
         alarmSystem.turnOn();
         assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
     }

     @Test
     public void testDoesNotReactOnSensorWhenOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.onSensorEvent(createSensorEvent());
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
     }

     private SensorEvent createSensorEvent(){
          return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
     }
    }


