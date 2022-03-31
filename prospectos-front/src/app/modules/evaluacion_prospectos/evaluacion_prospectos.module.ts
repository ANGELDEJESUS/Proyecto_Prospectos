import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Evaluacion_prospectosRoutingModule } from './evaluacion_prospectos-routing.module';
import { Evaluacion_prospectosComponent } from './evaluacion_prospectos.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [Evaluacion_prospectosComponent],
  imports: [
    CommonModule,
    Evaluacion_prospectosRoutingModule,
    SharedModule,

  ]
})
export class Evaluacion_prospectosModule { }
