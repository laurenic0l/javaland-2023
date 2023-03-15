package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.tabcontrol.TabControl;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.javaland.components.qrcode.QRCode;
import org.dwcj.util.Assets;
import org.dwcj.widgets.code.Code;

public class QRCodeSample extends AbstractControl {

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
              <h2>Web Components.</h2>
              <p>Reach outside of the extensive set of DWCJ core components by importing your favorite web components using the DWCJ’s web component API. Utilize any open-source web component library, or create your own for use in your application.</p>
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
    application.setText(Assets.contentOf("public/pages/home/code/qrcode/Application.java"));

    Code component = new Code();
    tabs.add("QRCode.java", component);
    component.setLanguage("java");
    component.setText(Assets.contentOf("public/pages/home/code/qrcode/Component.java"));
    tabs.selectIndex(1);

    // 2 Result
    // =================
    Div result = new Div();
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

    TextBox input = new TextBox();
    result.add(input);
    input.setText(qr.getValue());
    input.setAttribute("placeholder", "Enter a value");
    input.onEditModify((e) -> {
      qr.setValue(input.getText());
    });
  }
}
