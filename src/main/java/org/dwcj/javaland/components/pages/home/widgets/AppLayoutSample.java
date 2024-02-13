package org.dwcj.javaland.components.pages.home.widgets;


import org.dwcj.addons.code.Code;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.Iframe;
import org.dwcj.component.htmlcontainer.HtmlContainer;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.utilities.Assets;

public class AppLayoutSample extends Div {

  public void AppLayoutSample() {


    Div sample = new Div();
    add(sample);
    sample.addClassName("javalandSample");

    // 1 Content
    // =================
    Div content = new Div();
    sample.add(content);
    content.addClassName("javalandSample__content");

    // 1.1 Description
    // =================
    Div description = new Div();
    content.add(description);
    description.addClassName("javalandSample__description");
    description.setHtml(
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
    TabbedPane tabs = new TabbedPane();
    content.add(tabs);
    tabs.addClassName("javalandSample__tabs");

    Code application = new Code();
    tabs.addTab("App.java", application);
    application.setLanguage("java");
    application.setText(Assets.contentOf("public/pages/home/code/applayout/Application.java"));

    // 2 Result
    // =================
    Div result = new Div();
    sample.add(result);
    result.addClassName("javalandSample__result");

    Div iframe = new Div();
    iframe.setStyle("height", "100%");
    result.add(iframe);
    iframe.addClassName("javalandSample__iframe");
    iframe.setHtml(/* html */"""
        <iframe
          class="lazyload"
          data-src="/files/javaland/applayout-demo.html"
          style="width: 100%; height: 100%; border: none;overflow: hidden;"
          loading="lazy">
          </iframe>
        """);
  }
}
