import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../../Service/service.service'
import {Route ,Router} from '@angular/router'
import { FormGroup } from '@angular/forms';
import {UserLogin} from '../../Models/UserLogin'
import Swal from 'sweetalert2'

@Component({
  selector: 'app-splogin',
  templateUrl: './splogin.component.html',
  styleUrls: ['./splogin.component.css']
})
export class SploginComponent implements OnInit {

  credentials:UserLogin=new UserLogin()

  constructor(private router:Router ,private loginservice:ServiceService) { }

  ngOnInit(): void {
  }


  onSubmit()
  {
    this.loginservice.doSplogin(this.credentials).subscribe(Response=>{
      if(Response===null){
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'User Does Not Exist!',
        })
      }
      else{
      console.log(Response);
      localStorage.setItem("loggedinSp" ,Response.serviceProviderId)
      localStorage.setItem("viewid",Response.serviceProviderId);
      localStorage.setItem("Sp_id" ,Response.serviceProviderId)
      localStorage.setItem("SpFirstName", Response.firstName)
      this.router.navigate(['/service/view'])
    }
    },err=>{
      alert("Hello")
    })
  }

  
  reset(form:FormGroup)
  {
    form.reset();
  }

}
