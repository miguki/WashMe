import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Api} from "../api";
import {Observable} from "rxjs/Observable";

@Injectable()
export class CarWashService {

  constructor(private http: Http, private api: Api ) {
  }

  registerNewCarWash(carWash: any):Observable<any>{
    return this.http.post(this.api.carWash, carWash)
  }

  getAllCarWashes(): Observable<any> {
    return this.http.get(this.api.carWash).map(response => response.json())
  }
}
