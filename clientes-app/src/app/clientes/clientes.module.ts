import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClientesRoutingModule } from './clientes-routing.module';


@NgModule({
  declarations: [ClientesFormComponent],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    FormsModule
  ],
  exports: [
    ClientesFormComponent
  ]
})
export class ClientesModule { }
