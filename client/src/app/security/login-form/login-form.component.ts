import {Component} from '@angular/core';
import {SecurityService} from '../security.service';
import {Router} from '@angular/router';
import {User} from "../user";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  username: string
  password: string
  loginError: boolean
  pendingRequest = false
  isLoggedIn: boolean
  user: {
    name: string
  }
  userNameRestored: string

  constructor(private securityService: SecurityService, private router: Router) {
    this.setUser()
  }

  login() {
    this.pendingRequest = true
    this.securityService.login(this.username, this.password)
      .subscribe(() => {
        this.router.navigateByUrl('')
        this.isLoggedIn = true
        this.setUser()
        this.restoreUserName()
        this.loginError=false
      }, () => {
        this.loginError = true
        this.pendingRequest = false
      })
  }

  logout() {
    this.securityService.logout();
    this.userNameRestored = ""
    this.isLoggedIn = false
    this.username = ""
    this.password = ""
  }

  restoreUserName() {
    if (this.user) {
      this.userNameRestored = this.user.name
    }
  }

  setUser(){
    this.user = this.securityService.getUser()
    if (this.user) {
      this.isLoggedIn = true
      this.restoreUserName()
    } else {
      this.isLoggedIn = false
    }
  }

}
