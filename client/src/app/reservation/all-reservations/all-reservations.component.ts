import { Component, OnInit } from '@angular/core';
import {ReservationService} from "../reservation.service";

@Component({
  selector: 'app-all-reservations',
  templateUrl: './all-reservations.component.html',
  styleUrls: ['./all-reservations.component.css']
})
export class AllReservationsComponent implements OnInit {

  constructor(private reservationService: ReservationService) { }

  ngOnInit() {
    this.reservationService.getAllReservations().subscribe(reservationsPage => this.reservations = reservationsPage.reservations)
  }

  reservations = []

}
