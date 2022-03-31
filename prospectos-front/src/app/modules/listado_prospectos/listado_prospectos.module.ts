import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { Listado_prospectosRoutingModule } from './listado_prospectos-routing.module';
import { Listado_prospectosComponent } from './listado_prospectos.component';
@NgModule({
  declarations: [Listado_prospectosComponent],
  imports: [
    CommonModule,
    Listado_prospectosRoutingModule,
    SharedModule
  ]
})
export class Listado_prospectosModule { }
