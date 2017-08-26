import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ServiceService} from "../service.service";
import {ServiceType} from "../service-type";

@Component({
  selector: 'app-all-service-types',
  templateUrl: './all-service-types.component.html',
  styleUrls: ['./all-service-types.component.css']
})
export class AllServiceTypesComponent implements OnInit {

  constructor(private serviceService: ServiceService) {
    this.serviceService.getAllServiceTypes().subscribe(serviceTypesPage => this.serviceTypes = serviceTypesPage.serviceTypes)
  }

  ngOnInit() {
  }

  serviceTypes = []
  selectedServiceTypesIds = []

  @Output() emittedServiceTypeList = new EventEmitter<any>()

  toggleSelectionOnList(serviceTypeId) {
    if (this.selectedServiceTypesIds.includes(serviceTypeId)) {
      this.selectedServiceTypesIds = this.selectedServiceTypesIds.filter(ids => ids !== serviceTypeId)
    } else {
      this.selectedServiceTypesIds.push(serviceTypeId)
    }
    console.log("this.selectedServiceTypesIds")
    console.log(this.selectedServiceTypesIds)
    this.emittedServiceTypeList.emit(this.selectedServiceTypesIds)
  }

  check() {
    console.log(this.serviceTypes)
  }

}
