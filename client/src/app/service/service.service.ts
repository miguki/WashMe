import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Api} from "../api";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ServiceService {

  constructor(private http: Http, private api: Api ) {
  }

  addServiceType(serviceType: any):Observable<any>{
    return this.http.post(this.api.serviceType, serviceType)
  }

  getAllServiceTypes(): Observable<any> {
    return this.http.get(this.api.serviceType).map(response => response.json())
  }
}
