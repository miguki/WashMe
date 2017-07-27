import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllCarWashesComponent } from './all-car-washes/all-car-washes.component';
import {HttpModule} from "@angular/http";

@NgModule({
  imports: [
    CommonModule,
    HttpModule
  ],
  declarations: [AllCarWashesComponent]
})
export class CarwashModule { }
