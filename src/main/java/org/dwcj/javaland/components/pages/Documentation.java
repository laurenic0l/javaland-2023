package org.dwcj.javaland.components.pages;

import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.htmlcontainer.HtmlContainer;

@InlineStyleSheet(id = "javaland-page-documentation", value = "context://public/pages/documentation.css", once = true)
public final class Documentation extends Div {

  public Documentation() {

    addClassName("page page--documentation");

    HtmlContainer hc = new HtmlContainer();
    hc.setUrl("https://dwcj.org/");
    hc.setStyle("width", "100%");
    hc.setStyle("height", "100%");

    add(hc);
  }
}
