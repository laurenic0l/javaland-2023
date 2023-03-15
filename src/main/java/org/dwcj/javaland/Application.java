package org.dwcj.javaland;

import org.dwcj.App;
import org.dwcj.annotations.AppAttribute;
import org.dwcj.annotations.AppTheme;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

@AppAttribute(name = "lang", value = "en")
@AppTheme("system")
public final class Application extends App {

  @Override
  public void run() throws DwcException {

    AppPanel window = new AppPanel();
    window.setText("Dynamic Web Client for Java");

    Shell shell = new Shell();
    shell.setTitle(getPage().getTitle());

    window.add(shell);
  }
}
