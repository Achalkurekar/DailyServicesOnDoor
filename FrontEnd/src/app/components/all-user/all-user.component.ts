import { Component, OnInit } from '@angular/core';
import { user } from 'src/app/Models/user';
import {user_feedback} from '../../Models/user_feedback'
import {Feedback} from '../../Models/Feedback'
import {UserService} from '../../Service/user.service'
import Swal from 'sweetalert2'
import {Route,Router} from '@angular/router'


@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.css']
})
export class AllUserComponent implements OnInit {
 
  constructor(private Uservice:UserService ,private Route:Router) { }

  AllUser:any=[]

  ngOnInit(): void {
    this.Uservice.findAllUser().subscribe(data=>{
      this.AllUser=data;
    },err=>{
      alert("Error Ocured");
    })
  }
 
}
