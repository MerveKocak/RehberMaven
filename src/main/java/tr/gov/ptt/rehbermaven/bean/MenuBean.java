package tr.gov.ptt.rehbermaven.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.rehbermaven.entity.Menu;
import tr.gov.ptt.rehbermaven.service.MenuService;

@ManagedBean
@SessionScoped
public class MenuBean {

    private DefaultMenuModel menuModel;
    @EJB
    private MenuService menuService;

    public MenuBean() {
//        menuModel = new DefaultMenuModel();
//        DefaultSubMenu kisiSubMenu = new DefaultSubMenu("Kişi");
//        DefaultMenuItem ekleMI = new DefaultMenuItem("Ekle");
//        ekleMI.setCommand("kisiEkle.xhtml?faces-redirect=true");
//        ekleMI.setIcon("ui-icon-plus");
//        kisiSubMenu.addElement(ekleMI);
//        DefaultMenuItem listeleMI = new DefaultMenuItem("Listele");
//        listeleMI.setCommand("kisiListele.xhtml?faces-redirect=true");
//        listeleMI.setIcon("ui-icon-script");
//        kisiSubMenu.addElement(listeleMI);
//        menuModel.addElement(kisiSubMenu);
//        DefaultSubMenu girisCikisSubMenu = new DefaultSubMenu("Giriş-Çıkış");
//        DefaultMenuItem girisMI = new DefaultMenuItem("Giriş");
//        girisMI.setCommand("giris.xhtml?faces-redirect=true");
//        girisMI.setIcon("ui-icon-check");
//        girisCikisSubMenu.addElement(girisMI);
//        DefaultMenuItem cikisMI = new DefaultMenuItem("Çıkış");
//        cikisMI.setCommand("#{girisBean.guvenliCikis()}");
//        cikisMI.setIcon("ui-icon-close");
//        girisCikisSubMenu.addElement(cikisMI);
//        
//        menuModel.addElement(girisCikisSubMenu);
    }

    @PostConstruct
    public void menuDoldur() {
        menuModel = new DefaultMenuModel();
        DefaultSubMenu subMenu = new DefaultSubMenu("Menu");

        List<Menu> menuListe = menuService.siraliMenuGetir();
        
        for (Menu menu : menuListe) {
            DefaultMenuItem menuItem = new DefaultMenuItem(menu.getAd());
            menuItem.setCommand(menu.getLink());
            menuItem.setIcon(menu.getIcon());
            subMenu.addElement(menuItem);
        }
        menuModel.addElement(subMenu);

    }

    public MenuModel getModel() {
        return menuModel;
    }

}
