import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginFormComponent} from './login-form/login-form.component';
import {FormsModule} from "@angular/forms";
import { RegisterFormComponent } from './register-form/register-form.component';
import { AuthorizationRequiredComponent } from './authorization-required/authorization-required.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [LoginFormComponent],
  declarations: [LoginFormComponent, RegisterFormComponent, AuthorizationRequiredComponent, PageNotFoundComponent],

})
export class SecurityModule {
}
