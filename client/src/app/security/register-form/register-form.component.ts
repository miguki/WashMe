import {Component, Inject, OnInit} from '@angular/core';
import {UsersService} from "../../users/users.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  constructor(private userService: UsersService, private router: Router) { }

  ngOnInit() {
  }

  private registerResult: boolean

  private user = {
    clientDto: {
      name: ''
    },
    login: '',
    password: ''
  };

  registerFormMethod() {
    this.userService.registerNewClient(this.user)
      .subscribe(() => {
        console.log(this.user)
        this.router.navigateByUrl("")
      }, () => {
        console.log('failed')
        this.registerResult = false;
      })
  };

  }
