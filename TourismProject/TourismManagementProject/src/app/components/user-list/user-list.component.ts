import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit  {
  users:User[];
  constructor(private userService:UserServiceService,public router:Router,private activateRoute:ActivatedRoute) 
  {

   }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.getAllUsers());
  }
 
getAllUsers(): void
{
  this.userService.getAllUser().subscribe(data=>{
    console.log(data);
    this.users=data;
  });

}
addUser():void
{
  this.router.navigateByUrl("/userform")
}
updateuser(user_id:number)
{
  this.router.navigateByUrl("/updateuser/"+user_id);
}
deleteuser(user_id : Number){
  console.log(user_id);
  if(confirm("Do you want to delete ?")){
    this.userService.deleteuser(user_id).subscribe(data=>{
      console.log(data);
      this.getAllUsers();
    })
  };
}

}

