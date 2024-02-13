package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.html.elements.Div;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class Conversion extends Div {

  public Conversion() {

    AnimatedCounter counter = new AnimatedCounter("Conversion", .58);
    counter.setSuffix("%");
    counter.setIcon("chart-bar");
    counter.setTheme(AnimatedCounter.Theme.INFO);
    add(counter);
  }
  // @Override
  // protected void create(AbstractWindow panel) {

  //   AnimatedCounter counter = new AnimatedCounter("Conversion", .58);
  //   counter.setSuffix("%");
  //   counter.setIcon("chart-bar");
  //   counter.setTheme(AnimatedCounter.Theme.INFO);

  //   panel.add(counter);
  // }
}
