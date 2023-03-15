package org.dwcj.javaland;

import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;

import org.dwcj.javaland.components.apptemplate.AppTemplate;
import org.dwcj.javaland.components.pages.Documentation;
import org.dwcj.javaland.components.pages.dashboard.Dashboard;
import org.dwcj.javaland.components.pages.home.Home;
import org.dwcj.javaland.components.themeswitcher.ThemeSwitcher;

@InlineStyleSheet(id = "javaland-shell", value = "context://public/shell.css", once = true)
@InlineStyleSheet(id = "javaland-typography", value = "context://public/typography.css", once = true)
public final class Shell extends AppTemplate {

  @Override
  protected void create(AbstractPanel panel) {
    setVisible(false);
    super.create(panel);
    configureHeader();
    configurePages();
    setVisible(true);
  }

  private void configureHeader() {
    setDrawerPlacement(DrawerPlacement.HIDDEN);

    Div header = new Div();
    menu.setAttribute("alignment", "center");
    menu.setAttribute("expanse", "l");
    header.add(menu, new ThemeSwitcher());
    header.addClassName("header__primary");

    getHeader().add(header);
  }

  private void configurePages() {
    addPage("<bbj-icon name='home' part='icon'></bbj-icon>  Home", new Home());
    addPage("<bbj-icon name='dashboard' part='icon'></bbj-icon>  Dashboard", new Dashboard());
    addPage("<bbj-icon name='book' part='icon'></bbj-icon>  dwcj.org", new Documentation());
  }
}
