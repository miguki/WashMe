import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Api } from '../api';
import 'rxjs/add/operator/map';

@Injectable()
export class ReservationService {

  constructor(private http: Http, private api: Api ) {
  }

  getAllReservations(): Observable<any> {
    return this.http.get(this.api.reservation).map(response => response.json())
  }

}
