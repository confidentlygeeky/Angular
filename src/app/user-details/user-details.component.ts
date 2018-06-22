import { Component, OnInit } from '@angular/core';
import {User, USERS} from '../user'
import {UserService} from '../user.service'

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  user:User={
    userId:null,
    username:'',
    password:'',
    phone_number:''
  }

  selectedUser:User;

  onEdit(us:User):void{
    this.selectedUser=us;
  }
  

  users:User[];
  constructor(private userService:UserService) { }

                                              //Servives method 

  // getUsers():void
  // {
  //   this.users=this.userService.getUsers();
  // }

                                              //observable method to get user list 
  getUsers():void
  {
    this.userService.getUsers().subscribe(users => this.users=users);
  }

  
  onDelete(userdetails:User):void{  //to delete a user
           this.userService.deleteUsers(userdetails).subscribe();
       window.location.href="http://localhost:4200/home";

  }

  onUpdate(userdetails:User):void{  //to update a user
  
       this.userService.updateUsers(userdetails).subscribe();
       window.location.href="http://localhost:4200/home";

  }
  
  onAdd(userdetails:User):void{  //to add a user
  
    this.userService.addUsers(userdetails).subscribe();
    window.location.href="http://localhost:4200/home";

}

electedUser:User;
onView(us:User):void{
  this.electedUser=us;
}

     ngOnInit() {
     this.getUsers();
   }

}
