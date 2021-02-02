import { Component, OnInit } from '@angular/core';
import Typewriter from 't-writer.js'


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    const target = document.querySelector('.tw')
    const writer = new Typewriter(target, {
      loop: true, 
      typeColor: 'black' ,
      typeSpeedMin :65   })
    
    writer
      .strings(
        400,
        "Daily Services on Door",
        "Do you want someone for Household Jobs??? ",
        "You are away from just one click ", 
        "Painters ",
        "Plumbers ",
        "Electricians ",
        "Gardeners ",
        "Drivers ",
        "Maids "

      )
      .start()
          
  }

}
