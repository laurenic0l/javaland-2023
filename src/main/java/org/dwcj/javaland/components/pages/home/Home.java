package org.dwcj.javaland.components.pages.home;


import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.annotation.JavaScript;
import org.dwcj.component.html.elements.Div;
import org.dwcj.javaland.components.pages.home.widgets.AppLayoutSample;
import org.dwcj.javaland.components.pages.home.widgets.CounterSample;
import org.dwcj.javaland.components.pages.home.widgets.Header;
import org.dwcj.javaland.components.pages.home.widgets.QRCodeSample;

@JavaScript(value = "https://cdn.jsdelivr.net/npm/lazysizes@5.3.2/lazysizes.min.js")
@InlineStyleSheet(id = "javaland-page-home", value = "context://public/pages/home/home.css", once = true)
public final class Home extends Div {

  public Home() {

    addClassName("page page--home");

    add(new Header());
    add(new CounterSample());
    add(new AppLayoutSample());
    add(new QRCodeSample());

  }
}
