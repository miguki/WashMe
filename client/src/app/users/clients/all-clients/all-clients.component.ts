import {Component, Input, OnInit} from '@angular/core';
import {UsersService} from "../../users.service";

@Component({
  selector: 'app-all-clients',
  templateUrl: './all-clients.component.html',
  styleUrls: ['./all-clients.component.css']
})
export class AllClientsComponent implements OnInit {

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.usersService.getAll().subscribe(clientsPage => this.clients = clientsPage.clients)
  }

  clients = []

}
