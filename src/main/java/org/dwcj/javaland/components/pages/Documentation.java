package org.dwcj.javaland.components.pages;

import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.htmlcontainer.HtmlContainer;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;

@InlineStyleSheet(id = "javaland-page-documentation", value = "context://public/pages/documentation.css", once = true)
public final class Documentation extends Div {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    addClassName("page page--documentation");

    HtmlContainer hc = new HtmlContainer();
    hc.setUrl("https://dwcj.org/");
    hc.setStyle("width", "100%");
    hc.setStyle("height", "100%");

    add(hc);
  }
}
