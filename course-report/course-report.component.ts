import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdminReportService } from '../admin-report.service';
import {Trainings } from '../models/trainings';
import { DownloadService } from '../download.service';
import { Router } from '@angular/router';
import { ErrorComponent } from '../error/error.component';
import { ErrorService } from '../error.service';

@Component({
  selector: 'app-course-report',
  templateUrl: './course-report.component.html',
  styleUrls: ['./course-report.component.css']
})
export class CourseReportComponent implements OnInit {

  trainingsRef:Trainings[];
  courseStatus:String;
  fileName:string;
  excelName:string;
  dataFound:boolean;
  len:Number;
  errorStatus=false;
  errorMsg:String;
  downloadValue: string;

  constructor(public adminrepoService:AdminReportService,
    public downloadServiceRef:DownloadService,
    private router:Router,private errorService:ErrorService ) { }

  ngOnInit() {
    this.fileName="courseDetails";
    this.excelName='courseDetails.xlsx';
    //this.role="learner";
    console.log("in oninit method ");
    this.adminrepoService.getCourseDetails().subscribe(response =>
      {this.trainingsRef=response;
        console.log(response);
        this.len=response.length;
        if(this.len>0)
          this.dataFound=true;
        else
          this.dataFound=false;
      
      },

      error=>{
        this.errorStatus=true;
        this.errorService.errorStatusCheck(error.status);
      }
      );  
           
  }
  onCourseClick()
  {
    this.fileName="courseDetails";
    this.excelName='courseDetails.xlsx';
    console.log("in Course block");
    this.adminrepoService.getCourseDetails().subscribe(response =>
      {this.trainingsRef=response;
        console.log(response);
        this.len=response.length;
        if(this.len>0)
          this.dataFound=true;
        else
          this.dataFound=false;
      
      },
      error=>{
        this.errorStatus=true;
        this.errorService.errorStatusCheck(error.status);
      }
      );     
  }
  onCompletedCourseClick()
  {
    this.fileName="CompletedCourses";
    this.excelName='completedCourses.xlsx';
    this.courseStatus="completed";
    this.adminrepoService.getCourseDetailsByStatus(this.courseStatus).subscribe(response =>
      {this.trainingsRef=response;
        this.len=response.length;
        if(this.len>0)
          this.dataFound=true;
        else
          this.dataFound=false;
      
      },
      error=>{
        this.errorStatus=true;
        this.errorService.errorStatusCheck(error.status);
      }
      );       
  }
  onInProgressCourseClick()
  {
    this.fileName="InProgressCourses";
    this.excelName='InProgressCourses.xlsx';
    this.courseStatus="inProgress";
    this.adminrepoService.getCourseDetailsByStatus(this.courseStatus).subscribe(response => 
      {this.trainingsRef=response;
        this.len=response.length;
        if(this.len>0)
          this.dataFound=true;
        else
          this.dataFound=false;
      
      },
      error=>{
        this.errorStatus=true;
        this.errorService.errorStatusCheck(error.status);
      }
      );       
  }

  onYetToStartCourseClick()
  {
    this.fileName="YetToStartCourses";
    this.excelName='YetToStartcourses.xlsx';
    this.courseStatus="yetToStart";
    this.adminrepoService.getCourseDetailsByStatus(this.courseStatus).subscribe(response => 
      {this.trainingsRef=response;
        console.log(response);
        this.len=response.length;
        if(this.len>0)
          this.dataFound=true;
        else
          this.dataFound=false;
      
      },
      error=>{
        this.errorStatus=true;
        this.errorService.errorStatusCheck(error.status);
      }
      );       
  }



  onSelected(value: string){
    console.log("in onSelected function");
    console.log("selected values is "+value);
    this.downloadValue=value;
 
  
  }

  onDownload()
  {
    console.log("in onDownload function");
    if(this.downloadValue==="pdf")
    {
       this.downloadServiceRef.convertToPDF(this.fileName);
       //console.log(value);
    }
   else if(this.downloadValue==="excel")
   {
    this.downloadServiceRef.convertToExcel(this.excelName); 
   } 
   else
    alert("please select the download option");

  }

}
