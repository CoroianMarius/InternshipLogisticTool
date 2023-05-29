import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Component, OnInit} from '@angular/core';
import {map, pipe} from "rxjs";
import {Student} from "../model/Student";

@Component({
  selector: 'app-view-team',
  templateUrl: './view-team.component.html',
  styleUrls: ['./view-team.component.css']
})
export class ViewTeamComponent implements OnInit{
  allLeaders: Student[] = [];
  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.ViewTeamLeaders();
  }

  private ViewTeamLeaders(){
    this.http.get<{[key:string]: Student}>('http://localhost:8080/api/student/leaders')
      .pipe(map((res) => {
        const Leaders = [];
        for(const key in res){
          if(res.hasOwnProperty(key)){
            Leaders.push({...res[key], id: key})
          }
        }
        return Leaders;
      }))
      .subscribe((Leaders) => {
        console.log(Leaders);
        this.allLeaders= Leaders;
      })
  }
}
