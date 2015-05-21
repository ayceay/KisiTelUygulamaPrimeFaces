/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluyg.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.kisiteluyg.entity.Kullanici;

/**
 *
 * @author Administrator
 */
@Stateless
public class KullaniciFacade extends AbstractFacade<Kullanici> {
    @PersistenceContext(unitName = "KisiTelUygPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KullaniciFacade() {
        super(Kullanici.class);
    }
    
    public Kullanici girisKontrol(Kullanici p_kullanici)
    {
        Kullanici kullanici =
                em.createNamedQuery("Kullanici.girisKontrol",Kullanici.class).
                        setParameter("pad", p_kullanici.getAd()).
                        setParameter("psifre", p_kullanici.getSifre()).getSingleResult();
                
        return kullanici;
    }
    
}
