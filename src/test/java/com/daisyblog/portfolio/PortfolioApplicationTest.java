package com.daisyblog.portfolio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PortfolioApplicationTest {
    private WicketTester tester;

    @BeforeEach
    void setUp() {
        tester = new WicketTester(new PortfolioApplication());
    }

    @AfterEach
    void tearDown() {
        tester.destroy();
    }

    @Test
    void homePageRenders() {
        tester.startPage(HomePage.class);

        tester.assertRenderedPage(HomePage.class);
        tester.assertContains("Personal Portfolio");
        tester.assertContains("A small Wicket 10 application running on TomEE 10 Plus.");
    }

    @Test
    void basePageIncludesNavigationComponent() {
        tester.startPage(HomePage.class);

        tester.assertComponent("navigation", Navigation.class);
        tester.assertContains("Home");
        tester.assertContains("Portfolio");
        tester.assertContains("Blog");
        tester.assertContains("Contact");
    }

    @Test
    void stylesheetsAreContributedThroughWicketHeaderRendering() {
        tester.startPage(HomePage.class);

        String response = tester.getLastResponseAsString();
        assertTrue(response.contains("com.daisyblog.portfolio.PortfolioBasePage/page-"), response);
        assertTrue(response.contains("com.daisyblog.portfolio.Navigation/nav-"), response);
    }
}
