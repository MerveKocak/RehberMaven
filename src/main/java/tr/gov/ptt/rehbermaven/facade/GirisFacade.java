/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.rehbermaven.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.rehbermaven.entity.Giris;

/**
 *
 * @author Administrator
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {

    @PersistenceContext(unitName = "rehbermavenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }

    public boolean girisKontrol(Giris p_giris) {
        try {
            Giris giris = em.createNamedQuery("Giris.girisKontrol", Giris.class)
                    .setParameter("kullanici", p_giris.getKullanici())
                    .setParameter("sifre", p_giris.getSifre())
                    .getSingleResult();
            return true;
        } catch (NoResultException nre) {
            return false;
        }
    }
}
