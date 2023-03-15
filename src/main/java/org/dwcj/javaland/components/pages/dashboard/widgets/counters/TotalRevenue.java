package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TotalRevenue extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    AnimatedCounter counter = new AnimatedCounter("Total Revenue", 5808.947);
    counter.setPrefix("€");
    counter.setIcon("currency-euro");
    counter.setTheme(AnimatedCounter.Theme.PRIMARY);

    panel.add(counter);
  }
}
