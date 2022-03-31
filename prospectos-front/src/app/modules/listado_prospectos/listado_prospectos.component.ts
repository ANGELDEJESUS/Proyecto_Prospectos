import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { prospectos } from './prospecto';
import {MatAccordion} from '@angular/material/expansion';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-chemistry',
  templateUrl: './listado_prospectos.component.html',
  styleUrls: ['./listado_prospectos.component.css']
})

export class Listado_prospectosComponent implements OnInit {
  public listaprospectos:any = [];
  public mostrar=false;
  public id:any;
  public arch:any=[];
  constructor(private httpClient:HttpClient,public dialog: MatDialog) { }
  mostrarmas(id:any){
    console.log(id);
     this.id=id;
     this.mostrar=true
  }
  mostrarmenos(id:any){

  }
  public cargarinfo(){
    this.httpClient.get('http://localhost:8080/obtener').subscribe(respuesta=>{
      console.log(respuesta)
      this.listaprospectos=respuesta;
    })

  }

  public cargararc(){
    this.httpClient.get('http://localhost/archivo/barrido.php').subscribe(respuesta=>{
      console.log(JSON.stringify(respuesta));
      this.arch=respuesta;
    })}
  ngOnInit(): void {
    this.cargarinfo();
    this.cargararc();
  }

}
