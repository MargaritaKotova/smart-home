package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        // считываем состояние дома из файла
       //  SmartHome smartHome = SmartHomeFileReader.read();
        // начинаем цикл обработки событий
        //  SensorEventObserver sensorEventObserver = new SensorEventObserver();
        SmartHome smartHome = ctx.getBean(SmartHome.class);
        SensorEventObserver sensorEventObserver = (SensorEventObserver) ctx.getBean("sensorEventObserver");
//        configureHandlers(sensorEventObserver);
        sensorEventObserver.runEventCycle(smartHome);
    }

    private static void configureHandlers(SensorEventObserver observer) {
        observer.addHandler(new DoorEventProcessor());
    }

    public static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }

}
