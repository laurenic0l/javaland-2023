package org.dwcj.javaland;



import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.tabbedpane.TabbedPane.Alignment;
import org.dwcj.javaland.components.apptemplate.AppTemplate;
import org.dwcj.javaland.components.pages.Documentation;
import org.dwcj.javaland.components.pages.dashboard.Dashboard;
import org.dwcj.javaland.components.pages.home.Home;
import org.dwcj.javaland.components.themeswitcher.ThemeSwitcher;


@InlineStyleSheet(id = "javaland-shell", value = "context://public/shell.css", once = true)
@InlineStyleSheet(id = "javaland-typography", value = "context://public/typography.css", once = true)
public final class Shell extends AppTemplate {

  // @Override
  // protected void create(Window panel) {
  //   super.create(panel);
  //   configureHeader();
  //   configurePages();
  // }

  public Shell(){
    configureHeader();
    configurePages();
  }

  private void configureHeader() {
    setDrawerPlacement(AppLayout.DrawerPlacement.HIDDEN);

    Div header = new Div();
    menu.setAlignment(Alignment.CENTER);
    menu.setExpanse(Expanse.LARGE);
    header.add(menu, new ThemeSwitcher());
    header.addClassName("header__primary");

    addToHeader(header);
  }

  private void configurePages() {
    addPage("<bbj-icon name='home' part='icon'></bbj-icon>  Home", new Home());
    addPage("<bbj-icon name='dashboard' part='icon'></bbj-icon>  Dashboard", new Dashboard());
    addPage("<bbj-icon name='book' part='icon'></bbj-icon>  dwcj.org", new Documentation());
  }
}
