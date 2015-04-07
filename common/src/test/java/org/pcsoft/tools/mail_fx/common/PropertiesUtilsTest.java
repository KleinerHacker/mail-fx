package org.pcsoft.tools.mail_fx.common;

import org.junit.Assert;
import org.junit.Test;
import org.pcsoft.tools.mail_fx.utils.PropertiesUtils;

import java.util.Properties;

/**
 * Created by Christoph on 15.11.2014.
 */
public class PropertiesUtilsTest {

    @Test
    public void testPropertiesToString() {
        final Properties properties = new Properties();
        properties.put("Hello", "World");
        properties.put("What", "is");
        properties.put("One", "goal");

        Assert.assertEquals("One=goal,What=is,Hello=World", PropertiesUtils.toString(properties));
    }

    @Test
    public void testPropertiesParse() {
        final String propString = "One=goal,What=is,Hello=World";
        final Properties properties = PropertiesUtils.parseProperties(propString);

        Assert.assertTrue(properties.containsKey("One"));
        Assert.assertEquals("goal", properties.getProperty("One"));
        Assert.assertTrue(properties.containsKey("What"));
        Assert.assertEquals("is", properties.getProperty("What"));
        Assert.assertTrue(properties.containsKey("Hello"));
        Assert.assertEquals("World", properties.getProperty("Hello"));
    }

    @Test
    public void testPropertiesConversion() {
        final Properties properties = new Properties();
        properties.put("Hello", "World");
        properties.put("What", "is");
        properties.put("One", "goal");

        final String propString = PropertiesUtils.toString(properties);
        final Properties parseProperties = PropertiesUtils.parseProperties(propString);

        Assert.assertEquals(properties, parseProperties);
    }
}
