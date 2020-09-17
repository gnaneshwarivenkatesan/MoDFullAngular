import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { AdminService } from 'src/app/admin.service';
import { User } from '../models/user';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  responseUsername="";
  responseEmail="";
  roles=['Learner','Mentor','Admin']
  user:User;
  registrationForm:FormGroup
  result="";
  alreadyExist:boolean=true
  


  constructor(private http:HttpClient,private service:AdminService) { }

  ngOnInit(): void {
    this.registrationForm=new FormGroup({
      'role':new FormControl('Learner'),
      'userfullname':new FormControl(null,Validators.required),
      'email':new FormControl(null,[Validators.required,Validators.email]),
      'username':new FormControl(null,Validators.required)
    },Validators.required);
   
  }
  onSubmit()
  {
   console.log(this.registrationForm)
  }
 
  onCreateUser(userData:User)
  {
  // userData.status="active";
    this.service.onCreateUser(userData.role,userData.userfullname,userData.email,userData.username).subscribe(
      responseData=>
      {
        this.responseUsername=responseData.username
        this.responseEmail=responseData.email;
        if(this.responseUsername===null && this.responseEmail===null)
        {
          this.result="Looks like username or email is already exist.Please Enter a unique username or email"
          this.registrationForm.reset();
          console.log(this.result)
        }
        else
        {
          this.result="Registered Successfully."
          this.alreadyExist=false
          console.log(this.result)
          this.registrationForm.reset()
        }
      }
    )

  }



}
