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
  Students?: Student[];

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

  onSelect(leader: Student) {
    this.http
      .get<any>(`http://localhost:8080/api/team/${leader.email}`)
      .pipe(map((response) => {
        const students = [];
        for (const key in response) {
          if (response.hasOwnProperty(key)) {
            students.push({...response[key], id: key});
          }
        }
        return students;
      }))
      .subscribe((response) => {
        this.Students = response; // Assign the retrieved students to the Students property
      });
  }


}
