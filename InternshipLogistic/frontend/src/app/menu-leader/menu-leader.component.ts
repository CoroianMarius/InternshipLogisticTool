import { ActivatedRoute, Params } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Student } from '../model/Student';
import { ViewTeamService } from '../services/view-team.service';
import {Team} from "../model/Team";


@Component({
  selector: 'app-menu-leader',
  templateUrl: './menu-leader.component.html',
  styleUrls: ['./menu-leader.component.css']
})
export class MenuLeaderComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private viewTeamService: ViewTeamService
  ) {}

  logedin?:string;
  allStudents: Student[]= [] ;


  selectedLeader=new  Student("Student12","email12",true);

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const userName = params['name'];
      const userEmail = params['email'];
      // Use the user's name and email as needed
    });
    this.ViewTeam(this.selectedLeader);
  }
  ViewTeam(Leader:Student)
  {
    this.http.get<any>('http://localhost:8080/api/team/' +Leader.email)
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

}
