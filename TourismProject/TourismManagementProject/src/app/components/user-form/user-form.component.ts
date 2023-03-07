import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})

export class UserFormComponent  implements OnInit{
  user : User = new User(0," "," "," "," "," "," "," "," ",0);
  isEditable: boolean;
  constructor(private userService:UserServiceService ,public router:Router, public activateRoute : ActivatedRoute) {

   }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.user);
    this.activateRoute.paramMap.subscribe(()=>this.getuserById());
  }
  getuserById(){
    const UserID  = parseFloat(this.activateRoute.snapshot.paramMap.get("user_id"));
    
  console.log(UserID);
  if(UserID> 0)
  {
    this.isEditable = true;
    this.userService.getuserByID(UserID).subscribe(data=>{
      this.user = data;
      console.log(this.user)
    });
  }

  }
  onSubmit(){
    console.log(this.user);
    if(this.isEditable){
      this.userService.updateuser(this.user).subscribe(data=>
      
        this.router.navigateByUrl("/users"));
    }
    else{

    this.userService.Saveuser( this.user).subscribe(data =>
      console.log(data));
      this.router.navigateByUrl("/users");
  }

  }
}
