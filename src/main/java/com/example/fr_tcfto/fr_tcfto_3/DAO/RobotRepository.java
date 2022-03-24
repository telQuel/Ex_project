package com.example.fr_tcfto.fr_tcfto_3.DAO;

import com.example.fr_tcfto.fr_tcfto_3.entity.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends JpaRepository<Robot, Integer> {
}
