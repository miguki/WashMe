import {Component, OnInit} from '@angular/core';
import {ServiceService} from "../service.service";

@Component({
  selector: 'app-all-service-types',
  templateUrl: './all-service-types.component.html',
  styleUrls: ['./all-service-types.component.css']
})
export class AllServiceTypesComponent implements OnInit {

  constructor(private serviceService: ServiceService) {
  }

  ngOnInit() {
    this.serviceService.getAllServiceTypes().subscribe(serviceTypesPage => this.serviceTypes = serviceTypesPage.serviceTypes)
  }

  serviceTypes = []
  selectedServiceTypes = []

  toggleSelectionOnList(id) {
    if(this.selectedServiceTypes.includes(id)){
      this.selectedServiceTypes = this.selectedServiceTypes.filter(ids => ids !== id)
    } else {
      this.selectedServiceTypes.push(id)
    }
    console.log(this.selectedServiceTypes)
  }

}
