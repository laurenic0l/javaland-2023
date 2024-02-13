package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.component.html.elements.Div;
import org.dwcj.javaland.components.video.HTMLVideo;

public final class Header extends Div {

  public Header() {

    Div label = new Div();
    label.setHtml(
        /* html */"""
            <html>
              <Div class="home__header">
                <h1 >Dynamic Web Client For Java</h1>
                <p>
                  A robust and flexible framework that can help you deliver a modern and engaging web user interface with ease. <span>In Java</span>.
                </p>
              </Div>
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
    video.setPreload(true);
    card.add(video);

    add(label, card);
  }
}
