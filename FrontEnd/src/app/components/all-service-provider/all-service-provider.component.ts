import { Component, OnInit } from '@angular/core';
import { user } from 'src/app/Models/user';
import {user_feedback} from '../../Models/user_feedback'
import {Feedback} from '../../Models/Feedback'
import {UserService} from '../../Service/user.service'
import Swal from 'sweetalert2'
import {Route,Router} from '@angular/router'

@Component({
  selector: 'app-all-service-provider',
  templateUrl: './all-service-provider.component.html',
  styleUrls: ['./all-service-provider.component.css']
})
export class AllServiceProviderComponent implements OnInit {

  AllSP:any=[]
  constructor(private Uservice:UserService ,private Route:Router) { }

  ngOnInit(): void {
    this.Uservice.allServiceProvider().subscribe(res=>{
      this.AllSP=res
    },err=>{})
  }

}
