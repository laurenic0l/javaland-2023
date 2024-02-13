package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.addons.code.Code;
import org.dwcj.component.field.TextField;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.window.Panel;
import org.dwcj.javaland.components.qrcode.QRCode;
import org.dwcj.utilities.Assets;


public class QRCodeSample extends Div {

  public QRCodeSample() {

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
              <h2>Web Components.</h2>
              <p>Reach outside of the extensive set of DWCJ core components by importing your favorite web components using the DWCJ’s web component API. Utilize any open-source web component library, or create your own for use in your application.</p>
            </html>
            """);

    // 1.2 Tabs
    // =================
    TabbedPane tabs = new TabbedPane();
    content.add(tabs);
    tabs.addClassName("javalandSample__tabs");

    Code application = new Code();
    tabs.addTab("App.java", application);
    // application.setLanguage("java");
    // application.setText(Assets.contentOf("public/pages/home/code/qrcode/Application.java"));

    Code component = new Code();
    tabs.addTab("QRCode.java", component);
    // component.setLanguage("java");
    // component.setText(Assets.contentOf("public/pages/home/code/qrcode/Component.java"));
    tabs.select(1);

    // 2 Result
    // =================
    Panel result = new Panel();
    sample.add(result);
    result.addClassName("javalandSample__result javalandSample__result--center");

    Div title = new Div();
    title.setHtml(/* html */"""
        <html>
          <h3 style="margin: 0">QRCode Generator</h3>
        </html>
        """);
    title.setStyle("white-space","normal");
    result.add(title);

    QRCode qr = new QRCode();
    result.add(qr);
    qr.setColor(new java.awt.Color(0, 86, 179));

    TextField input = new TextField();
    result.add(input);
    input.setText(qr.getValue());
    input.setPlaceholder("Enter a value");
    input.onModify((e) -> {
      qr.setValue(input.getText());
    });
  }
}
