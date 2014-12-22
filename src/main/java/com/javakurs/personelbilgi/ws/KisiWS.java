/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javakurs.personelbilgi.ws;

import com.javakurs.personelbilgi.entity.Kisi;
import com.javakurs.personelbilgi.service.KisiService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author dream
 */
@WebService(serviceName = "KisiWS")
public class KisiWS {
    @EJB
    private KisiService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "ekle")
    @Oneway
    public void ekle(@WebParam(name = "pKisi") Kisi pKisi) {
        ejbRef.ekle(pKisi);
    }

    @WebMethod(operationName = "kisileriGetir")
    public List<Kisi> kisileriGetir() {
        return ejbRef.kisileriGetir();
    }
    
}
