package org.dwcj.javaland.components.pages.dashboard;

import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.javaland.components.pages.dashboard.widgets.TopSelling;
import org.dwcj.javaland.components.pages.dashboard.widgets.charts.LastSales;
import org.dwcj.javaland.components.pages.dashboard.widgets.charts.LifetimeSales;
import org.dwcj.javaland.components.pages.dashboard.widgets.charts.ProjectionsVsActual;
import org.dwcj.javaland.components.pages.dashboard.widgets.charts.RevenueLocation;
import org.dwcj.javaland.components.pages.dashboard.widgets.counters.Conversion;
import org.dwcj.javaland.components.pages.dashboard.widgets.counters.TodaySales;
import org.dwcj.javaland.components.pages.dashboard.widgets.counters.TotalRevenue;
import org.dwcj.javaland.components.pages.dashboard.widgets.inbox.Inbox;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.Todo;


@InlineStyleSheet(id = "javaland-page-dashboard", value = "context://public/pages/dashboard.css", once = true)
public final class Dashboard extends Panel {

  @Override
  protected void create(AbstractWindow p) {
    setVisible(false);
    super.create(p);
    addClassName("page page--dashboard");

    Panel counters = new Panel();
    counters.addClassName("countersWrapper");
    counters.add(new TotalRevenue());
    counters.add(new TodaySales());
    counters.add(new Conversion());

    Panel quarterCharts = new Panel();
    quarterCharts.addClassName("chartsWrapper");
    quarterCharts.add(new LastSales());
    quarterCharts.add(new RevenueLocation());

    Panel lifeTimeCharts = new Panel();
    lifeTimeCharts.addClassName("chartsWrapper");
    lifeTimeCharts.add(new LifetimeSales());
    lifeTimeCharts.add(new ProjectionsVsActual());

    Panel apps = new Panel();
    apps.addClassName("appsWrapper");
    apps.add(new Todo());
    apps.add(new Inbox());

    add(
        counters,
        quarterCharts,
        new TopSelling(),
        lifeTimeCharts,
        apps);

    setVisible(true);
  }
}
