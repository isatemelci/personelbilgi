package com.javakurs.personelbilgi.bean;

import com.javakurs.personelbilgi.entity.Kisi;
import com.javakurs.personelbilgi.entity.Telefon;
import com.javakurs.personelbilgi.service.KisiService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "kayitBean")
@RequestScoped
public class KayitBean {

    @EJB
    private KisiService kisiService;

    private Kisi kisi;
    private Telefon cepTel;
    private Telefon evTel;
    private String message;

    public KayitBean() {

//        kisiService=new KisiService();
        kisi = new Kisi();
        cepTel = new Telefon();
        evTel = new Telefon();
    }

    public void ekle() {

        //one-to-many çift taraflı, ikisinden de set etmek gerekir.
        List<Telefon> telefonList = new ArrayList<>();

        telefonList.add(evTel);
        telefonList.add(cepTel);

        kisi.setTelefonList(telefonList);

        cepTel.setKisi(kisi);
        evTel.setKisi(kisi);

        kisiService.ekle(kisi);

        message = "Kayıt başarılı...";

        kisi = new Kisi();
        cepTel = new Telefon();
        evTel = new Telefon();

    }

//    public List<Kisi> kisileriGetir() {
//
//        List kisiler;
//
//        kisiler = kisiService.kisileriGetir();
//
//        return kisiler;
//    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
