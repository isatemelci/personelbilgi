package com.javakurs.personelbilgi.service;

import com.javakurs.personelbilgi.entity.Kisi;
import com.javakurs.personelbilgi.facade.KisiFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dream
 */
@Stateless
public class KisiService {

    @EJB
    private KisiFacade kisiFacade;

    public void ekle(Kisi pKisi) {
        kisiFacade.create(pKisi);
    }

    public List<Kisi> kisileriGetir() {
        
        return kisiFacade.findAll();
    }
}
