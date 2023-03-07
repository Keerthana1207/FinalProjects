import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Booking } from './common/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingserviceService {

  private bookingURl="http://localhost:8080/api/hotel";
  constructor(private httpclient:HttpClient) { }

  getAllbooking():Observable<Booking[]>
  {
    return this.httpclient.get<gethotelResponse>(this.bookingURl).pipe(map(response=>response. _embedded.bookings))
  }
  Savebooking(booking:Booking):Observable<Booking>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.post<Booking>(this.bookingURl,booking,httpOptions);
  }
  deletebooking(booking_id: Number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.delete<Booking>(this.bookingURl+`/${booking_id}`,httpOptions);
  }
  getbookingByID(bookID:number):Observable<Booking>
{
  const bookIDURl=this.bookingURl+"/"+bookID;
  return  this.httpclient.get<Booking>(bookIDURl);
}
updatebooking(booking:Booking):Observable<Booking>{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.put<Booking>(this.bookingURl+`/${booking.booking_id}`,booking,httpOptions);
}
 
}
interface gethotelResponse
{
  _embedded:
  {
    bookings :Booking[]
  }
}