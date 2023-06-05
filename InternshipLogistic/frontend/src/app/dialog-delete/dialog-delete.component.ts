import { ActivatedRoute, Params } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { map } from 'rxjs/operators';
import { Student } from '../model/Student';
import { ViewTeamService } from '../services/view-team.service';
import {Team} from "../model/Team";
import { ChartType, ChartOptions } from 'chart.js';
import {Grade} from "../model/Grade";
import {ViewGradesTeamService} from "../services/view-grades-team.service";
import { AuthService } from '../services/auth.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-dialog-delete',
  templateUrl: './dialog-delete.component.html',
  styleUrls: ['./dialog-delete.component.css']
})
export class DialogDeleteComponent implements OnInit {
  @Output() memberDeleted: EventEmitter<string> = new EventEmitter<string>();
  allStudents: Student[] = [];
  selectedLeader:Student;

  constructor(private http: HttpClient, private authService: AuthService) {
    this.selectedLeader=this.authService.getLoggedInUser();
  }

  deleteMemberFromTeam(student: Student) {
    const studentEmail = student.email;

    // Send a DELETE request to delete the student from the server
    this.http.delete(`http://localhost:8080/api/team/${studentEmail}`)
      .subscribe(() => {
        // Update the member list or perform any necessary actions after deletion
        this.fetchUpdatedMembers();
        this.memberDeleted.emit(studentEmail);
      });
  }


  fetchUpdatedMembers() {
    // Fetch the updated member list from the server
    this.http.get<any>('http://localhost:8080/api/team/' +this.selectedLeader.email)
      .pipe(map((res) => {
        const Team = [];
        for(const key in res){
          if (key !== 'id') {
            const student = { ...res[key], id: key };
            delete student.id; // Exclude the 'id' property
            Team.push(student);
          }
        }
        return Team;
      }))
      .subscribe((Team) =>{
        console.log(Team[1]);
        const studentObject=Team[1];
        this.allStudents=  Object.values(studentObject);
      })
  }
  ngOnInit() {
    this.fetchUpdatedMembers();
  }

}
