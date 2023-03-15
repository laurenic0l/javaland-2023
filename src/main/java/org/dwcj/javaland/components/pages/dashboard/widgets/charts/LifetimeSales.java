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

public final class LifetimeSales extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    Div card = new Div();
    card.addClassName("chartsWrapper__chart card card--lifetimeSales");

    Label header = new Label();
    header.addClassName("card__header");
    header.setText("Lifetime Sales");
    card.add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.AREA);
    chart.setStyle("width", "100%");

    JsonObject options = new Gson().fromJson(Assets.contentOf("public/charts.json"),
        JsonObject.class);
    chart.setOptions(options);

    // data [cols, rows]
    JsonArray data = new JsonArray();

    // cols
    JsonArray cols = new JsonArray();
    String[] colNames = new String[] { "Year", "Sales", "Expenses" };
    String[] colTypes = new String[] { "string", "number", "number" };

    for (int i = 0; i < colNames.length; i++) {
      JsonObject col = new JsonObject();
      col.addProperty("label", colNames[i]);
      col.addProperty("type", colTypes[i]);
      cols.add(col);
    }

    data.add(cols);

    // rows
    for (int i = 0; i < 5; i++) {
      JsonArray row = new JsonArray();
      row.add(2018 + i);
      row.add(Math.random() * 8000);
      row.add(Math.random() * 8000);
      data.add(row);
    }

    chart.setData(data);
    card.add(chart);

    panel.add(card);
  }
}
