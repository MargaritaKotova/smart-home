package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by 11007139 on 11.12.2017.
 */
public class DoorEventProcessorTest {

    @Test
    public void handle() {
        DoorEventProcessor DoorEvent = new DoorEventProcessor();
        SmartHome home = new SmartHome();
        Door door = new Door(false, "2");

         home.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door), "room"));
        SensorEvent event = new SensorEvent(DOOR_OPEN, "2");
        DoorEvent.handle(home, event);
        assertTrue(door.isOpen());
    }


    @Test
     public void ifroomishall(){
     DoorEventProcessor doorevent = new DoorEventProcessor();
        SmartHome home = new SmartHome();

        Door door = new Door(true, "2");
        Light light = new Light("2", true);

        home.addRoom(new Room(Arrays.asList(light), Arrays.asList(door), "hall"));
        SensorEvent event = new SensorEvent(DOOR_CLOSED, "2");

         doorevent.handle(home, event);
         assertFalse(door.isOpen());
         assertFalse(light.isOn());
    }

    @Test
    public void TestEvents(){

        SmartHome home = new SmartHome();

        Door door1 = new Door(true,"1");
        Door door2 = new Door(false,"2");

        Room room1 = new Room(Collections.emptyList(),Arrays.asList(door1,door2), "room1");
        Room room2 = new Room(Collections.emptyList(),Arrays.asList(door1), "room2");
        DoorEventProcessor DoorEvent = new DoorEventProcessor();

        SensorEvent event1 = new SensorEvent(DOOR_OPEN, "1");
        SensorEvent event2 = new SensorEvent(DOOR_CLOSED, "2");


        DoorEvent.Doorstatus(home,event1,room1,door2);
        assertTrue(door2.isOpen());

        DoorEvent.Doorstatus(home,event2,room2,door1);
        assertFalse(door1.isOpen());
    }

}