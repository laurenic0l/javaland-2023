package org.dwcj.javaland.components.pagemanager;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.tabcontrol.TabControl;

/**
 * Helper class which facilitates proper behavior between the tab controls for
 * selection
 * and display within the various templates, and the TabControl component
 */
@InlineStyleSheet(id = "javaland-page-manager", value = "context://public/components/pagemanager/pagemanager.css", once = true)
public class PageManager extends Div {

  TabControl panels = new TabControl();

  @Override
  protected void create(AbstractPanel p) {
    super.create(p);
    this.add(this.panels);
    addClassName("pagemanager");
  }

  /**
   * Adds a title to the content display section to be associated with a
   * page later on
   *
   * @param title Title of the page
   * @return The object itself
   */
  public PageManager addEntry(String title) {
    this.panels.add(title);
    return this;
  }

  /**
   * Adds a page to the content section of an AppLayout class
   *
   * @param title Title of the page
   * @param page  The object extending or implementing Div to be displayed
   * @return The object itself
   */
  public PageManager addPage(String title, Div page) {
    this.panels.add(title, page);
    return this;
  }

  /**
   * Sets the content of an already existing tab with no associated panel
   *
   * @param idx  Desired tab to have a panel attached
   * @param page Desired panel to attach to the tab
   * @return The object itself
   */
  public PageManager setPage(int idx, Div page) {
    this.panels.setPanelAt(idx, page);
    return this;
  }

  /**
   * Removes a page from the content section of the AppLayout class's available
   * for display
   *
   * @param index Index of the desired object to be removed
   * @return The object itself
   */
  public PageManager removePage(int index) {
    this.panels.remove(index);
    return this;
  }

  /**
   * Selects a page/object to be displayed in the content section of the AppLayout
   *
   * @param index Index of the desired page/object to be displayed
   * @return The class itself
   */
  public PageManager displayPage(int index) {
    this.panels.selectIndex(index);
    return this;
  }

  /**
   * Returns the TabControl that stores the various objects/pages for display
   *
   * @return The tab control responsible for page display
   */
  public TabControl getPanels() {
    return this.panels;
  }

  /**
   * Get the name of the page at the given index
   *
   * @param index Index of the page
   * @return The name of the page
   */
  public String getPageName(int index) {
    return this.panels.getTitleAt(index).replaceAll("<[^>]*>","").trim().toLowerCase();
  }
}
