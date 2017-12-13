package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

/**
 * Created by 11007139 on 13.12.2017.
 */
public class ScenarioRunnerTest {
    @Test
    public void handle() throws Exception {
        SmartHome home = new SmartHome();
        ScenarioRunner  scenarioRunner = new ScenarioRunner();


        Light light1 = new Light("1", true);
        Light light2 = new Light("2", true);
        Door door = new Door(true,"3");

        home.addRoom(new Room(Arrays.asList(light1), Collections.emptyList(), "room1"));
        home.addRoom(new Room(Arrays.asList(light2), Collections.emptyList(), "room2"));
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door), "hall"));

        SensorEvent event = new SensorEvent(DOOR_CLOSED, "3");

        scenarioRunner.handle(home,event);

        for (Room room : home.getRooms()) {
            for (Light light : room.getLights()) {
                assertEquals(false, light.isOn());
            }
        }

    }

}