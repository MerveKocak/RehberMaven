package tr.gov.ptt.rehbermaven.bean;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import tr.gov.ptt.rehbermaven.entity.Giris;
import tr.gov.ptt.rehbermaven.service.GirisService;

@Named(value = "girisBean")
@RequestScoped
public class GirisBean {
    private Giris giris = new Giris();
    @EJB
    private GirisService girisService;
    public GirisBean() {
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    public String giriseYetkilimi()
    {
        boolean sonuc = girisService.giriseYetkilimi(giris);
        if (sonuc) {
            return "menu.xhtml";
        } else {
            return "giris.xhtml";
        }
    }
    
}
