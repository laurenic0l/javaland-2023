package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.html.elements.Div;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TodaySales extends Div {

  public TodaySales() {

    AnimatedCounter counter = new AnimatedCounter("Today's Sales", 180);
    counter.setPrefix("€");
    counter.setIcon("shopping-cart");
    counter.setTheme(AnimatedCounter.Theme.SUCCESS);
    add(counter);
  }
}
