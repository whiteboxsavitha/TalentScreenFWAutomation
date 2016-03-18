package com.talentscreen.test;

import com.talentscreen.base.BaseTest;
import com.talentscreen.pages.LoginPage;
import com.talentscreen.util.PageDriver;
import org.junit.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Savi on 3/7/2016.
 */
public class LoginTest extends BaseTest
{
    private LoginPage _sl;
    private String sheetName;
    private String Signin = "";

    @BeforeClass
    @Parameters({"sheetName"})
    public void beforeClass(String sheetName)
    {
         this.sheetName = sheetName;
    }

    @AfterTest
    public void close()
    {
        d.close();
    }

    @DataProvider(name = "users-data")
    public Object[][] getUsers() throws Exception
    {
        Object[][] data = excelUtils.getSimpleExcelData(d._configuration.DataFileName,sheetName);
        return data;
    }

    @Test(dataProvider = "users-data", enabled = true, groups = "Positive Tests")
    public void StudentLoginTest(String uname,String pwd, String typeoflg)throws IOException
    {
            _sl= new LoginPage(d);
            Signin = _sl.performSignIn(uname, pwd, typeoflg);
            assertEquals(Signin, "View public profile");
            _sl.Logout();
    }
}
