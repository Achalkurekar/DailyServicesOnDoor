import { Component, OnInit } from '@angular/core';
import {Router,Route} from '@angular/router'
import { service_provider } from 'src/app/Models/service_provider';
import { UserService } from 'src/app/Service/user.service';
import { WorkService } from 'src/app/Service/work.service';


@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  constructor(private route:Router,private workerDetails:WorkService ,UserService:UserService) { }
   worker:any=[];
   id:number;
  ngOnInit(): void {
   this.id=parseInt(localStorage.getItem("viewid"));
   console.log("Hello")
   console.log(this.id)
  this.workerDetails.getWorkerDetail(this.id).subscribe(data=>{
    this.worker=data;
    console.log(data);
  },err=>{})
  }

}
