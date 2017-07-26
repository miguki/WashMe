import {LoginFormComponent} from "./security/login-form/login-form.component";
import {RouterModule} from "@angular/router";
import {SecurityGuard} from "./security/security.guard";

const routesConfig = [
  {
    path: 'login', component: LoginFormComponent
  },
  {
    path: '*', redirectTo: '/', canActivate: [SecurityGuard]
  }
]

export const routerModule = RouterModule.forRoot(routesConfig)
