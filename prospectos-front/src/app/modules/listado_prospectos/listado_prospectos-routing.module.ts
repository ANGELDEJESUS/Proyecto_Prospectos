import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Listado_prospectosComponent } from './listado_prospectos.component';
const routes: Routes = [{ path: '', component: Listado_prospectosComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Listado_prospectosRoutingModule {}
