package com.milley.structure.stack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SampleBrowserTest {
    private SampleBrowser sampleBrowser;

    @Before
    public void init() {
        sampleBrowser = new SampleBrowser();
        sampleBrowser.open("http://www.baidu.com");
        sampleBrowser.open("http://www.sina.com");
        sampleBrowser.open("http://www.163.com");
    }

    @Test
    public void goBackTest() {
        assertEquals("http://www.163.com", sampleBrowser.goBack());
        assertEquals("http://www.sina.com", sampleBrowser.goBack());
        assertFalse(sampleBrowser.canGoBack());
        assertTrue(sampleBrowser.canGoForward());
    }

    @Test
    public void goForwardTest() {
        sampleBrowser.goBack();
        sampleBrowser.goBack();
        sampleBrowser.goForward();
        sampleBrowser.open("http://www.qq.com");
        assertFalse(sampleBrowser.canGoForward());
        sampleBrowser.goForward();
        sampleBrowser.goBack();
        sampleBrowser.goBack();
        assertFalse(sampleBrowser.canGoBack());
    }
}
