import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllCarWashesComponent } from './all-car-washes/all-car-washes.component';
import {HttpModule} from "@angular/http";
import { CarWashRegisterFormComponent } from './car-wash-register-form/car-wash-register-form.component';
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule
  ],
  declarations: [AllCarWashesComponent, CarWashRegisterFormComponent],
  exports: [
    AllCarWashesComponent
  ]
})
export class CarWashModule { }
