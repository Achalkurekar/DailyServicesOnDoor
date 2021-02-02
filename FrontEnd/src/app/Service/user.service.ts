import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {user} from '../Models/user'
import {Feedback} from '../Models/Feedback'


@Injectable({
  providedIn: 'root'
})
export class UserService {
  UserSave="http://localhost:8080/users";
  ServiceProvider="http://localhost:8080/Service_provider"

  constructor(private Http:HttpClient) { }
  public saveUser(User):Observable<any>
  {
    return this.Http.post(this.UserSave,User);
  }
  public saveServiceProvider(SProvider):Observable<any>
  {
    return this.Http.post(this.ServiceProvider,SProvider);
  }
  public viewUser(id):Observable<any>
  {
    return this.Http.get("http://localhost:8080/users/getUser/"+id);
  }

  public getAllServiceById(id):Observable<any>
  {
    return this.Http.get("http://localhost:8080/getservices/"+id);
  }

  public findAllUser():Observable<any>
  {
    return this.Http.get("http://localhost:8080/users");
  }

  public fillFeedback(Feed:Feedback):Observable<any>
  {
   return this.Http.post("http://localhost:8080/users/FeedbackFilled",Feed)
  }

  public allServiceProvider():Observable<any>
  {
    return this.Http.get("http://localhost:8080/providers");
  }

  public getFeedback(id):Observable<any>
  {
    return this.Http.get("http://localhost:8080/feedback/"+id);
  }

  public updateUser(id:any , User):Observable<any>
  {
    return this.Http.put("http://localhost:8080/users/"+id ,User)
  }

}
