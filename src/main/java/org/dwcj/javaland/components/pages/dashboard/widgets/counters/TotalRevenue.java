package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.AbstractComponent;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TotalRevenue extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {

    AnimatedCounter counter = new AnimatedCounter("Total Revenue", 5808.947);
    counter.setPrefix("€");
    counter.setIcon("currency-euro");
    counter.setTheme(AnimatedCounter.Theme.PRIMARY);

    panel.add(counter);
  }
}
