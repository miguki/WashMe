import {Component, OnInit} from '@angular/core';
import {ReservationService} from "../reservation.service";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {UsersService} from "../../users/users.service";

@Component({
  selector: 'app-hours-list',
  templateUrl: './hours-list.component.html',
  styleUrls: ['./hours-list.component.css']
})
export class HoursListComponent {

  private id
  private activeUser

  constructor(private usersService: UsersService, private reservationService: ReservationService, private route: ActivatedRoute, private router: Router) {
    router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.id = this.route.snapshot.paramMap.get('id');
        this.activeUser = usersService.getActiveUser()
      }
    })
  }

  private reservation = {
    carWash: {
      id: -1
    },
    client: {
      id: -1
    },
    endHour: -1,
    startHour: -1
  }

  private startHoursList = [
    "2017-08-01T09:00:00.000Z",
    "2017-08-02T10:00:00.000Z",
    "2017-08-03T11:00:00.000Z",
    "2017-08-04T12:00:00.000Z",
    "2017-08-05T13:00:00.000Z"
  ]

  private endHoursList = [
    "2017-08-01T10:00:00.000Z",
    "2017-08-02T11:00:00.000Z",
    "2017-08-03T12:00:00.000Z",
    "2017-08-04T13:00:00.000Z",
    "2017-08-05T14:00:00.000Z"
  ]

  setStartHour(startHour) {
    this.reservation.startHour = startHour
    console.log(startHour)
  }

  setEndHour(endHour) {
    this.reservation.endHour = endHour
    console.log(endHour)
  }

  addReservation() {
    console.log(this.reservation)
    this.reservation.carWash.id = this.id
    this.reservation.client.id = this.activeUser.id
    this.reservationService.addReservation(this.reservation)
      .subscribe(() => {
        console.log(this.reservation)
        this.router.navigateByUrl("")
      }, () => {
        console.log('failed')
      })
  }

}
