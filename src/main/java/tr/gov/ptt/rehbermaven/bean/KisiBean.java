package tr.gov.ptt.rehbermaven.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;
import tr.gov.ptt.rehbermaven.entity.Kisi;
import tr.gov.ptt.rehbermaven.service.KisiService;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

@ManagedBean(name = "kisiBean")
@SessionScoped
public class KisiBean {

    private Kisi kisi = new Kisi();
    private List<Kisi> kisiListesi = new ArrayList<Kisi>();
    @EJB
    private KisiService kisiService;

    public KisiBean() {
    }

    @PostConstruct
    public void doldurKisiListe() {
        kisiListesi = kisiService.kisileriGetir();
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
        kisiListeGuncelle();
        return "kisiListele.xhtml?faces-redirect=true";
    }

    public List<Kisi> getKisiListe() {
        return kisiListesi;
    }

    public void kisiListeGuncelle() {
        kisiListesi = kisiService.kisileriGetir();
    }


    public void onRowEdit(RowEditEvent p_event) {
        kisi = (Kisi) p_event.getObject();
        kisiService.guncelle(kisi);
        JSFUtil.mesajGoster("Kişi Güncellendi.", kisi.getAd() + " " + kisi.getSoyad()
                + "güncellendi");
    }
    public void onRowCancel(RowEditEvent p_event) {
        kisi = (Kisi) p_event.getObject();
        JSFUtil.mesajGoster("Kişi Güncellenmedi.", kisi.getAd() + " " + kisi.getSoyad()
                + "güncellenmedi");
    }

}
