package org.dwcj.javaland.components.themeswitcher;


import org.dwcj.annotation.Attribute;
import org.dwcj.annotation.InlineJavaScript;
import org.dwcj.component.webcomponent.WebComponent;
import org.dwcj.component.webcomponent.annotation.NodeName;

@NodeName("theme-switcher")
@InlineJavaScript(id = "theme-switcher", value = "context://public/components/themeswitcher/theme-switcher.js", attributes = {
    @Attribute(name = "type", value = "module")
})
public final class ThemeSwitcher extends WebComponent {
}
