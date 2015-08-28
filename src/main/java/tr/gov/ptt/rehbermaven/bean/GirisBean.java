package tr.gov.ptt.rehbermaven.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.servlet.http.HttpSession;
import tr.gov.ptt.rehbermaven.entity.Giris;
import tr.gov.ptt.rehbermaven.entity.Log;
import tr.gov.ptt.rehbermaven.facade.LogFacade;
import tr.gov.ptt.rehbermaven.service.GirisService;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

@ManagedBean(name = "girisBean")
@RequestScoped
public class GirisBean {

    private Giris giris = new Giris();
    private java.util.Date tarihSaat = new Date();
    @EJB
    private GirisService girisService;
    @EJB
    private LogFacade logFacade;

    public GirisBean() {
        giris.setKullanici("şengül");
        giris.setSifre("1234");
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }

    public Date getTarihSaat() {
        return tarihSaat;
    }

    public void setTarihSaat(Date tarihSaat) {
        this.tarihSaat = tarihSaat;
    }

    public String giriseYetkilimi() {
        boolean sonuc = girisService.giriseYetkilimi(giris);
        Log log = new Log();
        
        if (sonuc) {
            HttpSession session = JSFUtil.getSession();
            System.out.println(session.getId() + " nolu session başlıyor.");
            session.setAttribute("kullanici", giris.getKullanici());
            log.setIslem("Başarılı Giriş");
            log.setKullanici(giris.getKullanici());
            log.setTarihsaat(new java.util.Date());
            logFacade.create(log);
            return "menu.xhtml?faces-redirect=true";
        } else {
            JSFUtil.hataGoster("Hatalı Giriş", "Kullanıcı adı ya da şifre yanlış");
            log.setIslem("Hatalı Giriş");
            log.setKullanici(giris.getKullanici());
            log.setTarihsaat(new java.util.Date());
            logFacade.create(log);
            return "giris.xhtml?faces-redirect=true";
        }

    }
    public String guvenliCikis() {
       HttpSession session = JSFUtil.getSession();
       JSFUtil.sessionBitir(session);
       JSFUtil.mesajGoster("Oturumunuz sonlandı.", "Yeniden giriş yapınız");
       return "giris.xhtml?faces-redirect=true";
    }
    public void sistemTarihSaatGuncelle()
    {
        tarihSaat = new java.util.Date();
        
    }
    public String sistemTarihSaatGetir()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
        return sdf.format(tarihSaat);
    }

}
