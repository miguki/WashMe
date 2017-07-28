import { Component, OnInit } from '@angular/core';
import {CarWashService} from "../carwash.service";

@Component({
  selector: 'app-all-car-washes',
  templateUrl: './all-car-washes.component.html',
  styleUrls: ['./all-car-washes.component.css']
})
export class AllCarWashesComponent implements OnInit {

  constructor(private carWashService: CarWashService) { }

  ngOnInit() {
    this.carWashService.getAllCarWashes().subscribe(carWashPage => this.carWashes = carWashPage.carWashes)  }

    carWashes = []

}
