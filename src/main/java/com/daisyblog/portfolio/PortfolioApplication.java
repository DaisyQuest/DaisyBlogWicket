package com.daisyblog.portfolio;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class PortfolioApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        super.init();
        getMarkupSettings().setStripWicketTags(true);
        mountPage("/home", HomePage.class);
    }
}

