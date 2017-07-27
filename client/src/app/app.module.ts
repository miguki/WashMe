import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { UsersModule } from './users/users.module';
import { SecurityService } from './security/security.service';
import { Api } from './api';
import {SecurityModule} from "./security/security.module";
import {routerModule} from "./approuting";
import {UsersService} from "./users/users.service";
import { NavbarComponent } from './navigation/navbar/navbar.component';
import {ReservationModule, } from "./reservation/reservation.module";
import {ReservationService} from "./reservation/reservation.service";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    UsersModule,
    SecurityModule,
    ReservationModule,
    routerModule
  ],
  providers: [
    SecurityService,
    Api,
    SecurityService,
    UsersService,
    ReservationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
