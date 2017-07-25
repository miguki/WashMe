import {Injectable} from '@angular/core';
import {Http, URLSearchParams} from '@angular/http';

@Injectable()
export class SecurityService {

  private oauthServerUrl = "http://localhost:8080/oauth/token"

  constructor(private http: Http) {
  }

  login(username: string, password: string) {
    let payload = this.preparePayload(username, password)
    this.http.post(this.oauthServerUrl, payload)
  }

  private preparePayload(username: string, password: string): URLSearchParams {
    let payload = new URLSearchParams()
    payload.set('username', username)
    payload.set('password', password)
    payload.set('grant_type', 'password')
    payload.set('client_id', 'connect-app')
    return payload
  }

}
