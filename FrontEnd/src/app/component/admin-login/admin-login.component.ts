import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../../Service/service.service'
import {Route ,Router} from '@angular/router'
import { FormGroup } from '@angular/forms';
import {UserLogin} from '../../Models/UserLogin'
import Swal from 'sweetalert2'

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  credentials:UserLogin=new UserLogin()

  constructor(private router:Router ,private loginservice:ServiceService) { }

  ngOnInit(): void {
  }

  onSubmit()
  { 
  if(this.credentials.username=='priyanshi' && this.credentials.password=='sohani')
  {
      localStorage.setItem("loggedinAdmin" ,"admin420")
      localStorage.setItem("AdminName" ,"Priyanshi")
      localStorage.setItem("adminid","420");
      this.router.navigate(['/service'])

  }
  else
  {
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'User Does Not Exist!',
    }) 
  }
  }
  reset(form:FormGroup)
  {
    form.reset();
  }

}
