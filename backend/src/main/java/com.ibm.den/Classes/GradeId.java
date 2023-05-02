package com.ibm.den.Classes;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class GradeId implements Serializable {
    private Long mentor_id;
    private Long student_id;
    private Long task_id;




    public GradeId(Long mentor_id, Long student_id, Long task_id) {
            this.mentor_id = mentor_id;
            this.student_id = student_id;
            this.task_id = task_id;
        }

    public GradeId() {
    }

    public Long getMentor_id () {
            return mentor_id;
        }

        public void setMentor_id (Long mentor_id){
            this.mentor_id = mentor_id;
        }

        public Long getStudent_id () {
            return student_id;
        }

        public void setStudent_id (Long student_id){
            this.student_id = student_id;
        }

        public Long getTask_id () {
            return task_id;
        }

        public void setTask_id (Long task_id){
            this.task_id = task_id;
        }

        @Override
        public String toString () {
            return "GradeId{" +
                    "mentor_id=" + mentor_id +
                    ", student_id=" + student_id +
                    ", task_id=" + task_id +
                    '}';
        }
    }

