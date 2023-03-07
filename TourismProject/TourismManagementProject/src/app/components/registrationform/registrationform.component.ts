import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { TourismService } from 'src/app/tourism.service';

@Component({
  selector: 'app-registrationform',
  templateUrl: './registrationform.component.html',
  styleUrls: ['./registrationform.component.css']
})
export class RegistrationformComponent implements OnInit{
  user : User = new User(0," "," "," "," "," "," "," "," ",0);
  isEditable: boolean;
  constructor(private userService:TourismService ,public router:Router, public activateRoute : ActivatedRoute) {

   }

  ngOnInit(): void {
 
    this.activateRoute.paramMap.subscribe(()=>this.getuserById());
  }
  getuserById(){
    const UserID  = parseFloat(this.activateRoute.snapshot.paramMap.get("user_id"));
    
  console.log(UserID);
  if(UserID> 0)
  {
    this.isEditable = true;
    this.userService.getuserbyid(UserID).subscribe(data=>{
      this.user = data;
      console.log(this.user)
    });
  }

  }
  Saveuser(){
    if(this.isEditable){
      this.userService.updateUser(this.user).subscribe(data=>{
        alert("Successfully updated "+this.user.name)
        sessionStorage.clear();
        localStorage.clear();
        this.router.navigateByUrl("/login")
      });
    
    }
    else{

      this.userService.saveUser(this.user).subscribe(data =>{
        alert("Successfully Register ")
        this.router.navigateByUrl("/login")
      },
      error => alert("enter the user data ")
        );
        
 
    }

  }
}
