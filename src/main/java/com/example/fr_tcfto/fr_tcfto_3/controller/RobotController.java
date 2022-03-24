package com.example.fr_tcfto.fr_tcfto_3.controller;


import com.example.fr_tcfto.fr_tcfto_3.service.ServiceRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;

@Controller
//@RequestMapping("/all")
public class RobotController {

    @Autowired
    private ServiceRobot service;

//    @RequestMapping("/robotInfo")
//    public String showAllRobot(Model model) {
//
//        List<Robot> allRobot = service.getAllRobots();
//        model.addAttribute("allRobots", allRobot);
//
//        return "allRobot";
//    }

    @GetMapping(value = "/robotInfo")
    public String showAllRobot(){
        //model.addAttribute("robotName", service.getRobotNameById(1));
        return "allRobot";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showView(){
        return "viewex";
    }

}
