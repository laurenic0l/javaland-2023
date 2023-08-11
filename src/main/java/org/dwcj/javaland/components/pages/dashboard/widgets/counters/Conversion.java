package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.AbstractComponent;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class Conversion extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {

    AnimatedCounter counter = new AnimatedCounter("Conversion", .58);
    counter.setSuffix("%");
    counter.setIcon("chart-bar");
    counter.setTheme(AnimatedCounter.Theme.INFO);

    panel.add(counter);
  }
}
