import {RouterModule} from "@angular/router";
import {SecurityGuard} from "./security/security.guard";
import {RegisterFormComponent} from "./security/register-form/register-form.component";
import {AllClientsComponent} from "./users/clients/all-clients/all-clients.component";
import {AllReservationsComponent} from "./reservation/all-reservations/all-reservations.component";
import {CarWashRegisterFormComponent} from "./carwash/car-wash-register-form/car-wash-register-form.component";
import {AllCarWashesComponent} from "./carwash/all-car-washes/all-car-washes.component";
import {IntroComponent} from "./navigation/intro/intro.component";
import {HoursListComponent} from "./reservation/hours-list/hours-list.component";

const routesConfig = [

  {
    path: '', component: IntroComponent //redirectTo: '/', pathMatch: 'full'
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
  {
    path: 'car-wash-register-form', component: CarWashRegisterFormComponent
  },
  {
    path: 'all-car-washes', component: AllCarWashesComponent,
    children: [
      {
        path: ':id', component: HoursListComponent,
        //tutaj można dodać resolver
      }
    ]
  }

  // {
  //   path: '*', redirectTo: '/', canActivate: [SecurityGuard]
  // }
]

export const routerModule = RouterModule.forRoot(routesConfig, {
  enableTracing: true
})
