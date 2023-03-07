import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from 'src/app/common/hotel';
import { HotelServiceService } from 'src/app/hotel-service.service';

@Component({
  selector: 'app-hotel-form',
  templateUrl: './hotel-form.component.html',
  styleUrls: ['./hotel-form.component.css']
})
export class HoteFormComponent 
  {
    hotel : Hotel = new Hotel(0, " "," ", ""," ",0," "," " );
    isEditable: boolean;
    constructor(private hotelService:HotelServiceService,private router:Router,private activateRoute:ActivatedRoute) { }
  
    ngOnInit(): void 
    {
      this.activateRoute.paramMap.subscribe(()=>this.hotel);
      this.activateRoute.paramMap.subscribe(()=>this.gethotelById());
  
    }
    gethotelById(){
      const hotelID  = parseFloat(this.activateRoute.snapshot.paramMap.get("hotel_id"));
      
      
    console.log(hotelID);
    if(hotelID> 0)
    {
      this.isEditable = true;
      this.hotelService.gethotelByID(hotelID).subscribe(data=>{
        this.hotel = data;
        console.log(this.hotel)
      });
    }
  
    }
    onSubmit(){
      console.log(this.hotel);
      if(this.isEditable){
        this.hotelService.updatehotel(this.hotel).subscribe(data=>
          this.router.navigateByUrl("/hotels"));
  
      }
      else{
      this.hotelService.Savehotel( this.hotel).subscribe(data =>
        console.log(data));
        this.router.navigateByUrl("/hotels");
    }
  }}
  