package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

/**
 * Created by 11007139 on 11.12.2017.
 */
public class LightEventProcessorTest {

    @Test
    public void handle(){
        LightEventProcessor lightEvent = new LightEventProcessor();
        SmartHome home = new SmartHome();

        Light light = new Light("2", false);
        home.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "room"));
        SensorEvent event = new SensorEvent(LIGHT_ON, "2");
        lightEvent.handle(home, event);
        assertTrue(light.isOn());
    }

    @Test
    public void TestEvents(){
        Light light1 = new Light("1", false);
        Light light2 = new Light("2", true);
        Light light3 = new Light("3", false);
        Room room1 = new Room(Arrays.asList(light1,light2), Collections.emptyList(), "room1");
        Room room2 = new Room(Arrays.asList(light1,light2,light3), Collections.emptyList(), "room2");
        LightEventProcessor lightEvent = new LightEventProcessor();

        SensorEvent event1 = new SensorEvent(LIGHT_OFF, "1");
        SensorEvent event2 = new SensorEvent(LIGHT_ON, "2");

        lightEvent.StatusOfLight(event1,room1,light1);
        assertFalse(light1.isOn());

        lightEvent.StatusOfLight(event2,room1,light2);
        assertTrue(light2.isOn());

        lightEvent.StatusOfLight(event2,room2,light3);
        assertTrue(light3.isOn());
    }

    @Test
    public void TurnLightsON() {
        SmartHome smartHome = new SmartHome();
        EventHandler turnlightson = new LightEventProcessor();
        List <SensorEvent> lightEvent = new ArrayList<>();

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                lightEvent.add(new SensorEvent(LIGHT_ON, light.getId()));
            }
        }

        for (SensorEvent event: lightEvent) {
            turnlightson.handle(smartHome, event);
        }

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertEquals(true, light.isOn());
            }
        }
    }


}