package org.dwcj.javaland.components.themeswitcher;

import org.dwcj.annotations.Attribute;
import org.dwcj.annotations.InlineJavaScript;
import org.dwcj.webcomponent.WebComponent;
import org.dwcj.webcomponent.annotations.NodeName;

@NodeName("theme-switcher")
@InlineJavaScript(id = "theme-switcher", value = "context://public/components/themeswitcher/theme-switcher.js", attributes = {
    @Attribute(name = "type", value = "module")
})
public final class ThemeSwitcher extends WebComponent {
}
