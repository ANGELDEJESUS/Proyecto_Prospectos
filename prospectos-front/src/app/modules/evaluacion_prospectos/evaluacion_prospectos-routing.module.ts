import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Evaluacion_prospectosComponent } from './evaluacion_prospectos.component';

const routes: Routes = [{ path: '', component: Evaluacion_prospectosComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class  Evaluacion_prospectosRoutingModule { }
