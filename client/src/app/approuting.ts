import {RouterModule} from "@angular/router";
import {SecurityGuard} from "./security/security.guard";
import {RegisterFormComponent} from "./security/register-form/register-form.component";
import {AllClientsComponent} from "./users/clients/all-clients/all-clients.component";
import {AllReservationsComponent} from "./reservation/all-reservations/all-reservations.component";

const routesConfig = [

  {
    path: '', redirectTo: '/', pathMatch: 'full'
  },
  {
    path: 'register', component: RegisterFormComponent
  },
  {
    path: 'all-clients', component: AllClientsComponent
  },
  {
    path: 'all-reservations', component: AllReservationsComponent
  },
  // {
  //   path: '*', redirectTo: '/', canActivate: [SecurityGuard]
  // }
]

export const routerModule = RouterModule.forRoot(routesConfig)
