import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Hotel } from './common/hotel';


@Injectable({
  providedIn: 'root'
})
export class HotelServiceService {
  getbookingByID(bookID: number) {
    throw new Error('Method not implemented.');
  }

  private hotelURl="http://localhost:8080/api/hotel";
  constructor(private httpclient:HttpClient) { }

  getAllhotel():Observable<Hotel[]>
  {
    return this.httpclient.get<gethotelResponse>(this.hotelURl).pipe(map(response=>response. _embedded.hotels))
  }
  Savehotel(hotel:Hotel):Observable<Hotel>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.post<Hotel>(this.hotelURl,hotel,httpOptions);
  }
  deletehotel(hotel_id: Number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.delete<Hotel>(this.hotelURl+`/${hotel_id}`,httpOptions);
  }
  gethotelByID(hotelID:number):Observable<Hotel>
{
  const hotelIDURl=this.hotelURl+"/"+hotelID;
  return  this.httpclient.get<Hotel>(hotelIDURl);
}
updatehotel(hotel:Hotel):Observable<Hotel>{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.put<Hotel>(this.hotelURl+`/${hotel.hotel_id}`,hotel,httpOptions);
}
 
}
interface gethotelResponse
{
  _embedded:
  {
    hotels :Hotel[]
  }
}