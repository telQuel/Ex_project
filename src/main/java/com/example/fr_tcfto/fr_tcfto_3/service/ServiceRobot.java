package com.example.fr_tcfto.fr_tcfto_3.service;

import com.example.fr_tcfto.fr_tcfto_3.DAO.RobotRepository;
import com.example.fr_tcfto.fr_tcfto_3.entity.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRobot {

    private final RobotRepository robotRepository;

    public ServiceRobot(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

    public List<Robot> getAllRobots() {

//        Session session = entityManager.unwrap(Session.class);
//        session.beginTransaction();

//        Query<Robot> query = session.createQuery("from Robot", Robot.class);

//        List<Robot> allRobots = query.getResultList();
        return robotRepository.findAll();
    }
    public String getRobotNameById(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Robot> query = session.createQuery("from Robot where id = $id", Robot.class);

        Robot robot = null;
        Optional<Robot> robotOptional = robotRepository.findById(id);
        if (robotOptional.isPresent()){
            robot = robotOptional.get();
        }
        return robot.getRobotName();
    }

    public Robot saveRobot(Robot robot){
        return robotRepository.save(robot);
    }
}
