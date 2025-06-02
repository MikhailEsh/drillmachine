package org.kenik.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestControllerV1 {

//  private final StepperMotorService stepperMotorService;


  @PostConstruct
  public void init() {
    int asd = 0;
  }

  @GetMapping("/test")
  public String test() {
    log.info("Test request received");
    return "Hello, World!";
  }

  @PostMapping("/startTest")
  public void startTest() {
//    stepperMotorService.startTestProgram();
  }
}
