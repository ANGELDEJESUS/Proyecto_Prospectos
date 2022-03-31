export class prospectos {
  id!: number;
  private _nombreprospecto!: string;
  public get nombreprospecto(): string {
    return this._nombreprospecto;
  }
  public set nombreprospecto(value: string) {
    this._nombreprospecto = value;
  }
  primerapellidoprospecto!: string;
  segundoapellidoprospecto!: string;
  calleprospecto!: string;
  numeroprospecto!: String;
  coloniaprospecto!: String;
  codigopostalprospecto!: String;
  telefonoprospecto!: String;
  rfcprospecto!: String;
  estatusprospecto!: String;
}

