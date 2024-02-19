package org.dwcj.javaland.components.pages.dashboard.widgets.charts;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dwcj.addons.googlecharts.GoogleChart;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.Paragraph;
import org.dwcj.utilities.Assets;

 public final class LastSales extends Div {

    public LastSales(){
      
    Div card = new Div();
    card.addClassName("chartsWrapper__chart card card--lastSales");

    Paragraph header = new Paragraph();
    header.addClassName("card__header");
    header.setText("Sales Last Quarter");
    card.add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.COLUMN);
    chart.setStyle("width", "100%");

    Map<String, Object> options = new Gson().fromJson(Assets.contentOf("public/charts.json"), new TypeToken<Map<String, Object>>(){}.getType());

    chart.setOptions(options);

    // data [cols, rows]
    List<Object> data = new ArrayList<>();

    // cols
    List<Map<String, String>> cols = new ArrayList<>();
    String[] colNames = new String[] { "Month", "Sales", "Expenses" };
    String[] colTypes = new String[] { "string", "number", "number" };

    for (int i = 0; i < colNames.length; i++) {
      Map<String, String> col = new HashMap<>();
      col.put("label", colNames[i]);
      col.put("type", colTypes[i]);
      cols.add(col);
    }

    data.add(cols);

   //  rows
    for (int i = 0; i < 3; i++) {
      List<Object> row = new ArrayList<>();
      row.add(new DateFormatSymbols().getShortMonths()[i]);
      row.add(Math.random() * 8000);
      row.add(Math.random() * 8000);
      data.add(row);
    }

    chart.setData(data);
    card.add(chart);
    add(card);
    }
}