import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingserviceService } from 'src/app/bookingservice.service';
import { Booking } from 'src/app/common/booking';
import { Hotel } from 'src/app/common/hotel';
import { HotelServiceService } from 'src/app/hotel-service.service';

@Component({
  selector: 'app-hotelbook',
  templateUrl: './hotelbook.component.html',
  styleUrls: ['./hotelbook.component.css']
})
export class HotelbookComponent {


booking : Booking = new Booking(0, new Date(), 0 ," ",0);
  isEditable: boolean;
  constructor(private bookingService:BookingserviceService,private router:Router,private activateRoute:ActivatedRoute) { }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.booking);
    this.activateRoute.paramMap.subscribe(()=>this.getbookingByID());

  }
  getbookingByID(){
    const bookID  = parseFloat(this.activateRoute.snapshot.paramMap.get("booking_id"));
    
    
  console.log(bookID);
  if(bookID > 0)

    this.isEditable = true;
    this.bookingService.getbookingByID(bookID).subscribe(data=>{
      this.booking = data;
      console.log(this.booking)
    });
  }

  
  onSubmit(){
    console.log(this.booking);
    if(this.isEditable){
      this.bookingService.updatebooking(this.booking).subscribe(data=>
        this.router.navigateByUrl("/booking-success"));


    }
    else{
    this.bookingService. Savebooking( this.booking).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/booking-success");
  }
}}

