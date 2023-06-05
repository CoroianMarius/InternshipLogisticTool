import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Component, OnInit} from '@angular/core';
import {map, pipe} from "rxjs";
import {Student} from "../model/Student";
import {Team} from "../model/Team";
import {ViewTeamService} from "../services/view-team.service";

@Component({
  selector: 'app-view-team',
  templateUrl: './view-team.component.html',
  styleUrls: ['./view-team.component.css']
})
export class ViewTeamComponent implements OnInit {
  allStudents: Student[]= [] ;
  selectedStud!: Student;
  selected!:boolean;
  selectedLeader?: Student;
  allLeaders: Student[] = [];

  constructor(private http: HttpClient, private ViewTeamService: ViewTeamService) {
  }

  ngOnInit() {
    this.ViewTeamLeaders();
  }

  private ViewTeamLeaders(){
    this.ViewTeamService.ViewTeamLeaders().subscribe((Leaders) => {
      console.log(Leaders);
      this.allLeaders = Leaders;
    });
}

  onSelectLeader(Leader: Student){
    this.selectedLeader=Leader;
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
  selectedStudent(student:Student){
    this.selectedStud = student;
    this.selected=true;

  }


}
