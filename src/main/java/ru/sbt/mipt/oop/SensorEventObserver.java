package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

/**
 * Created by 11007139 on 10.11.2017.
 */
public class SensorEventObserver {
    private Collection<EventHandler> eventHandlers = new ArrayList<>();
    private SmartHome smartHome;

    public SensorEventObserver(SmartHome smartHome) {
        this.smartHome = smartHome;
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

    public void setHandlers(List<EventHandler> handlers) {
        this.eventHandlers = handlers;
    }
}
