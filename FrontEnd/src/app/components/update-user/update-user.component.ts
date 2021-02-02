import { Component, OnInit } from '@angular/core';
import {user} from '../../Models/user'
import Swal from 'sweetalert2'
import { UserService } from 'src/app/Service/user.service';
import {Router,Route} from '@angular/router'




@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  User=new user();
  constructor(private route:Router ,private userserv:UserService) { }

  ngOnInit(): void {
    this.userserv.viewUser(localStorage.getItem("userId")).subscribe(res=>{
      this.User=res;
      console.log(this.User)
    },err=>{})
  }

  onSubmit()
  {
   
   this.userserv.updateUser(localStorage.getItem("userId") ,this.User).subscribe(data=>{

      Swal.fire({
        title: 'Saved?',
        text: 'You Updated Successfully',
        icon: 'success',
        confirmButtonText: 'Ok',
      })

      localStorage.setItem('UserName' ,this.User.firstName)

    this.route.navigate(['/userProfile'])
    },err=>{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error !',
        footer: '<a href>Why do I have this issue?</a>'
      })
    })

  }
 
  

}
