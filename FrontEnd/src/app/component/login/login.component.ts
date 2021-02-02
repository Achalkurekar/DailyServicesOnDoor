import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../../Service/service.service'
import {Route ,Router} from '@angular/router'
import { FormGroup } from '@angular/forms';
import {UserLogin} from '../../Models/UserLogin'
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials:UserLogin=new UserLogin()

  constructor(private router:Router ,private loginservice:ServiceService) { }

  ngOnInit(): void {
  }
  onSubmit()
  { 
  if(this.credentials.username!=null && this.credentials.password!=null)
  {
    this.loginservice.dologin(this.credentials).subscribe(Response=>{
      if(Response===null){
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'User Does Not Exist!',
        })
      }
      else{
        localStorage.setItem('loggedinUser' ,Response.userId)
        localStorage.setItem("userId" ,Response.userId)
        localStorage.setItem('UserName' ,Response.firstName)
        this.router.navigate(['/service'])
      }
     
    },err=>{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Something went wrong',
      })
    })
  }
  else
  {
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Field Are Compulsory',
    })
  }
  }
  reset(form:FormGroup)
  {
    form.reset();
  }

}
