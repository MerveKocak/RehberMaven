package tr.gov.ptt.rehbermaven.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class MenuBean {
    private DefaultMenuModel menuModel;

    public MenuBean() {
        menuModel = new DefaultMenuModel();
        DefaultSubMenu kisiSubMenu = new DefaultSubMenu("Kişi");
        DefaultMenuItem ekleMI = new DefaultMenuItem("Ekle");
        ekleMI.setCommand("kisiEkle.xhtml?faces-redirect=true");
        ekleMI.setIcon("ui-icon-plus");
        kisiSubMenu.addElement(ekleMI);
        DefaultMenuItem listeleMI = new DefaultMenuItem("Listele");
        listeleMI.setCommand("kisiListele.xhtml?faces-redirect=true");
        listeleMI.setIcon("ui-icon-script");
        kisiSubMenu.addElement(listeleMI);
        menuModel.addElement(kisiSubMenu);
        DefaultSubMenu girisCikisSubMenu = new DefaultSubMenu("Giriş-Çıkış");
        DefaultMenuItem girisMI = new DefaultMenuItem("Giriş");
        girisMI.setCommand("giris.xhtml?faces-redirect=true");
        girisMI.setIcon("ui-icon-check");
        girisCikisSubMenu.addElement(girisMI);
        DefaultMenuItem cikisMI = new DefaultMenuItem("Çıkış");
        cikisMI.setCommand("#{girisBean.guvenliCikis()}");
        cikisMI.setIcon("ui-icon-close");
        girisCikisSubMenu.addElement(cikisMI);
        
        menuModel.addElement(girisCikisSubMenu);
    }
    public MenuModel getModel()
    {
        return menuModel;
    }
    
    
}
