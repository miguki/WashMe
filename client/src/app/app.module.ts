import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {UsersModule} from './users/users.module';
import {SecurityService} from './security/security.service';
import {Api} from './api';
import {SecurityModule} from "./security/security.module";
import {routerModule} from "./approuting";
import {UsersService} from "./users/users.service";
import {NavbarComponent} from './navigation/navbar/navbar.component';
import {ReservationModule,} from "./reservation/reservation.module";
import {ReservationService} from "./reservation/reservation.service";
import {CarWashModule} from "./carwash/carwash.module";
import {CarWashService} from "./carwash/carwash.service";
import {IntroComponent} from './navigation/intro/intro.component';
import { MapComponent } from './map/map.component';
import {LeafletModule} from "@asymmetrik/angular2-leaflet";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    IntroComponent,
    MapComponent,
  ],
  imports: [
    BrowserModule,
    UsersModule,
    SecurityModule,
    ReservationModule,
    CarWashModule,
    routerModule,
    LeafletModule
  ],
  providers: [
    SecurityService,
    Api,
    SecurityService,
    UsersService,
    ReservationService,
    CarWashService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
