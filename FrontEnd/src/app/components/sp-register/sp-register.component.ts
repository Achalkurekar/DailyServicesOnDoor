import { Component, OnInit } from '@angular/core';
import {servicepro} from '../../Models/servicepro'
import {Router,Route} from '@angular/router'
import { UserService } from 'src/app/Service/user.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-sp-register',
  templateUrl: './sp-register.component.html',
  styleUrls: ['./sp-register.component.css']
})
export class SpRegisterComponent implements OnInit {
  
  sproiders=new servicepro();
  constructor(private route:Router ,private userserv:UserService) { }

  ngOnInit(): void {
  }
  onSubmit()
  {
    this.userserv.saveServiceProvider(this.sproiders).subscribe(data=>
      {
        console.log(this.sproiders)
      Swal.fire({
        title: 'Saved?',
        text: 'You Registered Successfully',
        icon: 'success',
        confirmButtonText: 'Ok',
      })
      this.route.navigate(['/spLogin']);
      } ,err=>
      {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'EmailId Already Exist !',
       
        })      })
  }

}
