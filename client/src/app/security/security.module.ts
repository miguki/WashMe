import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginFormComponent} from './login-form/login-form.component';
import {FormsModule} from "@angular/forms";
import { RegisterFormComponent } from './register-form/register-form.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [LoginFormComponent],
  declarations: [LoginFormComponent, RegisterFormComponent],

})
export class SecurityModule {
}
