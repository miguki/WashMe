import {Component, OnInit} from '@angular/core';
import {CarWashService} from "../carwash.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-car-wash-register-form',
  templateUrl: './car-wash-register-form.component.html',
  styleUrls: ['./car-wash-register-form.component.css']
})
export class CarWashRegisterFormComponent implements OnInit {

  constructor(private carWashService: CarWashService, private router: Router) {
  }

  ngOnInit() {
  }

  private registerResult: boolean

  private carWash = {
    name: '',
    slots: ''
  }

  registerFormMethod() {
    this.carWashService.registerNewCarWash(this.carWash)
      .subscribe(() => {
        console.log(this.carWash)
        this.router.navigateByUrl("")
      }, () => {
        console.log('failed')
        this.registerResult = false;
      })
  }

}
