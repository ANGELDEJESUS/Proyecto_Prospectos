import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Captura_prospectoRoutingModule } from './captura_prospecto-routing.module';
import { Captura_prospectoComponent } from './captura_prospecto.component';
import { SharedModule } from '../shared/shared.module';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

@NgModule({
  declarations: [Captura_prospectoComponent],
  imports: [
    CommonModule,
    Captura_prospectoRoutingModule,
    SharedModule,
    SweetAlert2Module,
  ],

    //=> In submodules only:

    //=> In submodules only, overriding options from your root module:
})
export class Captura_prospectoModule {

 }
