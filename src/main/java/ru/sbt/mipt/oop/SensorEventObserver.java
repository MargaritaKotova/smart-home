package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

/**
 * Created by 11007139 on 10.11.2017.
 */
public class SensorEventObserver {
    private Collection<EventHandler> eventHandlers = new ArrayList<>();
    private SmartHome smartHome;

    public SensorEventObserver() {

    }

    public void runEventCycle(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler eventHandler : eventHandlers) {
                eventHandler.handle(smartHome, event);
            }
            event = getNextSensorEvent();
        }
    }

    public void addHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }
}
