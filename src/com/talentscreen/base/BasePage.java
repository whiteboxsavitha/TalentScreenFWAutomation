package com.talentscreen.base;

import com.talentscreen.util.PageDriver;
import org.apache.log4j.Logger;


public abstract class BasePage {

    public Logger _logger;
    public PageDriver d;

    public BasePage(PageDriver d) {
        _logger = Logger.getLogger(BasePage.class);
        this.d = d;
    }
    }
