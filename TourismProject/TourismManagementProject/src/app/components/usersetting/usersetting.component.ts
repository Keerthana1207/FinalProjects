import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { TourismService } from 'src/app/tourism.service';

@Component({
  selector: 'app-usersetting',
  templateUrl: './usersetting.component.html',
  styleUrls: ['./usersetting.component.css']
})
export class UsersettingComponent implements OnInit {

    activateRoute: ActivatedRoute;
    userarr : User=JSON.parse(sessionStorage.getItem("user"))
    user_id:number
    user:User
    constructor(public userservices:TourismService,public route:Router) { }
  
    ngOnInit(): void {
    }
    updateuser()
    {
      this.user_id=this.userarr.user_id
      this.route.navigateByUrl("/updateUser/" + this.user_id)
    }
    gotocart()
    {
      this.user_id=this.userarr.user_id
      this.route.navigateByUrl("/cart")
    }
  }