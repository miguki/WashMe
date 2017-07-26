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

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    UsersModule,
    SecurityModule,
    routerModule
  ],
  providers: [
    SecurityService,
    Api,
    SecurityService,
    UsersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
