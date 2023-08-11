package org.dwcj.javaland.components.pages;

import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.htmlcontainer.HtmlContainer;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;

;

@InlineStyleSheet(id = "javaland-page-documentation", value = "context://public/pages/documentation.css", once = true)
public final class Documentation extends Panel {

  @Override
  protected void create(AbstractWindow panel) {
    super.create(panel);

    addClassName("page page--documentation");

    HtmlContainer hc = new HtmlContainer();
    hc.setUrl("https://dwcj.org/");
    hc.setStyle("width", "100%");
    hc.setStyle("height", "100%");

    add(hc);
  }
}
