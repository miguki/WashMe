import {LoginFormComponent} from "./security/login-form/login-form.component";
import {RouterModule} from "@angular/router";
import {SecurityGuard} from "./security/security.guard";
import {RegisterFormComponent} from "./security/register-form/register-form.component";

const routesConfig = [
  // {
  //   path: 'login', component: LoginFormComponent
  // },
  {
    path: '', redirectTo: '/', pathMatch: 'full'
  },
  {
    path: 'register', component: RegisterFormComponent
  },
  {
    path: '*', redirectTo: '/', canActivate: [SecurityGuard]
  }
]

export const routerModule = RouterModule.forRoot(routesConfig)
