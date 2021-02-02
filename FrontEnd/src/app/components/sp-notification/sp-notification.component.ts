import { Component, OnInit } from '@angular/core';
import {Router,Route} from '@angular/router'
import { service_provider } from 'src/app/Models/service_provider';
import { WorkService } from 'src/app/Service/work.service';
import {UserService} from '../../Service/user.service'
import Swal from 'sweetalert2'
@Component({
  selector: 'app-sp-notification',
  templateUrl: './sp-notification.component.html',
  styleUrls: ['./sp-notification.component.css']
})
export class SpNotificationComponent implements OnInit {

  constructor(private route:Router,private driver:WorkService ,private UserSer:UserService) { }
  ServiceData:any=[]
  ngOnInit(): void {

    this.driver.getNewOrder(localStorage.getItem("Sp_id")).subscribe(data=>{
      this.ServiceData=data;
      console.log(data);
    },err=>{})

  }
  view(user_id)
  {
    this.UserSer.viewUser(user_id).subscribe(data=>{
      Swal.fire({
        title: ''+data.firstName+' '+data.lastName+'',
        html: '<b>Mobile</b> :'+data.mobile+'<br><b>Email</b>:'+data.email+'<br><b>Address</b> :'+data.address ,
        imageUrl: 'https://daarts.org/wp-content/uploads/2019/02/individual.png',
        imageWidth: 250,
        imageHeight: 250,
        imageAlt: 'User Image',
      })

    },err=>{})

  }

  alow(id)
  {
    this.driver.allow(id).subscribe(data=>{
      Swal.fire({
        title: 'Accepted',
        text: 'You Accepted Booking Successfully ',
        icon: 'success',
        confirmButtonText: 'Done',
      })
    },err=>{})
    window. location. reload();

  }
  deny(id)
  {
    Swal.fire({
      title: 'Are you sure?',
      text: "You Want to Reject Service",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes,Reject it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.driver.deny(id).subscribe(data=>{
          Swal.fire(
            'Denied',
            'Service Rejected.',
            'success'
          ) 
          window. location. reload(); 
        },err=>{})
     
        
      }
    })



     }

}
