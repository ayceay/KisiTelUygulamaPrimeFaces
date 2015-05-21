/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluyg.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.kisiteluyg.entity.Kullanici;
import tr.gov.ptt.kisiteluyg.service.GirisService;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class GirisBean {
    
    private Kullanici kullanici;
    @EJB
    private GirisService girisService;

    public GirisBean() {
       kullanici = new Kullanici();
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    
    
    public String girisKontrol()
    {
        boolean sonuc = false;
        try{
                girisService.girisKontrol(this.kullanici);
                sonuc = true;
        }
        catch(Exception exp)
        {
            sonuc = false;
        }
        if (sonuc) {
            return "ekle.xhtml?face-redirect=true";
        } else {
            return "giris.xhtml?faces-redirect=true";
        }
    }
    
}
