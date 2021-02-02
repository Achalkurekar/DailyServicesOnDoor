import { Component, OnInit } from '@angular/core'; 
import { user } from 'src/app/Models/user';
import {user_feedback} from '../../Models/user_feedback'
import {Feedback} from '../../Models/Feedback'
import {UserService} from '../../Service/user.service'
import Swal from 'sweetalert2'
import {Route,Router} from '@angular/router'



@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  
  starRating:number;
  Feed:Feedback=new Feedback();
  constructor(private Uservice:UserService ,private Route:Router) { }

  ngOnInit(): void {
    this.Feed.serviceId=parseInt(localStorage.getItem('userid'));
  }
  onSubmit()
  {
   this.Uservice.fillFeedback(this.Feed).subscribe(data=>{
    Swal.fire({
      title: 'Saved',
      text: 'Thanks For Your Feedback',
      icon: 'success',
      confirmButtonText: 'Ok',
    })
    this.Route.navigate(['/view/service'])
   },err=>{})

  }

}
