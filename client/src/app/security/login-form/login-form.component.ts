import {Component, OnInit} from '@angular/core';
import {SecurityService} from "../security.service";
import {Router} from "@angular/router";
import {UsersService} from "../../users/users.service";

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
  private isLoggedIn = false;
  private currentUser

  constructor(private securityService: SecurityService, private router: Router, private usersService: UsersService) {
  }

  ngOnInit(): void {
    this.securityService.events.subscribe(state => {
      this.isLoggedIn = state;
      if (state == true) {
        this.usersService.getActiveUser().subscribe(response => this.currentUser = response)
      }
      console.log("state" + state)
    })

  }

  login() {
    this.securityService.login(this.username, this.password)
      .subscribe(() => {
        this.loginResult = true
        this.router.navigateByUrl("/")
      }, () => {
        this.loginResult = false
        this.pendingRequest = false
      })
    console.log(this.loginResult)
  }

  logout(){
    this.securityService.logout();
    this.loginResult=null
    this.username=""
    this.password=""
  }

}
