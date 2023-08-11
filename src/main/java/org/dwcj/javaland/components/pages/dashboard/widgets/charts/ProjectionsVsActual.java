package org.dwcj.javaland.components.pages.dashboard.widgets.charts;

import java.text.DateFormatSymbols;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.dwcj.addons.googlecharts.GoogleChart;
import org.dwcj.component.AbstractComponent;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.utilities.Assets;

public final class ProjectionsVsActual extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {

    Panel card = new Panel();
    card.addClassName("chartsWrapper__chart card card--projectionsVsActualsChart");

    Label header = new Label();
    header.addClassName("card__header");
    header.setText("Projections Vs Actual");
    card.add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.COMBO);
    chart.setStyle("width", "100%");

    JsonObject options = new Gson().fromJson(Assets.contentOf("public/charts.json"), JsonObject.class);
    chart.setOptions(options);

    // data [cols, rows]
    JsonArray data = new JsonArray();

    // cols
    JsonArray cols = new JsonArray();
    String[] colNames = new String[] { "Month", "Sales" , "Rate" };

    for (int i = 0; i < colNames.length; i++) {
      JsonObject col = new JsonObject();
      col.addProperty("label", colNames[i]);
      cols.add(col);
    }

    data.add(cols);

    // rows
    for (int i = 0; i < 6; i++) {
      JsonArray row = new JsonArray();
      row.add(new DateFormatSymbols().getShortMonths()[i + 6]);
      row.add(Math.random() * 1000);
      row.add(Math.random() * 1000);
      data.add(row);
    }

    chart.setData(data);
    card.add(chart);

    panel.add(card);
  }
}
