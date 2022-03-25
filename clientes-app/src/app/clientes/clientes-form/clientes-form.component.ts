import { Component, OnInit } from '@angular/core';
import { ClientsService } from 'src/app/clients.service';

import { Client } from '../client';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  client: Client;
  success: boolean = false;
  errors: string[];

  constructor( private service: ClientsService ) {
    this.client = new Client();
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.salvar(this.client).subscribe( (resp: Client) => {
        this.success = true;
        this.errors = null;
        this.client = resp;
      } , errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      })
  }

}
