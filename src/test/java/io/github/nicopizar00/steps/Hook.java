package io.github.nicopizar00.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.nicopizar00.util.Helper;

public class Hook {
    @Before
    public static void setUp() {
        Helper.setUpDriver();
    }

    @After
    public static void tearDown() {
        Helper.tearDown();
    }
}
