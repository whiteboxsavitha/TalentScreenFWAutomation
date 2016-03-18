package com.talentscreen.test;

import com.talentscreen.pages.SignUpPage;

import com.talentscreen.base.BaseTest;
import com.talentscreen.util.HtmlElement;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
/**
 * Created by Savi on 3/11/2016.
 */
public class SignUpTest extends BaseTest{

    private SignUpPage _ssup;
    private String sheetName;

    @BeforeTest
    @Parameters({"sheetName"})
    public void beforeClass(String sheetName) {
        _ssup= new SignUpPage(d);
        this.sheetName = sheetName;
    }

    @DataProvider(name = "users-data")
    public Object[][] getUsers() throws Exception {
        Object[][] data = excelUtils.getSimpleExcelData(d._configuration.DataFileName,sheetName);
        return data;
    }

    @Test(dataProvider = "users-data", enabled = true, groups = "Positive Test")
    public void SignupTest(String uname,String pwd, String confirmPw)throws IOException
    {
         String output = _ssup.performStudentSignUp(uname, pwd, confirmPw);
         assertEquals(output, "hi this active email");

    }
}