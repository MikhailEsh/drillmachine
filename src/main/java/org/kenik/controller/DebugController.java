package org.kenik.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/debug")
@RequiredArgsConstructor
public class DebugController {


  @GetMapping("/debug")
  public String convertToOdinAss() {
    return "message";
  }
}
