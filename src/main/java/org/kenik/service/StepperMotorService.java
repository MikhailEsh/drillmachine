//package org.kenik.service;
//
//import com.pi4j.Pi4J;
//import com.pi4j.context.Context;
//import com.pi4j.io.gpio.digital.DigitalOutput;
//import com.pi4j.io.gpio.digital.DigitalState;
//import com.pi4j.plugin.linuxfs.provider.gpio.digital.LinuxFsDigitalOutputProvider;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Service;
//
//@Service
//@Log4j2
//public class StepperMotorService {
//
//    private static final int PULSE_PIN = 3;  // Физический пин 11
//    private static final int DIRECTION_PIN = 4;  // Физический пин 13
//    private static final int ENABLE_PIN = 5;  // Физический пин 15
//
//    private Context pi4j;
//    private DigitalOutput pulseOutput;
//    private DigitalOutput directionOutput;
//    private DigitalOutput enableOutput;
//
//    public StepperMotorService() {
//        initializePi4j();
//    }
//
//    private void initializePi4j() {
//        log.info("Initializing Pi4J");
//        pi4j = Pi4J.newAutoContext();
//        log.info("Pi4J context created");
//        pulseOutput = createDigitalOutput(PULSE_PIN, "PULSE");
//        directionOutput = createDigitalOutput(DIRECTION_PIN, "DIRECTION");
//        enableOutput = createDigitalOutput(ENABLE_PIN, "ENABLE");
//        log.info("Digital outputs created");
//    }
//
//    private DigitalOutput createDigitalOutput(int pin, String name) {
//        log.info("Creating digital output for pin {} with name {}", pin, name);
//        return pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
//                .id("BCM" + pin)
//                .name(name)
//                .address(pin)
//                .provider(LinuxFsDigitalOutputProvider.class)
//                .initial(DigitalState.LOW)
//                .shutdown(DigitalState.LOW)
//                .build());
//    }
//
//    public void startTestProgram() {
//        try {
//            log.info("Start program");
//
//            // Изначально деактивируем драйвер
//            enableOutput.high();
//
//            // Управление двигателем
//            rotateMotor(200, true, 1);
//            Thread.sleep(1000);
//            rotateMotor(200, false, 1);
//
//            log.info("End program");
//        } catch (Exception e) {
//            log.error("Error: " + e.getMessage(), e);
//        }
//    }
//
//    private void rotateMotor(int steps, boolean clockwise, long stepDelay) {
//        try {
//            enableOutput.low();  // Активировать драйвер
//            directionOutput.setState(clockwise);
//
//            for (int i = 0; i < steps; i++) {
//                pulseOutput.high();
//                Thread.sleep(stepDelay);
//                pulseOutput.low();
//                Thread.sleep(stepDelay);
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        } finally {
//            enableOutput.high();  // Деактивировать драйвер
//        }
//    }
//
//    public void shutdown() {
//        if (pi4j != null) {
//            pi4j.shutdown();
//        }
//    }
//}