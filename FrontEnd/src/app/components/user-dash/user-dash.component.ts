import { Component, OnInit } from '@angular/core';
import {UserService} from '../../Service/user.service'


@Component({
  selector: 'app-user-dash',
  templateUrl: './user-dash.component.html',
  styleUrls: ['./user-dash.component.css']
})
export class UserDashComponent implements OnInit {

  id:number;
  User:any;
  
  constructor(private UserSer:UserService) 
  {

   }

  ngOnInit(): void {
     this.id=parseInt(localStorage.getItem("userId"))
    this.UserSer.viewUser(this.id).subscribe(res=>{
     this.User =res;
    },err=>{})
  }

}
