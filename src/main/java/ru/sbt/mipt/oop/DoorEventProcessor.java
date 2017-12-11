package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventHandler {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (!DoorEvent(event))
            return;

            // событие от двери
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId())) {

                        Doorstatus(smartHome, event, room, door);
                    }
                }
            }
        }

    private void Doorstatus(SmartHome smartHome,SensorEvent event, Room room, Door door){
        if (event.getType() == DOOR_OPEN) {
            door.setOpen(true);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
        } else {
            door.setOpen(false);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
            // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
            // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
            if (room.getName().equals("hall")) {
                for (Room homeRoom : smartHome.getRooms()) {
                    for (Light light : homeRoom.getLights()) {
                        light.setOn(false);
                        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                        sendCommand(command);

                    }
                }
            }
        }
    }


    private boolean DoorEvent(SensorEvent event) {
        return  (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED);
        }

    private static void sendCommand(SensorCommand command) {
        System.out.println("sending" + command);
    }
}
