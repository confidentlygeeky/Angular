import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import {UserService} from '../user.service'

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  user:any={
  };
  dbUser:User;

  onLoginClicked():void{
    
    this.userService.loginClicked(this.user).subscribe(dbUser=>this.dbUser=dbUser);

    if(this.dbUser.password==this.user.password)
    {
      alert("Welcome!"+ this.dbUser.username);
      window.location.href="http://localhost:4200/home";

    }

    else
    {
      alert("Invalid Login Credentials");
    }
  }
  constructor(private userService:UserService) { }
  ngOnInit() {
  }

}
