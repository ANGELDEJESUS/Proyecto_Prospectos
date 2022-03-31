import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-mathematics',
  templateUrl: './evaluacion_prospectos.component.html',
  styleUrls: ['./evaluacion_prospectos.component.css']
})

export class Evaluacion_prospectosComponent implements OnInit {
  public listaprospectos:any = [];
  public listactualizar:any = [];
  public arch:any=[];

  public cont=this.listaprospectos.length;
  constructor(private httpClient:HttpClient) { }
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
    })

  }
    actualizar(id:any,nombre:any,primerap:any,segundoap:any,calle:any,numero:any,colonia:any,codigopos:any,telefono:any,rfc:any,estado:any,descripcion:any){
     var datos=(
      {
        "id":id,
        "nombreprospecto":nombre,
        "primerapellidoprospecto":primerap,
        "segundoapellidoprospecto":segundoap,
        "calleprospecto":calle,
        "numeroprospecto":numero,
        "coloniaprospecto":colonia,
        "codigopostalprospecto":codigopos,
        "telefonoprospecto":telefono,
        "rfcprospecto":rfc,
        "estatusprospecto":estado,
        "descripcionprospecto":descripcion
    });
    this.httpClient.put("http://localhost:8080/actualizar",datos).subscribe(respuesta=>{
      console.log(this.listaprospectos.estatusprospecto);
      this.cargarinfo();
    });

    }


  ngOnInit(): void {
    this.cargarinfo();
    this.cargararc();
  }


}
