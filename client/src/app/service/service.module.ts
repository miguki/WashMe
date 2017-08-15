import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceTypeAddFormComponent } from './service-type-add-form/service-type-add-form.component';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import { AllServiceTypesComponent } from './all-service-types/all-service-types.component';
import { ServicePackageAddFormComponent } from './service-package-add-form/service-package-add-form.component';
import { AllServicePackagesComponent } from './all-service-packages/all-service-packages.component';

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule
  ],
  declarations: [ServiceTypeAddFormComponent, AllServiceTypesComponent, ServicePackageAddFormComponent, AllServicePackagesComponent]
})
export class ServiceModule { }
