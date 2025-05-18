package org.kenik.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestControllerV1 {


  @PostConstruct
  public void init() {
    var asd = 0;
  }

  @PostMapping("/test")
  public String test() {
    return "Hello, World!";
  }

}
