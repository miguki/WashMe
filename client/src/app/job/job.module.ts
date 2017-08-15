import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import { AllJobsComponent } from './all-jobs/all-jobs.component';
import { JobAddFormComponent } from './job-add-form/job-add-form.component';

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule
  ],
  declarations: [AllJobsComponent, JobAddFormComponent]
})
export class JobModule { }
