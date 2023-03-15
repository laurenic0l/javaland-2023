package org.dwcj.javaland.components.video;

import org.dwcj.webcomponent.PropertyDescriptor;
import org.dwcj.webcomponent.WebComponent;
import org.dwcj.webcomponent.annotations.NodeName;

/**
 * A wrapper for the HTML video element
 *
 * @see <a href=
 *      "https://developer.mozilla.org/en-US/docs/Web/HTML/Element/video">HTML
 *      video element</a>
 */
@NodeName("video")
public final class HTMLVideo extends WebComponent {

  // Properties
  private final PropertyDescriptor<String> SRC = PropertyDescriptor.property("src", "");
  private final PropertyDescriptor<Boolean> AUTOPLAY = PropertyDescriptor.property("autoplay", false);
  private final PropertyDescriptor<Boolean> CONTROLS = PropertyDescriptor.property("controls", false);
  private final PropertyDescriptor<Boolean> LOOP = PropertyDescriptor.property("loop", false);
  private final PropertyDescriptor<Boolean> MUTE = PropertyDescriptor.property("muted", false);
  private final PropertyDescriptor<Boolean> PLAYSINLINE = PropertyDescriptor.property("playsinline", false);

  /**
   * Set the video src
   *
   * @param src the video src
   * @return this
   */
  public HTMLVideo setSrc(String src) {
    set(SRC, src);
    return this;
  }

  /**
   * Get the video src
   *
   * @return the video src
   */
  public String getSrc() {
    return get(SRC);
  }

  /**
   * Set the autoplay
   *
   * @param autoplay the autoplay
   * @return this
   */
  public HTMLVideo setAutoplay(boolean autoplay) {
    set(AUTOPLAY, autoplay);
    return this;
  }

  /**
   * Check if the video will autoplay
   *
   * @return the autoplay
   */
  public boolean isAutoPlay() {
    return get(AUTOPLAY);
  }

  /**
   * When then the browser will offer controls to allow the user to control video
   * playback
   *
   * @param controls true to show the controls, false otherwise
   * @return this
   */
  public HTMLVideo setControls(boolean controls) {
    set(CONTROLS, controls);
    return this;
  }

  /**
   * Check if the browser will offer controls to allow the user to control video
   * playback
   *
   * @return the controls
   */
  public boolean isControls() {
    return get(CONTROLS);
  }

  /**
   * When true the video will automatically start over when it ends
   *
   * @param loop the loop
   * @return this
   */
  public HTMLVideo setLoop(boolean loop) {
    set(LOOP, loop);
    return this;
  }

  /**
   * Check if the video will automatically start over when it ends
   *
   * @return the loop
   */
  public boolean isLoop() {
    return get(LOOP);
  }

  /**
   * When true the video will be muted
   *
   * @param mute the mute
   * @return this
   */
  public HTMLVideo setMuted(boolean mute) {
    set(MUTE, mute);
    return this;
  }

  /**
   * Check if the video will be muted
   *
   * @return the mute
   */
  public boolean isMuted() {
    return get(MUTE);
  }

  /**
   * When true the video will be played inline, that is within the element's
   * playback area
   *
   * @param playsinline the playsinline
   * @return this
   */
  public HTMLVideo setPlaysInline(boolean playsinline) {
    set(PLAYSINLINE, playsinline);
    return this;
  }

  /**
   * Check if the video will be played inline, that is within the element's
   * playback area
   *
   * @return the playsinline
   */
  public boolean isPlaysInline() {
    return get(PLAYSINLINE);
  }
}
