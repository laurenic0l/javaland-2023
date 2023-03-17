package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.htmlcontainer.HtmlContainer;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.tabcontrol.TabControl;
import org.dwcj.util.Assets;
import org.dwcj.widgets.code.Code;

public class AppLayoutSample extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    Div sample = new Div();
    panel.add(sample);
    sample.addClassName("javalandSample");

    // 1 Content
    // =================
    Div content = new Div();
    sample.add(content);
    content.addClassName("javalandSample__content");

    // 1.1 Description
    // =================
    Label description = new Label();
    content.add(description);
    description.addClassName("javalandSample__description");
    description.setText(
        /* html */"""
            <html>
              <h2>Simple to Scale.</h2>
              <p>
                As your application scales up,the DWCJ framework has you covered! It provides robust and responsive tools, such as the App Layout component, to help quickly and easily make your application ready to meet the needs of your business.
              </p>
            </html>
            """);

    // 1.2 Tabs
    // =================
    TabControl tabs = new TabControl();
    content.add(tabs);
    tabs.addClassName("javalandSample__tabs");

    Code application = new Code();
    tabs.add("App.java", application);
    application.setLanguage("java");
    application.setText(Assets.contentOf("public/pages/home/code/applayout/Application.java"));

    // 2 Result
    // =================
    Div result = new Div();
    sample.add(result);
    result.addClassName("javalandSample__result");

    HtmlContainer iframe = new HtmlContainer();
    iframe.setStyle("height", "100%");
    result.add(iframe);
    iframe.addClassName("javalandSample__iframe");
    iframe.setText(/* html */"""
        <iframe
          class="lazyload"
          data-src="/files/javaland/applayout-demo.html"
          style="width: 100%; height: 100%; border: none;overflow: hidden;"
          loading="lazy">
          </iframe>
        """);
  }
}
