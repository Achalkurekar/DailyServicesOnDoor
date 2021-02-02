import { Component, OnInit } from '@angular/core';
import {user} from '../../Models/user'
import {Router,Route} from '@angular/router'
import { UserService } from 'src/app/Service/user.service';
import Swal from 'sweetalert2'



@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  User=new user();
  constructor(private route:Router ,private userserv:UserService) { }

  ngOnInit(): void {
  }
  onSubmit()
  {
    console.log(this.User);
    this.userserv.saveUser(this.User).subscribe(data=>{

      Swal.fire({
        title: 'Saved?',
        text: 'You Registered Successfully',
        icon: 'success',
        confirmButtonText: 'Ok',
      })

    this.route.navigate(['/login'])
    },err=>{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'EmailId Already Exist !',
        footer: '<a href>Why do I have this issue?</a>'
      })
    })

  }

}
