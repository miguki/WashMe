import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpModule} from "@angular/http";
import {AllReservationsComponent} from "./all-reservations/all-reservations.component";
import { HoursListComponent } from './hours-list/hours-list.component';
import {routerModule} from "../approuting";
import {CarWashModule} from "../carwash/carwash.module";
import {UsersService} from "../users/users.service";
import {UsersModule} from "../users/users.module";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    routerModule,
    CarWashModule,
    UsersModule
  ],
  declarations: [AllReservationsComponent, HoursListComponent]
})
export class ReservationModule { }
