package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TodayVisits extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    AnimatedCounter counter = new AnimatedCounter("Today's Visits", 78.41);
    counter.setSuffix("K");
    counter.setIcon("eye");
    counter.setTheme(AnimatedCounter.Theme.WARNING);

    panel.add(counter);
  }
}
