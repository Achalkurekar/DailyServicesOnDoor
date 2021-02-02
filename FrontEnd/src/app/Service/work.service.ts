import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {map} from 'rxjs/operators';
import { Observable } from 'rxjs';
import {services} from '../Models/services'

@Injectable({
  providedIn: 'root'
})
export class WorkService {



  constructor(private _http:HttpClient) { }
  public getDriver(id):Observable<any>
  {
    return this._http.get("http://localhost:8080/providers/"+id);
  }

  public getNewOrder(id):Observable<any>
  {
    return this._http.get("http://localhost:8080/Services/"+id);
  }
  

  public getWorkerDetail(id):Observable<any>
  {
    return this._http.get("http://localhost:8080/ProvidersById/"+id);
  }
  public bookService(Serve:services):Observable<any>
  {
    return this._http.post("http://localhost:8080/addService",Serve);
  }
  public allow(id):Observable<any>
  {
    return this._http.get("http://localhost:8080/service/allow/"+id);
  }
  public deny(id):Observable<any>
  {
    return this._http.get("http://localhost:8080/service/deny/"+id);
  }

  public findAllServices():Observable<any>
  {
    return this._http.get("http://localhost:8080/FindAllServices");
  }



}
