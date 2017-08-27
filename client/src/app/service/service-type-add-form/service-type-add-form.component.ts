import {Component, Input, OnInit} from '@angular/core';
import {ServiceService} from "../service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-service-type-add-form',
  templateUrl: './service-type-add-form.component.html',
  styleUrls: ['./service-type-add-form.component.css']
})
export class ServiceTypeAddFormComponent implements OnInit {

  constructor(private serviceService: ServiceService, private router: Router) { }

  ngOnInit() {
  }

  private registerResult: boolean

  private serviceType = {
    duration: '',
    name: '',
    price: ''
  }

  registerFormMethod() {
    this.serviceService.addServiceType(this.serviceType)
      .subscribe(() => {
        console.log(this.serviceType)
        this.router.navigateByUrl("")
      }, () => {
        console.log('failed')
        this.registerResult = false;
      })
  }

}
