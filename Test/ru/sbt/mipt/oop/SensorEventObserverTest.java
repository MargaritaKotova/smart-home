package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
/**
 * Created by 11007139 on 17.12.2017.
 */
public class SensorEventObserverTest {

        @Test
        public void test() {
            SmartHome smartHome = mock(SmartHome.class);
            LightEventProcessor lightEventProcessor = mock(LightEventProcessor.class);
            DoorEventProcessor doorEventProcessor = mock(DoorEventProcessor.class);
            ScenarioRunner scenarioRunner = mock(ScenarioRunner.class);

            SensorEventObserver sensorEventObserver = new SensorEventObserver(smartHome);
            sensorEventObserver.addHandler(lightEventProcessor);
            sensorEventObserver.addHandler(doorEventProcessor);
            sensorEventObserver.addHandler(scenarioRunner);

            SensorEvent sensorEvent = mock(SensorEvent.class);
            sensorEventObserver.Event(sensorEvent);

            verify(lightEventProcessor).handle(smartHome, sensorEvent);
            verify(doorEventProcessor).handle(smartHome, sensorEvent);
            verify(scenarioRunner).handle(smartHome, sensorEvent);
        }

}