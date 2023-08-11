package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.AbstractComponent;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TodayVisits extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {


    AnimatedCounter counter = new AnimatedCounter("Today's Visits", 78.41);
    counter.setSuffix("K");
    counter.setIcon("eye");
    counter.setTheme(AnimatedCounter.Theme.WARNING);

    panel.add(counter);
  }
}
