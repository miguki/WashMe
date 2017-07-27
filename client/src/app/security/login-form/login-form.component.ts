import {Component, OnInit} from '@angular/core';
import {SecurityService} from "../security.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  username: string
  password: string
  loginResult: boolean
  pendingRequest = false

  constructor(private securityService: SecurityService, private router: Router) {
  }

  ngOnInit() {
  }

  login() {
    this.securityService.login(this.username, this.password)
      .subscribe(() => {
        console.log(this.securityService.isAuthenticated())
        this.loginResult = true
        this.router.navigateByUrl("/")
      }, () => {
        this.loginResult = false
        this.pendingRequest = false
      })
    console.log(this.loginResult)
  }

}
