import { Component, OnInit } from '@angular/core';
import {Router,Route} from '@angular/router'
import { service_provider } from 'src/app/Models/service_provider';
import { UserService } from 'src/app/Service/user.service';
import{user_feedback} from '../../Models/user_feedback'
import Swal from 'sweetalert2';


@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit {

  Services:any=[];
  constructor(private route:Router,private UserServices:UserService) { }
  userFeedback:user_feedback=new user_feedback();
  ngOnInit(): void {
      this.UserServices.getAllServiceById(localStorage.getItem("userId")
      ).subscribe(data=>{
        this.Services=data;
        console.log(data)
      },err=>{})
  }

  view(id)
  {
    localStorage.setItem('viewid',JSON.stringify(id));
    this.route.navigate((['/service/view']))
  }

  fillFeedback(id)
  {
   localStorage.setItem('userid',JSON.stringify(id));
   this.route.navigate((['/service/feedback']))
  }

}
