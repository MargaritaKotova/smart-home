package ru.sbt.mipt.oop;


import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventProcessor implements EventHandler {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (!LightEvent(event))
            return;

            // событие от источника света
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        StatusOfLight(event, room, light);
                    }
                }
            }

    }

    public void StatusOfLight(SensorEvent event, Room room, Light light) {
        if (event.getType() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
        } else {
            light.setOn(false);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
        }
    }

    private boolean LightEvent(SensorEvent event) {
        return  (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF);
    }

}
