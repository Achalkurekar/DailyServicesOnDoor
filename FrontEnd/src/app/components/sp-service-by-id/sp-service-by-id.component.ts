import { Component, OnInit } from '@angular/core';
import {UserService} from '../../Service/user.service'
import Swal from 'sweetalert2'

@Component({
  selector: 'app-sp-service-by-id',
  templateUrl: './sp-service-by-id.component.html',
  styleUrls: ['./sp-service-by-id.component.css']
})
export class SpServiceByIdComponent implements OnInit {
  data:any=[]
  constructor(private user:UserService ) { }
   id;
  ngOnInit(): void {
    this.id= localStorage.getItem("Sp_id");
    this.user.getAllServiceById(this.id).subscribe(res=>{
    this.data=res;
    },err=>{})

  }

  viewUser(id)
  {
    this.user.viewUser(id).subscribe(data=>{
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

  viewFeedback(id)
  {
    this.user.getFeedback(id).subscribe(data=>{
    Swal.fire({
      title: ''+data.rating+'',
      html: '<b>Description</b> :'+data.description+'',
      imageUrl: 'https://cdn1.iconfinder.com/data/icons/social-media-blue-series/128/A-21-512.png',
      imageWidth: 250,
      imageHeight: 250,
      imageAlt: 'User Image',
    })
  },err=>{})


  }


}
