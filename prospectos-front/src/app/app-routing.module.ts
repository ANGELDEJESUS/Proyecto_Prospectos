import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'listado_prospectos', loadChildren: () => import('./modules/listado_prospectos/listado_prospectos.module').then(m => m.Listado_prospectosModule) },
  { path: 'evaluacion_prospectos', loadChildren: () => import('./modules/evaluacion_prospectos/evaluacion_prospectos.module').then(m => m.Evaluacion_prospectosModule) },
  { path: 'captura_prospecto', loadChildren: () => import('./modules/captura_prospecto/captura_prospecto.module').then(m => m.Captura_prospectoModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
