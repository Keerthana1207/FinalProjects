import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/common/user';

@Component({
  selector: 'app-booking-success',
  templateUrl: './booking-success.component.html',
  styleUrls: ['./booking-success.component.css']
})
export class BookingSuccessComponent implements OnInit {
  // hotels: import("C:\Users\jyoti\Documents\SpringBoot\TourismProject\TourismManagementProject\src\app\common\hotel").Hotel[];
   user:User
   constructor(public activateroute:ActivatedRoute) { }
 
   ngOnInit(): void { 
 
    this.activateroute.paramMap.subscribe(()=>this.user=JSON.parse(sessionStorage.getItem("user")))
   }
   
 }
 
 