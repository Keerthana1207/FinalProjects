import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { User } from './common/user';

@Injectable({
  providedIn: 'root'
})
export class TourismService {

  private hotels="http://localhost:8080/api/hotel";

  private loginurl = "http://localhost:8080/api/admin/login";

  private newuserurl = "http://localhost:8080/api/admin/saveuser";

  private userUrl="http://localhost:8080/api/user";


  constructor(private httpClient: HttpClient) { }

  // Getting all tables

  
  getAllUsers() {
    return this.httpClient.get<GetUserResponse>(this.newuserurl).pipe(map(Response => Response._embedded.users));
  }

  getuserbyid(user_id: number):Observable<User>  {
    const uidUrl = this.userUrl + "/" + user_id;
    return this.httpClient.get<User>(uidUrl);
  }

  getlogin(user: User): Observable<User> {
    console.log(user);
    return this.httpClient.post<User>(`${this.loginurl}`, user);
  }

  GetUserbyname(name: string): Observable<Object> {
    const surl = "http://localhost:8080/api/user/search/findByname?name=" + JSON.parse(name)
    const searchURL = "http://localhost:8080/user/getid?name=" + name;
    return this.httpClient.get<GetUserResponse>(surl).pipe(map(Response => Response._embedded.users));
  }

  

  
  
  updateUser(user: User): Observable<User> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.httpClient.put<User>(this.userUrl + `/${user.user_id}`, user, httpOptions);
  }

  
  ///user Maintainance

  saveUser(user: User): Observable<User> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.httpClient.post<User>(this.newuserurl, user, httpOptions);
  }

  
}


interface GetUserResponse {
  _embedded:
  {
    users: User[]
  }
}

