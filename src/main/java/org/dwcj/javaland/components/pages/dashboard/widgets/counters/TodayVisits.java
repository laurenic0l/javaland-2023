package org.dwcj.javaland.components.pages.dashboard.widgets.counters;

import org.dwcj.component.html.elements.Div;
import org.dwcj.javaland.components.animatedcounter.AnimatedCounter;

public final class TodayVisits extends Div {

  public TodayVisits( ) {
    AnimatedCounter counter = new AnimatedCounter("Today's Visits", 78.41);
    counter.setSuffix("K");
    counter.setIcon("eye");
    counter.setTheme(AnimatedCounter.Theme.WARNING);
    add(counter);
  }
}
