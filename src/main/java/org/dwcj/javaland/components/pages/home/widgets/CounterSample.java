package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.tabcontrol.TabControl;
import org.dwcj.util.Assets;
import org.dwcj.widgets.code.Code;

public class CounterSample extends AbstractControl {
  private int count = 0;

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
              <h2>Easy to Start.</h2>
              <p>
                Creating your application in the DWCJ is simple -  use our extensive library of feature-rich and robust components to
                start building your application with a few lines of code.
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
    application.setText(Assets.contentOf("public/pages/home/code/counter/Application.java"));

    // 2 Result
    // =================
    Div result = new Div();
    sample.add(result);
    result.addClassName("javalandSample__result javalandSample__result--center");

    Label title = new Label(/* html */"""
        <html>
          <h3 style="margin: 0">Simple Counter</h3>
        </html>
        """);
    title.setStyle("white-space", "normal");
    result.add(title);

    Label text = new Label("Count: 0");
    result.add(text);

    Button button = new Button("Counter");
    result.add(button);
    button.onClick(e -> {
      count++;
      text.setText("Count: " + count);
    });
  }
}
