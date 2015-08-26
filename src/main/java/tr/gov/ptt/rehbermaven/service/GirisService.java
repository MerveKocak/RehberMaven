package tr.gov.ptt.rehbermaven.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.rehbermaven.entity.Giris;
import tr.gov.ptt.rehbermaven.facade.GirisFacade;

@Stateless
public class GirisService {
    @EJB
    private GirisFacade girisFacade;
    public boolean giriseYetkilimi(Giris p_giris)
    {
        return girisFacade.girisKontrol(p_giris);
    }
    
}
