package org.pcsoft.tools.mail_fx.utils;

import java.util.Properties;

/**
 * Created by Christoph on 15.11.2014.
 */
public final class PropertiesUtils {

    public static String toString(Properties properties) {
        if (properties.size() <= 0)
            return "";

        final StringBuilder sb = new StringBuilder();

        for (final String key : properties.stringPropertyNames()) {
            final String value = properties.getProperty(key);

            sb.append(key).append("=").append(value);
            sb.append(",");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    public static Properties parseProperties(String str) {
        if (str == null || str.trim().isEmpty())
            return new Properties();

        final Properties properties = new Properties();
        final String[] propertyPairs = str.split(",");
        for (final String propertyPair : propertyPairs) {
            final String[] keyValue = propertyPair.split("=");
            if (keyValue.length != 2)
                throw new IllegalArgumentException("Cannot parse to properties: " + str + ": Key Value Pair not found");
            properties.put(keyValue[0], keyValue[1]);
        }

        return properties;
    }

    private PropertiesUtils() {
    }
}
