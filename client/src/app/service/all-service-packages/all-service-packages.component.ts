import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ServiceService} from "../service.service";

@Component({
  selector: 'app-all-service-packages',
  templateUrl: './all-service-packages.component.html',
  styleUrls: ['./all-service-packages.component.css']
})
export class AllServicePackagesComponent implements OnInit {

  constructor(private serviceService: ServiceService, private router: Router) {
    this.serviceService.getAllServicePackages()
      .subscribe(servicePackagesPage => this.servicePackages = servicePackagesPage.servicePackages)
  }

  ngOnInit() {
  }

  servicePackages = []

}
