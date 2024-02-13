package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.html.elements.Div;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TotalRevenue extends Div {

  public void TotalRevenue() {
    AnimatedCounter counter = new AnimatedCounter("Total Revenue", 5808.947);
    counter.setPrefix("€");
    counter.setIcon("currency-euro");
    counter.setTheme(AnimatedCounter.Theme.PRIMARY);
    add(counter);
  }
}
