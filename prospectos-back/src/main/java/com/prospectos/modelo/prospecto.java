package com.prospectos.modelo;

import javax.persistence.*;
@Entity
@Table(name="tbprospectos")
//@JsonDeserialize(as = prospecto.class)
public  class prospecto{
    public  prospecto() {
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String nombreprospecto;
    @Column(length = 50)
    private String primerapellidoprospecto;
    @Column(length=50)
    private String segundoapellidoprospecto;
    @Column(length = 100)
    private String calleprospecto;
    @Column(length=10)
    private String numeroprospecto;
    @Column(length = 100)
    private String coloniaprospecto;
    @Column(length=5)
    private String codigopostalprospecto;
    @Column(length = 10)
    private String telefonoprospecto;
    @Column(length = 13)
    private String rfcprospecto;
    @Column(length = 10)
    private String estatusprospecto;
    @Column(length=200)
    private String descripcionprospecto;

    public prospecto( long id,String nombreprospecto, String primerapellidoprospecto,String segundoapellidoprospecto,String calleprospecto,String numeroprospecto,String coloniaprospecto,String codigopostalprospecto,String telefonoprospecto,String rfcprospecto,String estatusprospecto,String descripcionprospecto){
        this.id=id;
        this.nombreprospecto=nombreprospecto;
        this.primerapellidoprospecto=primerapellidoprospecto;
        this.segundoapellidoprospecto=segundoapellidoprospecto;
        this.calleprospecto=calleprospecto;
        this.numeroprospecto=numeroprospecto;
        this.coloniaprospecto=coloniaprospecto;
        this.codigopostalprospecto=codigopostalprospecto;
        this.telefonoprospecto=telefonoprospecto;
        this.rfcprospecto=rfcprospecto;
        this.estatusprospecto=estatusprospecto;
       this.descripcionprospecto=descripcionprospecto;
    }

    public long getid(){return id;}
    public void setid(long id){this.id=id;}

    public String getprimerapellidoprospecto(){return primerapellidoprospecto;}
    public void setprimerapellidoprospecto(String primerapellidoprospecto){this.primerapellidoprospecto=primerapellidoprospecto;}
    
    public String getsegundoapellidoprospecto(){return segundoapellidoprospecto;}
    public void setsegundoapellidoprospecto(String segundoapellidoprospecto){this.segundoapellidoprospecto=segundoapellidoprospecto;}
    
    public String getcalleprospecto(){return calleprospecto;}
    public void setcalleprospecto(String calleprospecto){this.calleprospecto=calleprospecto;}
    
    public String getnumeroprospecto(){return numeroprospecto;}
    public void setnumeroprospecto(String numeroprospecto){this.numeroprospecto=numeroprospecto;}
    
    public String getcoloniaprospecto(){return coloniaprospecto;}
    public void setcoloniaprospecto(String coloniaprospecto){this.coloniaprospecto=coloniaprospecto;}
    
    public String getcodigopostalprospecto(){return codigopostalprospecto;}
    public void setcodigopostalprospecto(String codigopostalprospecto){this.codigopostalprospecto=codigopostalprospecto;}
    
    public String gettelefonoprospecto(){return telefonoprospecto;}
    public void settelefonoprospecto(String telefonoprospecto){this.telefonoprospecto=telefonoprospecto;}
    
    public String getrfcprospecto(){return rfcprospecto;}
    public void setrfcprospecto(String rfcprospecto){this.rfcprospecto=rfcprospecto;}
    
    public String getnombreprospecto() {
        return nombreprospecto;
    }
    public void setnombreprospecto(String nombreprospecto) {
        this.nombreprospecto = nombreprospecto;
    }
    public String getestatusprospecto(){return estatusprospecto;}
    public void setestatusprospecto(String estatusprospecto){this.estatusprospecto=estatusprospecto;}
    
    public String getdescripcionprospecto(){return descripcionprospecto;}
    public void setdescripcionprospecto(String descripcionprospecto){this.descripcionprospecto=descripcionprospecto;}
}