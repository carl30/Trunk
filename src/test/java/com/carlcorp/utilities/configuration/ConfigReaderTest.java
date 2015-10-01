/*
 * Copyright (c) 2015 Carl Ho
 */

package com.carlcorp.utilities.configuration;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class ConfigReaderTest {

    private ConfigReader configReader;
    private String fileName;

    @Before
    public void setup() {
        configReader = new ConfigReader();
        this.fileName = "example";
    }

    @Test
    public void loadTraditionalPropertiesTest() {
        Properties properties = configReader.loadAllProperties(fileName);
        Assert.assertFalse(properties.isEmpty());
    }

    @Test
    public void getPropertyByKeyTest() {
        String value = configReader.getPropertyByKey(fileName, "testEntry");
        Assert.assertEquals("test entry text", value);
    }

    @Test
    public void test() {
//       Map temp = configReader.test(fileName, "url");
//        System.out.println("test");
        String str = "url ? a=1 and b=2";
        String[] temp = StringUtils.split(str);
        String[] temp2 = StringUtils.split(StringUtils.deleteWhitespace(str));
        System.out.println("hhh");
    }

}
