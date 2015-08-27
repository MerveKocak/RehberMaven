package tr.gov.ptt.rehbermaven.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import tr.gov.ptt.rehbermaven.entity.Kisi;
import tr.gov.ptt.rehbermaven.service.KisiService;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

@Named(value = "kisiBean")
@RequestScoped
public class KisiBean {

    private Kisi kisi = new Kisi();
    @EJB
    private KisiService kisiService;

    public KisiBean() {
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public String ekle() {
        kisiService.ekle(kisi);
        JSFUtil.mesajGoster("Kişi Eklendi", kisi.getAd() + " " + kisi.getSoyad()
                + " eklendi.");
        return "kisiListele.xhtml?faces-redirect=true";
    }
    public List<Kisi> getKisiListe()
    {
        return kisiService.kisileriGetir();
    }
}
