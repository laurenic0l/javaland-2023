package org.dwcj.javaland.components.pages.dashboard.widgets.charts;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.dwcj.addons.googlecharts.GoogleChart;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.Paragraph;
import org.dwcj.utilities.Assets;

public final class RevenueLocation extends Div {

  public RevenueLocation() {
    
    Div card = new Div();
    card.addClassName("chartsWrapper__chart card card--revenueLocation");

    Paragraph header = new Paragraph();
    header.addClassName("card__header");
    header.setText("Revenue By Location");
    card.add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.GEO);
    chart.setStyle("width", "100%");

    // options
    Map<String, Object> options = new Gson().fromJson(Assets.contentOf("public/charts.json"), new TypeToken<Map<String, Object>>(){}.getType());
    options.put("legend", "none");
    chart.setOptions(options);

    // data [cols, rows]
    List<Object> data = new ArrayList<>();

    // cols
    List<String> cols = new ArrayList<>();
    cols.add("Country");
    cols.add("Revenue");
    data.add(cols);

    String[] countries = new String[] { "Germany", "United States", "Brazil", "Canada", "France", "RU" };
    // rows
    for (String country : countries) {
      List<Object> row = new ArrayList<>();
      row.add(country);
      row.add(Math.random() * 10000);
      data.add(row);
    }

    chart.setData(data);
    card.add(chart);
    add(card);
  }
}

