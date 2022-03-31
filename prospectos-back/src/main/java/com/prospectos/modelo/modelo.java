package com.prospectos.modelo;
import javax.persistence.*;
@Entity
@Table(name="tbarchivos")
public class modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length=100)
    private String doc;
    @Column(length = 10)
    private long idre;
    private String name;
    @Column(length = 100)
    private String url;
    public modelo(){
        super();
    }

    public modelo(Long id,String name, String url) {
        this.id=id;
        this.name = name;
        this.url = url;
        
    }
    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
