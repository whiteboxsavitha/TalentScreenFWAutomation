package com.talentscreen.base;

import com.talentscreen.util.*;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    public static final Configuration _config;
    public PageDriver d;
    public ExcelUtils excelUtils;
  //  public TruliaUtils TruliaUtils;
    static {
        _config = new Configuration();
    }


    //Rally connection
    public Logger _logger;

    public BaseTest() {
        _logger = Logger.getLogger(BaseTest.class);

    }
    @BeforeSuite
    public void beforeSuite() {
        d = new PageDriver(_config);
        WBy.loadJsonMap(String.format("%s/locators.json", System.getProperty("user.dir")));
        excelUtils = new ExcelUtils();
    }

    @AfterSuite
    public void afterSuite() {

        d.quit();
    }
}
