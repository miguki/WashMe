import {Injectable} from "@angular/core";
import {Http, RequestOptions} from "@angular/http";
import {Api} from "../api";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ServiceService {

  constructor(private http: Http, private api: Api) {
  }

  addServiceType(serviceType: any): Observable<any> {
    return this.http.post(this.api.serviceType, serviceType)
  }

  getAllServiceTypes(): Observable<any> {
    return this.http.get(this.api.serviceType).map(response => response.json())
  }

  editServiceType(serviceType: any): Observable<any> {
    return this.http.put(this.api.serviceType, serviceType)
  }

  deleteServiceType(serviceType: any): Observable<any> {
    console.log(serviceType)
    return this.http.delete(this.api.serviceType, new RequestOptions({
        body: serviceType
      })
    )
  }

  addServicePackage(servicePackage: any): Observable<any> {
    return this.http.post(this.api.servicePackage, servicePackage)
  }

  getAllServicePackages(): Observable<any> {
    return this.http.get(this.api.servicePackage).map(response => response.json())
  }

}
