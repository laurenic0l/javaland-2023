package org.dwcj.javaland.components.themeswitcher;


import org.dwcj.annotation.Attribute;
import org.dwcj.annotation.InlineJavaScript;
import org.dwcj.component.element.ElementComposite;
import org.dwcj.component.element.annotation.NodeName;

@NodeName("theme-switcher")
@InlineJavaScript(id = "theme-switcher", value = "context://public/components/themeswitcher/theme-switcher.js", attributes = {
    @Attribute(name = "type", value = "module")
})
public final class ThemeSwitcher extends ElementComposite {
}
