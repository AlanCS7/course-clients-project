import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Client } from './clientes/client';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor( private http: HttpClient ) { }

  salvar( client: Client ): Observable<Client> {
    return this.http.post<Client>('http://localhost:8080/api/clients', client);
  }


  getClient(): Client {
    let client: Client = new Client();
    client.nome = 'Alan Carlos';
    client.cpf = '362.692.358-47';
    return client;
  }
}
