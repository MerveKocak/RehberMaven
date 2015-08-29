
package tr.gov.ptt.rehbermaven.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.rehbermaven.entity.Menu;
import tr.gov.ptt.rehbermaven.facade.MenuFacade;

@Stateless
public class MenuService {
    @EJB
    private MenuFacade menuFacade;
    
   public List<Menu> siraliMenuGetir()
   {
       return menuFacade.siraliMenuGetir();
   }
    
}
