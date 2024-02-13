package org.dwcj.javaland.components.pagemanager;

import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.tabbedpane.TabbedPane;


/**
 * Helper class which facilitates proper behavior between the tab controls for
 * selection
 * and display within the various templates, and the TabbedPane component
 */
@InlineStyleSheet(id = "javaland-page-manager", value = "context://public/components/pagemanager/pagemanager.css", once = true)
public class PageManager extends Div {

  TabbedPane panels = new TabbedPane();

  // @Override
  // protected void create(AbstractWindow p) {
  //   super.create(p);
  //   this.add(this.panels);
  //   addClassName("pagemanager");
  // }

  public PageManager(){
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
    this.panels.addTab(title);
    return this;
  }

  /**
   * Adds a page to the content section of an AppLayout class
   *
   * @param title Title of the page
   * @param page  The object extending or implementing Panel to be displayed
   * @return The object itself
   */
  public PageManager addPage(String title, Div page) {
    this.panels.addTab(title, page);
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
    this.panels.setComponentFor(idx, page);
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
    this.panels.removeTab(index);
    return this;
  }

  /**
   * Selects a page/object to be displayed in the content section of the AppLayout
   *
   * @param index Index of the desired page/object to be displayed
   * @return The class itself
   */
  public PageManager displayPage(int index) {
    this.panels.select(index);
    return this;
  }

  /**
   * Returns the TabbedPane that stores the various objects/pages for display
   *
   * @return The tab control responsible for page display
   */
  public TabbedPane getPanels() {
    return this.panels;
  }

  /**
   * Get the name of the page at the given index
   *
   * @param index Index of the page
   * @return The name of the page
   */
  public String getPageName(int index) {
    return this.panels.getTab(index).getText().replaceAll("<[^>]*>","").trim().toLowerCase();
  }
}
