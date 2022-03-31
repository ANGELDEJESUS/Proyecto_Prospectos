import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Captura_prospectoComponent } from './captura_prospecto.component';

const routes: Routes = [{ path: '', component: Captura_prospectoComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Captura_prospectoRoutingModule { }
