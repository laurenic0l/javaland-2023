package org.dwcj.javaland.components.pages.dashboard.widgets.charts;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dwcj.addons.googlecharts.GoogleChart;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.Paragraph;
import org.dwcj.utilities.Assets;

public final class LifetimeSales extends Div{

  public LifetimeSales() {
    
    Div card = new Div();
    card.addClassName("chartsWrapper__chart card card--lifetimeSales");

    Paragraph header = new Paragraph();
    header.addClassName("card__header");
    header.setText("Lifetime Sales");
    card.add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.AREA);
    chart.setStyle("width", "100%");

    Map<String, Object> options = new Gson().fromJson(Assets.contentOf("public/charts.json"), new TypeToken<Map<String, Object>>(){}.getType());
     
    chart.setOptions(options);

    // data [cols, rows]
    List<Object> data = new ArrayList<>();
     
    // cols
    List<Map<String, String>> cols = new ArrayList<>();
    String[] colNames = new String[] { "Year", "Sales", "Expenses" };
    String[] colTypes = new String[] { "string", "number", "number" };

    for (int i = 0; i < colNames.length; i++) {
      Map<String, String> col = new HashMap<>();
      col.put("label", colNames[i]);
      col.put("type", colTypes[i]);
      cols.add(col);
    }

    data.add(cols);

    // rows
    for (int i = 0; i < 5; i++) {
      List<Object> row = new ArrayList<>();
      row.add(2018 + i);
      row.add(Math.random() * 8000);
      row.add(Math.random() * 8000);
      data.add(row);
    }

    chart.setData(data);
    card.add(chart);
    add(card);
  }
}