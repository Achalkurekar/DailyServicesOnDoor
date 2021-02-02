import { Component, OnInit } from '@angular/core';
import {WorkService} from '../../Service/work.service'
import {Route,Router} from '@angular/router'
import {UserService} from '../../Service/user.service'
import Swal from 'sweetalert2'


@Component({
  selector: 'app-all-services',
  templateUrl: './all-services.component.html',
  styleUrls: ['./all-services.component.css']
})
export class AllServicesComponent implements OnInit {

  AllServices:any=[]
  constructor(private work:WorkService ,private router:Router ,private route:Router ,private UserSer:UserService ) { }

  ngOnInit(): void {
    this.work.findAllServices().subscribe(res=>{
      this.AllServices=res;
    },err=>{})
  }

  viewUser(id)
  {
    this.UserSer.viewUser(id).subscribe(data=>{
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
  viewSp(id)
  {
    localStorage.setItem("viewid", JSON.stringify(id));
    this.router.navigate(['/service/view'])
  }

  viewFeedback(id)
  {
    this.UserSer.getFeedback(id).subscribe(data=>{
    Swal.fire({
      title: ''+data.rating+'',
      html: '<b>Description</b> :'+data.description+'',
      imageUrl: 'https://assets.materialup.com/uploads/2356cb6c-3afa-4f94-ad66-6e6457f9f12d/feedback-icon.png',
      imageWidth: 250,
      imageHeight: 250,
      imageAlt: 'User Image',
    })
  },err=>{})


  }

}
