package com.example.fr_tcfto.fr_tcfto_3.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;

@Entity
    @Table(name = "robot_data")
    @JsonRootName(value = "robots: ")
    public class Robot {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_robot")
        private int id;

        @Column(name = "name_robot")
        private String robotName;

        @Column(name = "taking_to_work")
        private String dateTakeToWork;

        @Column(name = "deadline")
        private String deadline;

        @Column(name = "status")
        private int status;

        @Column(name = "fio_developer")
        private String FioDeveloper;

        public Robot() {
        }

        public Robot(String robotName, String dateTakeToWork, String deadline, int status, String fioDeveloper) {
            this.robotName = robotName;
            this.dateTakeToWork = dateTakeToWork;
            this.deadline = deadline;
            this.status = status;
            FioDeveloper = fioDeveloper;
        }

        public String getRobotName() {
            return robotName;
        }

        public void setRobotName(String robotName) {
            this.robotName = robotName;
        }

        public String getDateTakeToWork() {
            return dateTakeToWork;
        }

        public void setDateTakeToWork(String dateTakeToWork) {
            this.dateTakeToWork = dateTakeToWork;
        }

        public String getDeadline() {
            return deadline;
        }

        public void setDeadline(String deadline) {
            this.deadline = deadline;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFioDeveloper() {
            return FioDeveloper;
        }

        public void setFioDeveloper(String fioDeveloper) {
            FioDeveloper = fioDeveloper;
        }
    }
