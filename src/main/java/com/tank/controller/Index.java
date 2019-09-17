package com.tank.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.tank.constants.RouterPrefix.fixedPrefix;

/**
 * @author tank198435163.com
 */

@RestController
@RequestMapping(value = fixedPrefix)
@RefreshScope
public class Index {

  @GetMapping(path = "/list")
  public ResponseEntity<Map<String, String>> list() {
    Map<String, String> parameters = new HashMap<>(CAPACITY);
    parameters.putIfAbsent("status", "ok");
    parameters.putIfAbsent("expireDay", String.valueOf(this.expireDay));
    return ResponseEntity.ok(parameters);
  }

  @Value(value = "${sysconfig.expireDay:0}")
  private int expireDay;


  private static final int CAPACITY = 16;
}
