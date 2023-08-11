package org.dwcj.javaland;

import org.dwcj.App;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

//@AppAttribute(name = "lang", value = "en")
//@AppTheme("system")
public final class Application extends App {

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame window = new Frame();
    window.setText("Dynamic Web Client for Java");
    Shell shell = new Shell();
    shell.setTitle(getPage().getTitle());

    window.add(shell);
  }
}
