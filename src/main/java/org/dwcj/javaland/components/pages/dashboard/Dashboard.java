package org.dwcj.javaland.components.pages.dashboard;

import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.html.elements.Div;
import org.dwcj.javaland.components.pages.dashboard.widgets.TopSelling;
// import org.dwcj.javaland.components.pages.dashboard.widgets.charts.LastSales;
// import org.dwcj.javaland.components.pages.dashboard.widgets.charts.LifetimeSales;
// import org.dwcj.javaland.components.pages.dashboard.widgets.charts.ProjectionsVsActual;
// import org.dwcj.javaland.components.pages.dashboard.widgets.charts.RevenueLocation;
import org.dwcj.javaland.components.pages.dashboard.widgets.counters.Conversion;
import org.dwcj.javaland.components.pages.dashboard.widgets.counters.TodaySales;
import org.dwcj.javaland.components.pages.dashboard.widgets.counters.TotalRevenue;
import org.dwcj.javaland.components.pages.dashboard.widgets.inbox.Inbox;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.Todo;


@InlineStyleSheet(id = "javaland-page-dashboard", value = "context://public/pages/dashboard.css", once = true)
public final class Dashboard extends Div {

  public Dashboard() {
    setVisible(false);
    addClassName("page page--dashboard");

    Div counters = new Div();
    counters.addClassName("countersWrapper");
    counters.add(new TotalRevenue());
    counters.add(new TodaySales());
    counters.add(new Conversion());

    // Div quarterCharts = new Div();
    // quarterCharts.addClassName("chartsWrapper");
    // quarterCharts.add(new LastSales());
    // quarterCharts.add(new RevenueLocation());

    // Div lifeTimeCharts = new Div();
    // lifeTimeCharts.addClassName("chartsWrapper");
    // lifeTimeCharts.add(new LifetimeSales());
    // lifeTimeCharts.add(new ProjectionsVsActual());

    Div apps = new Div();
    apps.addClassName("appsWrapper");
    apps.add(new Todo());
    apps.add(new Inbox());

    add(
        counters,
        // quarterCharts,
        new TopSelling(),
        // lifeTimeCharts,
        apps);

    setVisible(true);
  }
}
