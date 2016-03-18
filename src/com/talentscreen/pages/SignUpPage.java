package com.talentscreen.pages;

import com.talentscreen.base.BasePage;
import com.talentscreen.util.HtmlElement;
import com.talentscreen.util.PageDriver;
import org.openqa.selenium.Alert;

/**
 * Created by Savi on 3/11/2016.
 */
public class SignUpPage extends BasePage {
    public SignUpPage(PageDriver d) {
        super(d);
    }
    public String performStudentSignUp(String userName, String password, String confirmPassword)
    {
        d.findElement("signup.button").click();
        d.waitForLoad();
        try {
            d.implicitWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        d.findElement("signup.un").sendKeys(userName);
        d.waitForLoad();
        d.findElement("input.password").sendKeys(password);
        d.findElement("input.confirmpw").sendKeys(confirmPassword);
        d.findElement("xpath=checkbox.employer").click();
        d.findElement("xpath=terms.condition").click();
        d.findElement("xpath=create.account.btn").click();
        Alert a = d.getAlert();
        String s = a.getText();
     //   d.waitForLoad();
        a.accept();
//        a=d.getAlert();
        d.getwWindowHandles(false);
        String sw =  d.getMainWindowHandler();
        d.findElement("xpath=activate.email").click();
        a=d.getAlert();
        String activatied= a.getText();
        a.accept();
        return activatied;
    }

    public String performEmployeeSignup(String userName, String password, String confirmPassword)
    {
        d.waitForLoad();

        d.findElement("signup.button").click();
        d.waitForLoad();
        try {
            d.implicitWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        d.findElement("signup.un").sendKeys(userName);
        d.findElement("input.password").sendKeys(password);
        d.findElement("input.confirmpw").sendKeys(confirmPassword);
        //d.findElement("xpath=checkbox.employer").click();
        d.findElement("xpath=terms.condition").click();
        d.findElement("xpath=create.account.btn").click();

        Alert a = d.getAlert();
        String s = a.getText();
        a.accept();
        return s;
    }

   /* public boolean activationEmailSent()
    {

    }*/
}