package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.AbstractComponent;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TodaySales extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {

    AnimatedCounter counter = new AnimatedCounter("Today's Sales", 180);
    counter.setPrefix("€");
    counter.setIcon("shopping-cart");
    counter.setTheme(AnimatedCounter.Theme.SUCCESS);

    panel.add(counter);
  }
}
