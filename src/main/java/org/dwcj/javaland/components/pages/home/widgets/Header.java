package org.dwcj.javaland.components.pages.home.widgets;

import org.dwcj.component.AbstractComponent;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.javaland.components.video.HTMLVideo;

public final class Header extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {

    Label label = new Label(
        /* html */"""
            <html>
              <Panel class="home__header">
                <h1 >Dynamic Web Client For Java</h1>
                <p>
                  A robust and flexible framework that can help you deliver a modern and engaging web user interface with ease. <span>In Java</span>.
                </p>
              </Panel>
            </html>
              """);

    Panel card = new Panel();
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

    panel.add(label, card);
  }
}
