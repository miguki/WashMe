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
    endHour: "2017-07-28T09:26:48.566Z",
    startHour: "2017-07-28T09:26:48.566Z"
  }

  addReservation() {
    console.log(this.reservation)
    this.reservation.carWash.id=this.id
    this.reservation.client.id=this.activeUser.id
    this.reservationService.addReservation(this.reservation)
      .subscribe(() => {
        console.log(this.reservation)
        this.router.navigateByUrl("")
      }, () => {
        console.log('failed')
      })
  }

}
