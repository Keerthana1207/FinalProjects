import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { TourismService } from 'src/app/tourism.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 
  user : User = new User(0," "," "," "," "," "," "," "," ",0);
  userdetails: any
  password: string
  name: string
  searchuser: string

  users: User = JSON.parse(sessionStorage.getItem("user"))
 

  constructor(private userservices:TourismService, private route: Router, public activateRoute: ActivatedRoute) { }

  ngOnInit(): void {

  }
  getlogin(): void {

    this.userservices.getlogin(this.user).subscribe(data => {
      alert("Login Successfully"),
        console.log("login response" + data)

      sessionStorage.setItem("user", JSON.stringify(data))

      this.route.navigateByUrl("/hoteldetails")

    },
      error => alert("Sorry Please Enter correct Username And Password"));

  }
  newregistration(){
    this.route.navigateByUrl("/registraionform")
  }


  // getDetailsByUsername(){
  //   this.uname = this.activateRoute.snapshot.paramMap.get("uname");
  //   console.log(this.uname)
  //   this.userdetails=this.userservices.getDetailsByUserName(this.uname).subscribe(data=>{
  //     console.log(data);
  //     this.users = data;
  //   })
  // }
  onSubmit() {
    this.route.navigateByUrl("/hoteldetails");

  }
}