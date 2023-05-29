package com.ibm.den.controller;

import com.ibm.den.dto.AttendanceDto;
import com.ibm.den.services.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:56903")
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }

    @GetMapping("/{studentEmail}")
    public ArrayList<AttendanceDto> getAttendance(@PathVariable String studentEmail){
        return attendanceService.getAttendance(studentEmail);
    }

    @GetMapping("/list{studentEmail}")
    public ArrayList<ArrayList<AttendanceDto>> getAttendanceList(@PathVariable String studentEmail){
        return attendanceService.getAttendanceList(studentEmail);
    }

    @PostMapping("/{studentEmail}{taskName}")
    public AttendanceDto createAttendance(@PathVariable String studentEmail, @PathVariable String taskName){
        return attendanceService.createAttendance(studentEmail, taskName);
    }
}
