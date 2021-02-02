import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'
import {ServiceService} from '../../Service/service.service'


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private Route:Router ,public service:ServiceService) { }

  Username:string;
  AdminName:string;
  SpName:string;
  
  user:boolean;
  admin:boolean;
  serviceProvier:boolean;

  ngOnInit(): void {
    

    if(localStorage.getItem("userId"))
    {
      this.user=true;
    }
    if(localStorage.getItem("loggedinAdmin"))
    {
      this.admin=true;
    }
    if(localStorage.getItem("Sp_id"))
    {
     this.serviceProvier=true;

    }
    this.Username=localStorage.getItem("UserName");
    this.AdminName=localStorage.getItem("AdminName");
    this.SpName=localStorage.getItem("SpFirstName");


  }



  logout()
  {
    Swal.fire({
      icon: 'success',
      title: 'Logged Out',
      text: 'Logged Out Successfully',
    })
    localStorage.clear();
    window.location.reload()

    this.Route.navigate([''])
  }

}
