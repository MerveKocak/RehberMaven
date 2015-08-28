package tr.gov.ptt.rehbermaven.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.rehbermaven.entity.Kisi;
import tr.gov.ptt.rehbermaven.entity.Log;
import tr.gov.ptt.rehbermaven.facade.KisiFacade;
import tr.gov.ptt.rehbermaven.facade.LogFacade;
import tr.gov.ptt.rehbermaven.util.JSFUtil;

@Stateless
public class KisiService {
    @EJB
    private KisiFacade kisiFacade;
    
    @EJB
    private LogFacade logFacade;
    
    public void ekle(Kisi p_kisi)
    {
        kisiFacade.create(p_kisi);
        Log log = new Log();
        log.setKullanici(JSFUtil.getKullanici());
        log.setIslem("Ekleme");
        log.setKisino(p_kisi.getNo());
        log.setTarihsaat(new java.util.Date());
        logFacade.create(log);
    }
    public void guncelle(Kisi p_kisi)
    {
        kisiFacade.edit(p_kisi);
        Log log = new Log();
        log.setKullanici(JSFUtil.getKullanici());
        log.setIslem("Güncelleme");
        log.setKisino(p_kisi.getNo());
        log.setTarihsaat(new java.util.Date());
        logFacade.create(log);
    }
    public List<Kisi> kisileriGetir()
    {
        return kisiFacade.findAll();
    }
    
}
