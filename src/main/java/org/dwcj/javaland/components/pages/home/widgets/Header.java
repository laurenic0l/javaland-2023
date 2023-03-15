package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.javaland.components.video.HTMLVideo;

public final class Header extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    Label label = new Label(
        /* html */"""
            <html>
              <div class="home__header">
                <h1 >Dynamic Web Client For Java</h1>
                <p>
                  A robust and flexible framework that can help you deliver a modern and engaging web user interface with ease. <span>In Java</span>.
                </p>
              </div>
            </html>
              """);

    Div card = new Div();
    card.addClassName("card card--video");

    HTMLVideo video = new HTMLVideo();
    video.setSrc("/files/javaland/intro.mp4");
    video.setAutoplay(true);
    video.setLoop(true);
    video.setMuted(true);
    video.setControls(false);
    video.setPlaysInline(true);
    card.add(video);

    panel.add(label, card);
  }
}
