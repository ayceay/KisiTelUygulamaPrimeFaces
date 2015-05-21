/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluyg.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.kisiteluyg.entity.Kullanici;
import tr.gov.ptt.kisiteluyg.facades.KullaniciFacade;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisService {

    @EJB
    private KullaniciFacade kullaniciFacade;
    
    public boolean girisKontrol(Kullanici p_kullanici)
    {
        boolean donus = false;
        
        Kullanici k = kullaniciFacade.girisKontrol(p_kullanici);
        if(k != null)
            donus = true;
        return donus;
    }
    
    
}
