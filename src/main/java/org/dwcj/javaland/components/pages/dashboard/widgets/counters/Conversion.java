package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class Conversion extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    AnimatedCounter counter = new AnimatedCounter("Conversion", .58);
    counter.setSuffix("%");
    counter.setIcon("chart-bar");
    counter.setTheme(AnimatedCounter.Theme.INFO);

    panel.add(counter);
  }
}
