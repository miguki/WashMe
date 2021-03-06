import {RouterModule} from "@angular/router";
import {SecurityGuard} from "./security/security.guard";
import {RegisterFormComponent} from "./security/register-form/register-form.component";
import {AllClientsComponent} from "./users/clients/all-clients/all-clients.component";
import {AllReservationsComponent} from "./reservation/all-reservations/all-reservations.component";
import {CarWashRegisterFormComponent} from "./carwash/car-wash-register-form/car-wash-register-form.component";
import {AllCarWashesComponent} from "./carwash/all-car-washes/all-car-washes.component";
import {IntroComponent} from "./navigation/intro/intro.component";
import {HoursListComponent} from "./reservation/hours-list/hours-list.component";
import {MapComponent} from "./map/map.component";
import {AuthorizationRequiredComponent} from "./security/authorization-required/authorization-required.component";
import {PageNotFoundComponent} from "./security/page-not-found/page-not-found.component";
import {ServiceTypeAddFormComponent} from "./service/service-type-add-form/service-type-add-form.component";
import {AllServiceTypesComponent} from "./service/all-service-types/all-service-types.component";
import {ServicePackageAddFormComponent} from "./service/service-package-add-form/service-package-add-form.component";
import {AllServicePackagesComponent} from "./service/all-service-packages/all-service-packages.component";
import {JobAddFormComponent} from "./job/job-add-form/job-add-form.component";
import {AllJobsComponent} from "./job/all-jobs/all-jobs.component";

const routesConfig = [

  {
    path: '', component: IntroComponent //redirectTo: '/', pathMatch: 'full'
  },
  {
    path: 'register', component: RegisterFormComponent
  },
  {
    path: 'add-service-type', component: ServiceTypeAddFormComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'all-service-types', component: AllServiceTypesComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'add-service-package', component: ServicePackageAddFormComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'all-service-packages', component: AllServicePackagesComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'add-job-form', component: JobAddFormComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'all-jobs', component: AllJobsComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'all-clients', component: AllClientsComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'all-reservations', component: AllReservationsComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'car-wash-register-form', component: CarWashRegisterFormComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'map', component: MapComponent, canActivate: [SecurityGuard]
  },
  {
    path: 'authorization-required', component: AuthorizationRequiredComponent,
  },
  {
    path: 'all-car-washes', component: AllCarWashesComponent, canActivate: [SecurityGuard],
    children: [
      {
        path: ':id', component: HoursListComponent, canActivate: [SecurityGuard]
        //tutaj można dodać resolver
      }
    ]
  },
  {
    path: 'page-not-found', component: PageNotFoundComponent
  },
  {
    path: '**', redirectTo: 'page-not-found'//, canActivate: [SecurityGuard]
  }

]

export const routerModule = RouterModule.forRoot(routesConfig, {
  enableTracing: true
})
