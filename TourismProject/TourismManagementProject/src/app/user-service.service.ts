import { Injectable } from '@angular/core';
import { User } from './common/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private userURl="http://localhost:8080/api/user";
  constructor(private httpclient:HttpClient) { }

  getAllUser():Observable<User[]>
  {
    return this.httpclient.get<getuserResponse>(this.userURl).pipe(map(response=>response. _embedded.users))
  }
  Saveuser(user:User):Observable<User>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.post<User>(this.userURl,user,httpOptions);
  }
  deleteuser(user_id: Number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpclient.delete<User>(this.userURl+`/${user_id}`,httpOptions);
  }
  getuserByID(userID:number):Observable<User>
{
  const userIDURl=this.userURl+"/"+userID;
  return  this.httpclient.get<User>(userIDURl);
}
updateuser(user:User):Observable<User>{
  const httpOptions = {
    headers : new HttpHeaders({
        'Content-Type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
    })
  };
  return  this.httpclient.put<User>(this.userURl+`/${user.user_id}`,user,httpOptions);
}
 
}
interface getuserResponse
{
  _embedded:
  {
    users :User[]
  }
}