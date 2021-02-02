import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { service_provider } from 'src/app/Models/service_provider';
import { WorkService } from 'src/app/Service/work.service';
import Swal from 'sweetalert2'
import {services} from '../../../Models/services'

@Component({
  selector: 'app-painter',
  templateUrl: './painter.component.html',
  styleUrls: ['./painter.component.css']
})
export class PainterComponent implements OnInit {

  constructor(private route:Router, private driver:WorkService) { }
  Drivers:any=[];
  Mydate=new Date();
  NewService=new services();
  admin:boolean=false

  ngOnInit(): void {
   
    if(localStorage.getItem("AdminName")==="Priyanshi")
    {
      this.admin=true;
    }
    else
    {
    }
    this.driver.getDriver(6).subscribe(data=>{
      this.Drivers=data;
      console.log(this.Drivers)
    },err=>{})

  }



  
  Book(id:number)
  {
    this.NewService.user_id=parseInt(localStorage.getItem("userId"));
    this.NewService.service_provider=id;
    console.log(this.NewService);
    this.driver.bookService(this.NewService).subscribe(data=>{
      Swal.fire({
        title: 'Booking Send To Service Provider',
        text: 'Booking Send To Service Provider let them Confirm ',
        icon: 'success',
        confirmButtonText: 'Ok',
      })
    },err=>{
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Something went wrong!',
      })
    })
 
  }

  view(id:number)
  {
    localStorage.setItem('viewid',JSON.stringify(id));
    this.route.navigate((['/service/view']))
  }


}
