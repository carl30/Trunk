/*
 * Copyright (c) 2015 Carl Ho
 */

package com.carlcorp.utilities.configuration;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public final class ConfigReader {

    private static Logger logger = LogManager.getLogger(ConfigReader.class.getName());
    private final String CONFIG_BASIC_PATH = "src/main/java/com/carlcorp/configuration/example/";
    private final String CONFIG_FILE_EXTENSION = ".properties.xml";

    public ConfigReader() {
    }

    public Properties loadAllProperties(final String fileName) {
        final Properties properties = new Properties();
        if (StringUtils.isBlank(fileName)) {
            logger.warn("File name is blank.");
            //TODO: Throw a exception
            return null;
        }
        try {
            final FileInputStream in = new FileInputStream(CONFIG_BASIC_PATH + fileName + CONFIG_FILE_EXTENSION);
            properties.loadFromXML(in);
            in.close();
        } catch (FileNotFoundException fnfEx) {
            logger.error("File not found: " + ConfigReader.class.getName(), fnfEx);
        } catch (Exception ex) {
            logger.error("Exception: " + ConfigReader.class.getName(), ex);
        }
        return properties;
    }

    public String getPropertyByKey(final String fileName, String key2Find) {
        final Properties properties = loadAllProperties(fileName);
        if (properties != null) {
            return properties.getProperty(assembleTheKeyStr(key2Find, null, null));
        } else {
            return null;
        }
    }

    public String getPropertyByKeyAndParam(final String fileName, String key2Find, String param1) {
        final Properties properties = loadAllProperties(fileName);
        if (properties != null) {
            return properties.getProperty(assembleTheKeyStr(key2Find, param1, null));
        } else {
            return null;
        }
    }

    public String getPropertyByKeyAndParams(final String fileName, String key2Find, String param1, String param2) {
        final Properties properties = loadAllProperties(fileName);
        if (properties != null) {
            String valueStr = properties.getProperty(assembleTheKeyStr(key2Find, param1, param2));
            if (valueStr != null) {
                return valueStr;
            } else {
                return properties.getProperty(assembleTheKeyStr(key2Find, param2, param1));
            }
        } else {
            return null;
        }
    }

    private String assembleTheKeyStr(String key2Find, String param1, String param2) {
        if (param1 == null && param2 == null) {
            return key2Find;
        } else if (param1 == null) {
            return key2Find + " ? " + param2;
        } else if (param2 == null) {
            return key2Find + " ? " + param1;
        } else {
            return key2Find + " ? " + param1 + " and " + param2;
        }
    }

}
