package tr.gov.ptt.rehbermaven.bean;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import tr.gov.ptt.rehbermaven.entity.Giris;
import tr.gov.ptt.rehbermaven.service.GirisService;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

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

    public String giriseYetkilimi() {
        boolean sonuc = girisService.giriseYetkilimi(giris);
        if (sonuc) {
            return "menu.xhtml?faces-redirect=true";
        } else {
            JSFUtil.hataGoster("Hatalı Giriş", "Kullanıcı adı ya da şifre yanlış");
            return "giris.xhtml?faces-redirect=true";
        }

    }

}
