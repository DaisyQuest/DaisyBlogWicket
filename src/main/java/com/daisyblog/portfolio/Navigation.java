package com.daisyblog.portfolio;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.CssResourceReference;

public class Navigation extends Panel {
    private static final CssResourceReference NAV_CSS =
        new CssResourceReference(Navigation.class, "nav.css");

    public Navigation(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(NAV_CSS));
    }
}

