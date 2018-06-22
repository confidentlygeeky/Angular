import { Injectable } from '@angular/core';
import {User, USERS} from './user'
import { Observable, of } from 'rxjs'; //for observale method 
import {HttpClient, HttpHeaders} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UserService {

                                //to display array through services method 

  // getUsers(): User[] {
  //   return USERS;
  // }

                                //observable method

  // getUsers():Observable<User[]> 
  // {
  //   return of (USERS);
  // }

                                //to get data from back end Http method 



  constructor(private http:HttpClient) { }
  private userUrl='http://localhost:8080/SpringRestMVC/';

  getUsers():Observable<User[]>{
    return this.http.get<User[]>(this.userUrl);
  }

  deleteUsers(user:User):Observable<User>{ // delete user method 
    const id=typeof user==="number"?user:user.userId; //downcast to check if user id is a number otherwise extract id 
    const deleteUrl=`${this.userUrl}${id}`;
    return this.http.delete<User>(deleteUrl);
  }

  updateUsers(user:User):Observable<User>{ // update user method 
   
    return this.http.put<User>(this.userUrl,user);
  }

  addUsers(user:User):Observable<User>{ // add user method 
   
    return this.http.post<User>(this.userUrl,user);
  }

  loginClicked(user:User):Observable<User>{ // login method 
    
    const url='http://localhost:8080/SpringRestMVC/user'
  
    return this.http.post<User>(url,user);
  }

}
