package org.dwcj.javaland.components.pages.home.widgets;


import org.dwcj.addons.code.Code;
import org.dwcj.component.AbstractComponent;
import org.dwcj.component.button.Button;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.utilities.Assets;

public class CounterSample extends AbstractComponent {
  private int count = 0;

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
              <h2>Easy to Start.</h2>
              <p>
                Creating your application in the DWCJ is simple -  use our extensive library of feature-rich and robust components to
                start building your application with a few lines of code.
              </p>
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
    application.setText(Assets.contentOf("public/pages/home/code/counter/Application.java"));

    // 2 Result
    // =================
    Panel result = new Panel();
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
