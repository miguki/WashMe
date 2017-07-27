import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpModule} from "@angular/http";
import {AllReservationsComponent} from "./all-reservations/all-reservations.component";

@NgModule({
  imports: [
    CommonModule,
    HttpModule
  ],
  declarations: [AllReservationsComponent]
})
export class ReservationModule { }
