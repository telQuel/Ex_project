package com.example.fr_tcfto.fr_tcfto_3.controller;

import com.example.fr_tcfto.fr_tcfto_3.entity.Robot;
import com.example.fr_tcfto.fr_tcfto_3.service.ServiceRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private ServiceRobot service;

    @GetMapping("/robots")
    public List<Robot> showAllRobots() {
        List<Robot> allRobots = service.getAllRobots();
        return allRobots;
    }
    @PostMapping("/addRobot")
    @ResponseStatus(HttpStatus.CREATED)
    public Robot addRobot(@RequestBody Robot robot){
        return service.saveRobot(robot);
    }
}
