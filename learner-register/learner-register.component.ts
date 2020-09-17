import { Component, OnInit } from '@angular/core';
import {Course} from '../models/course';
import { LearnerViewService } from '../learner-view.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Trainings } from '../models/trainings';
import { MentorSkills } from '../models/MentorSkills';
import { AdminService } from '../admin.service';
import { ErrorService } from '../error.service';
@Component({
  selector: 'app-learner-register',
  templateUrl: './learner-register.component.html',
  styleUrls: ['./learner-register.component.css']
})
export class LearnerRegisterComponent implements OnInit {

  mcourse : MentorSkills[];
  courseNamesFromCourseTable:Course[];
  objCourse:Trainings;
  coursename:string;
  mentorname:string;
  course_id:number;
  value:Boolean
  mntr_user_id:number;
  errorBlock: any;
  courseData:{coursename:any};
  filteredCourse: MentorSkills[];
  courseStatus="yetToStart";
  len:number;

  constructor(private learnerViewService: LearnerViewService,
    private httpService: HttpClient,
    private router:Router,
    private adminService:AdminService,
    private errorService:ErrorService) { }
   
  ngOnInit() {
  this.learnerViewService.getMentorCourse(this.adminService.user_id).subscribe(
    data=>
    {this.courseNamesFromCourseTable = data}, 
    error=> {
  console.log(error);
  this.errorBlock = error;
  this.errorService.errorStatusCheck(error.status);
  console.log(this.coursename)
      });
   
    }
   
  choose(){
  
  console.log(this.mcourse)
  console.log(this.coursename)
 
  this.learnerViewService.getMentor(this.coursename).subscribe(data=>
     {
       
       this.filteredCourse=data; console.log(data);
       this.len=this.filteredCourse.length;
       console.log("for get the mentors details for selected courses "+this.len);
       if(this.len==0)
        alert("Sorry for inconvenience,No mentor for "+this.coursename);
    } , error=> {
  console.log(error);

  this.errorBlock = error;
  this.errorService.errorStatusCheck(error.status);
  
      });
      console.log("for checking the learner id:"+this.adminService.user_id);
 
 //for checking course name
  for (let index = 0; index < this.courseNamesFromCourseTable.length; index++) {
    if(this.courseNamesFromCourseTable[index].coursename===this.coursename )
    this.course_id = this.courseNamesFromCourseTable[index].courseId;
    
  }
//for checking mentor name
  for (let index = 0; index < this.len; index++) {
  if(this.filteredCourse[index].username===this.mentorname)
    this.mntr_user_id = this.filteredCourse[index].user_id;
   
      }
      console.log("for checking the mentor id "+this.mntr_user_id);
      console.log("selected values and storing in the trainings table:"+this.course_id+this.coursename);
     
//       this.objCourse.lrnr_user_id=this.adminService.user_id;
//       this.objCourse.course_nm= this.coursename;
//   this.objCourse.course_id=this.course_id;
//   console.log(this.course_id);
//   this.objCourse.status = "yetToStart";
//   this.objCourse.mntr_nm = this.mentorname;
//   this.objCourse.mntr_user_id=this.mntr_user_id;
//   this.objCourse.lrnr_nm=this.adminService.username;
//  console.log(this.objCourse.course_nm);
  console.log("final obj for storing in trainings table "+this.objCourse);
    }
  
  

  chooseCourse(){
    let objCourse=new Trainings(this.course_id,
      this.coursename,
      this.adminService.username,
      this.adminService.user_id,
      this.mentorname,
      this.mntr_user_id,
      this.courseStatus);
    if(this.coursename == null || this.mentorname== null){
      alert ("please select the course name and mentor name");
    }
  //   if(this.objCourse.mntr_nm!= null){
  //   for(var i=0;i<this.mentor.length;i++){
  //     if(this.mentorname== this.mentor[i]){
  //       alert("mentor Already exist");
  //     }
  //   }
  // }
    else{
      console.log("in else part"+this.objCourse);
      this.learnerViewService.createTrainer(objCourse).subscribe(
        response=>{
          this.objCourse=response;
          this.router.navigate(['/view']);
        },
        error=>{
          //this.errorStatus=true;
          this.errorService.errorStatusCheck(error.status);
        }
        );     
       
  }
}  // close of chooseCourse()

}
