import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ServiceService} from "../service.service";
import {ServiceType} from "../service-type";
import {ServiceTypeAddFormComponent} from "../service-type-add-form/service-type-add-form.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-all-service-types',
  templateUrl: './all-service-types.component.html',
  styleUrls: ['./all-service-types.component.css']
})
export class AllServiceTypesComponent implements OnInit {

  constructor(private serviceService: ServiceService, private router: Router) {
    this.reload()
  }

  ngOnInit() {
  }

  reload() {
    this.serviceService.getAllServiceTypes()
      .subscribe(serviceTypesPage => this.serviceTypes = serviceTypesPage.serviceTypes)
  }

  serviceTypes = []
  selectedServiceTypesIds = []
  @Input()
  viewForAddingServicePackage = false
  @Output()
  emittedServiceTypeList = new EventEmitter<any>()
  @ViewChild(ServiceTypeAddFormComponent)
  private child: ServiceTypeAddFormComponent
  selectedServiceType = {}
  editSwitch = false
  modalHeader: string

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

  submitChild() {
    if (this.editSwitch) {
      this.child.editServiceType()
    } else {
      this.child.registerFormMethod()
    }
    this.reload()
  }

  deleteServiceType(serviceType) {
    this.serviceService.deleteServiceType(serviceType)
      .subscribe(() => {
        this.reload()
        console.log('success')
      }, () => {
        console.log('failed')
      })
  }

  selectServiceTypeToEdit(serviceType) {
    this.selectedServiceType = serviceType
    this.editSwitch = true
    this.modalHeader = "Edit Service Type"
  }

  clearSelectedServiceTypeToEdit() {
    this.selectedServiceType = {}
    this.editSwitch = false
    this.modalHeader = "Add Service Type"
  }
}
