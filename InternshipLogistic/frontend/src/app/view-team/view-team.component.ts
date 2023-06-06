import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Component, OnInit} from '@angular/core';
import {map, pipe} from "rxjs";
import {Student} from "../model/Student";
import {Team} from "../model/Team";
import {ViewTeamService} from "../services/view-team.service";
import { AuthService } from '../services/auth.service';
import { NgForm } from "@angular/forms";


@Component({
  selector: 'app-view-team',
  templateUrl: './view-team.component.html',
  styleUrls: ['./view-team.component.css']
})
export class ViewTeamComponent implements OnInit {
  allStudents: Student[]= [] ;
  selectedStud!: Student;
  selected!:boolean;
  selectedGrading!: boolean;
  selectedAttendance!: boolean;
  selectedLeader?: Student;
  allLeaders: Student[] = [];
  options: string[] = [];
  formData: any;
  selectedMentor:Student;

  constructor(private http: HttpClient, private ViewTeamService: ViewTeamService,private authService: AuthService) {
    this.selectedMentor=this.authService.getLoggedInUser();
    console.log(this.selectedMentor);
  }

  ngOnInit() {
    this.ViewTeamLeaders();
    this.authService.setLoggedInUser(this.selectedMentor);
    this.TaskOptions();
  }

  private ViewTeamLeaders(){
    this.ViewTeamService.ViewTeamLeaders().subscribe((Leaders) => {
      console.log(Leaders);
      this.allLeaders = Leaders;
    });
}

  onSelectLeader(Leader: Student){
    this.selectedLeader=Leader;
    this.http.get<any>('http://localhost:8080/api/team/' + Leader.email)
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
  onGrading(){
    this.selectedGrading=true;
  }
  onAttendance(){
    this.selectedAttendance=true;
  }
  TaskOptions(){
    this.http.get<any>('http://localhost:8080/api/grade/ungraded/' + this.selectedStud.email).subscribe(((res)=>{
      this.options = res;
      console.log(this.options);
    }))
  }
  SubmitForm(form: NgForm){
    const TaskName = form.value.task;
    const Grade = form.value.grade;
    const Comment = form.value.comment;
    this.http.post('http://localhost:8080/api/grade', {task: TaskName, grade: Grade, comment: Comment, mentor: this.selectedMentor.name, emailStudent: this.selectedStud.email}).subscribe((res)=>{
      console.log(res);
    })
  }
  SubmitForm1(){

  }


}
