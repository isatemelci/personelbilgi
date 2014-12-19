package com.javakurs.personelbilgi.bean;

import com.javakurs.personelbilgi.entity.Kisi;
import com.javakurs.personelbilgi.entity.Telefon;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "kayitBean")
@RequestScoped
public class KayitBean {

    private Kisi kisi;
    private Telefon cepTel;
    private Telefon evTel;

    public KayitBean() {
        
        kisi = new Kisi();
        cepTel = new Telefon();
        evTel = new Telefon();
        
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Telefon getCepTel() {
        return cepTel;
    }

    public void setCepTel(Telefon cepTel) {
        this.cepTel = cepTel;
    }

    public Telefon getEvTel() {
        return evTel;
    }

    public void setEvTel(Telefon evTel) {
        this.evTel = evTel;
    }

}
