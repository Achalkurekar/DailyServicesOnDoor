import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  url="http://localhost:8080"
  constructor(private http:HttpClient) { }

  dologin(creadentials:any):Observable<any>
  {
    return this.http.post('http://localhost:8080/users/login',creadentials)
  }

  
  doSplogin(creadentials:any):Observable<any>
  {
    return this.http.post('http://localhost:8080/login/ServiceProvider',creadentials)
  }

  loginUser(token)
  {
    localStorage.setItem("token",token)
  }
  AdminisLoggedIn()
  {
    let tokad=localStorage.getItem("AdminName")
    if(tokad==undefined || tokad==''|| tokad==null)
    {
      return false
    }
    else
    {
      return true
    }
  }

  UserisLoggedIn()
  {
    let tokus=localStorage.getItem("userId")
    if(tokus==undefined || tokus==''|| tokus==null)
    {
      return false
    }
    else
    {
      return true
    }
  }
  getUserName()
  {
    let tokus=localStorage.getItem("UserName")
    if(tokus==undefined || tokus==''|| tokus==null)
    {
      return tokus;
    }
    else
    {
      return tokus;
    }
  }
  getSpName()
  {
    
    let tokus=localStorage.getItem("SpFirstName")
    if(tokus==undefined || tokus==''|| tokus==null)
    {
      return tokus;
    }
    else
    {
      return tokus;
    }

  }

  SpisLoggedIn()
  {
    let toksp=localStorage.getItem("loggedinSp")
    if(toksp==undefined || toksp==''|| toksp==null)
    {
      return false
    }
    else
    {
      return true
    }
  }
  


  Logout()
  {
    localStorage.removeItem("token")
    return true;
  }
}
