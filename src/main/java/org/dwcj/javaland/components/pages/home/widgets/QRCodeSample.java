package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.addons.code.Code;
import org.dwcj.component.AbstractComponent;
import org.dwcj.component.field.TextField;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.javaland.components.qrcode.QRCode;
import org.dwcj.utilities.Assets;


public class QRCodeSample extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {

    Panel sample = new Panel();
    panel.add(sample);
    sample.addClassName("javalandSample");

    // 1 Content
    // =================
    Panel content = new Panel();
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
    tabs.add("App.java", application);
    application.setLanguage("java");
    application.setText(Assets.contentOf("public/pages/home/code/qrcode/Application.java"));

    Code component = new Code();
    tabs.add("QRCode.java", component);
    component.setLanguage("java");
    component.setText(Assets.contentOf("public/pages/home/code/qrcode/Component.java"));
    tabs.selectIndex(1);

    // 2 Result
    // =================
    Panel result = new Panel();
    sample.add(result);
    result.addClassName("javalandSample__result javalandSample__result--center");

    Label title = new Label(/* html */"""
        <html>
          <h3 style="margin: 0">QRCode Generator</h3>
        </html>
        """);
    title.setStyle("white-space","normal");
    result.add(title);

    QRCode qr = new QRCode("https://dwcj.org");
    result.add(qr);
    qr.setSize(200);
    qr.setSize(qr.getSize());
    qr.setColor(new java.awt.Color(0, 86, 179));

    TextField input = new TextField();
    result.add(input);
    input.setText(qr.getValue());
    input.setAttribute("placeholder", "Enter a value");
    input.onModify((e) -> {
      qr.setValue(input.getText());
    });
  }
}
