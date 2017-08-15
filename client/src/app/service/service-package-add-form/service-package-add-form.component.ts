import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ServiceService} from "../service.service";

@Component({
  selector: 'app-service-package-add-form',
  templateUrl: './service-package-add-form.component.html',
  styleUrls: ['./service-package-add-form.component.css']
})
export class ServicePackageAddFormComponent implements OnInit {

  constructor(private serviceService: ServiceService, private router: Router) { }

  ngOnInit() {
  }

  private registerResult: boolean

  private servicePackage = {
    name: '',
    price: '',
    serviceTypesIds: []
  }

  registerFormMethod() {
    this.serviceService.addServiceType(this.servicePackage)
      .subscribe(() => {
        console.log(this.servicePackage)
        this.router.navigateByUrl("")
      }, () => {
        console.log('failed')
        this.registerResult = false;
      })
  }
}