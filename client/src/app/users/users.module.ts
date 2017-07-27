import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpModule } from '@angular/http';
import { AllClientsComponent } from './clients/all-clients/all-clients.component';

@NgModule({
  imports: [
    CommonModule,
    HttpModule
  ],
  declarations: [AllClientsComponent]
})
export class UsersModule { }
