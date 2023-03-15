package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TodaySales extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    AnimatedCounter counter = new AnimatedCounter("Today's Sales", 180);
    counter.setPrefix("€");
    counter.setIcon("shopping-cart");
    counter.setTheme(AnimatedCounter.Theme.SUCCESS);

    panel.add(counter);
  }
}
