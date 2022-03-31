import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import  {  FormGroup,  FormControl,  Validators}  from  '@angular/forms';
import { HttpClient, HttpRequest, HttpEvent,HttpParams,HttpEventType,HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { HtmlParser } from '@angular/compiler';
import { literal } from '@angular/compiler/src/output/output_ast';
@Component({
  selector: 'app-biology',
  templateUrl: './captura_prospecto.component.html',
  styleUrls: ['./captura_prospecto.component.css']
})
export class Captura_prospectoComponent implements OnInit {
    //Url obtenida de la variable de enviroments
    baseUrl = "http://localhost:8080";
  //Lista de archivos seleccionados
  selectedFiles!: FileList;
  //Es el array que contiene los items para mostrar el progreso de subida de cada archivo
  progressInfo = []
  //Mensaje que almacena la respuesta de las Apis
  message = '';
  //Nombre del archivo para usarlo posteriormente en la vista html
  fileName = "";
  public nombre=[];
  fileInfos!: Observable<any>;

    selectFiles(event:any) {
      for (let index = 0; index < event.target.files.length; index++) {
        this.nombre = event.target.files[index].name;

      }
      console.log(event.target.files[0].name);
      event.target.files.length == 1 ? this.fileName = event.target.files[0].name : this.fileName = event.target.files.length + " archivos";
      this.selectedFiles = event.target.files;
    }
    uploadFiles() {
      this.message = '';
      for (let i = 0; i < this.selectedFiles.length; i++) {
        this.upload(i, this.selectedFiles[i]);
      }
    }
    upload(index:any, file:any) {

      this.subir(file).subscribe(
        event => {
          if (event.type === HttpEventType.UploadProgress) {
          } else if (event instanceof HttpResponse) {
             this.fileInfos = this.getFiles();
          }
          this.message='Se subio'+file.name;
        },
        err => {
          this.message = 'No se puede subir el archivo ' + file.name;
        });
        return this.message;
    }
    deleteFiles(filename: string) {
      this.deleteFile(filename).subscribe(res => {
         console.log(res);
        this.fileInfos = this.getFiles();
      });

    }
    //Metodo que envia los archivos al endpoint /upload
    subir(file: File): Observable<HttpEvent<any>>{
      const formData: FormData = new FormData();
      formData.append('files', file);

      const req = new HttpRequest('POST', `${this.baseUrl}/upload`, formData, {
        reportProgress: true,
        responseType: 'json'
      });
      console.log(req);
      return this.httpClient.request(req);
    }

    //Metodo para Obtener los archivos
    getFiles(){
      return this.httpClient.get(`${this.baseUrl}/files`);
    }

    //Metodo para borrar los archivos
    deleteFile(filename: string){
      return this.httpClient.get(`${this.baseUrl}/delete/${filename}`);
    }

  uploadMultiple(event: any) {
    const files: FileList = event.target.files;

    const formdata = new FormData();

    for (let index = 0; index < files.length; index++) {
      const element = files[index];
      formdata.append('files', element);
    }
  }
  public listaprospectos:any = [];


  onSubmit(f: NgForm) {

    if (f.value['nombre']==""){
       return console.log('error');
    }
    if (f.value['apellido1']==""){
      return console.log('error');
      }
    if (f.value['apellido2']==""){
       return console.log('error');
        }
    if (f.value['calle']==""){
        return console.log('error');
          }
    if (f.value['numero']==""){
        return console.log('error');
            }
    if (f.value['colonia']==""){
        return console.log('error');
              }
    if (f.value['codpos']==""){
        return console.log('error');
    }
    var datos=(
      {
        "nombreprospecto":f.value['nombre'],
        "primerapellidoprospecto":f.value['apellido1'],
        "segundoapellidoprospecto":f.value['apellido2'],
        "calleprospecto":f.value['calle'],
        "numeroprospecto":f.value['numero'],
        "coloniaprospecto":f.value['colonia'],
        "codigopostalprospecto":f.value['codpos'],
        "telefonoprospecto":f.value['telefono'],
        "rfcprospecto":f.value['rfc'],
        "estatusprospecto":"enviado"
    }
    )


    this.httpClient.post("http://localhost:8080/guardar",datos).subscribe(respuesta=>{
      this.listaprospectos=respuesta
      console.log(this.listaprospectos.id)
    });
    for (let index = 0; index < this.selectedFiles.length; index++) {
      const element = this.selectedFiles[index].name;
      if (element=="") {
         return ;
      }
      var archivo=({
        "doc":element,
        "name":this.listaprospectos.id,
        "url":"http://localhost:8080/files/"+element
    })
      this.httpClient.post("http://localhost/archivo/archivo.php",archivo).subscribe(respuesta=>{
      console.log(respuesta)
    });
    }


  }

  constructor(private httpClient:  HttpClient) { }

  ngOnInit(): void {
    console.log(this.selectedFiles);
    this.fileInfos = this.getFiles();
  }

}
