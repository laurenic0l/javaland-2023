package org.dwcj.javaland.components.pages.dashboard.widgets.charts;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.util.Assets;
import org.dwcj.widgets.googlecharts.GoogleChart;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public final class RevenueLocation extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    Div card = new Div();
    card.addClassName("chartsWrapper__chart card card--revenueLocation");

    Label header = new Label();
    header.addClassName("card__header");
    header.setText("Revenue By Location");
    card.add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.GEO);
    chart.setStyle("width", "100%");

    // options
    JsonObject options = new Gson().fromJson(
      Assets.contentOf("public/charts.json"),
      JsonObject.class);
    options.addProperty("legend", "none");
    chart.setOptions(options);

    // data [cols, rows]
    JsonArray data = new JsonArray();

    // cols
    JsonArray cols = new JsonArray();
    cols.add("Country");
    cols.add("Revenue");
    data.add(cols);

    String[] countries = new String[] { "Germany", "United States", "Brazil", "Canada", "France", "RU" };
    // rows
    for (String country : countries) {
      JsonArray row = new JsonArray();
      row.add(country);
      row.add(Math.random() * 10000);
      data.add(row);
    }

    chart.setData(data);
    card.add(chart);

    panel.add(card);
  }
}
