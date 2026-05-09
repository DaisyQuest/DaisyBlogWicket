package com.daisyblog.portfolio;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;

public abstract class PortfolioBasePage extends WebPage {
    private static final CssResourceReference PAGE_CSS =
        new CssResourceReference(PortfolioBasePage.class, "page.css");

    protected PortfolioBasePage() {
        add(new Navigation("navigation"));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(PAGE_CSS));
    }
}

