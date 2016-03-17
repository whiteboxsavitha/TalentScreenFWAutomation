package com.talentscreen.pages;

import com.talentscreen.base.BasePage;
import com.talentscreen.util.HtmlElement;
import com.talentscreen.util.PageDriver;

/**
 * Created by Savi on 3/8/2016.
 */
public class LoginPage extends BasePage{
    public LoginPage(PageDriver d) {
        super(d);
    }

    public String performSignIn(String userName,String password, String typeoflg)
    {
        String s = "";
        if (typeoflg.equals("FB"))
        {
            s = performFbSignIn(userName, password);
                return s;
        }
        else if (typeoflg.equals("GH"))
        {
            s = performGitHubSignin(userName, password);
                return s;
        }
        else if (typeoflg.equals("LI"))
        {

            s = performLiSignIn(userName, password);
                return s;
        }
        else if (typeoflg.equals("GP")) {
            s = performGooglePSignin(userName, password);
                return s;
        }
        else if (typeoflg.equals("TW"))
        {
            s = performTweeterSignin(userName, password);
                return s;
        }
        else
        {
            d.getwWindowHandles(false);

            d.findElement("input.login").sendKeys(userName);
            d.findElement("login.pw").sendKeys(password);
            d.findElement("xpath=login.submit").click();
    //        d.waitForLoad();
            try {
                d.implicitWait();
            } catch (Exception e) {
                e.printStackTrace();
            }

            boolean a = d.findElement("login.text").isDisplayed();
            if (a == true)
                return "View public profile";
            else
                return "no match";

/*
            HtmlElement a = d.findElement("login.text");
            s = a.getText();
            return s;
*/
        }
}

    //FaceBook
    public String performFbSignIn(String userName,String password)
    {
            d.getwWindowHandles(false);
            d.findElement("fb.login").click();
            d.getwWindowHandles(false);
            d.waitForLoad();
            d.findElement("fb.un").sendKeys(userName);
            d.findElement("fb.pw").sendKeys(password);
            d.findElement("fb.submit").click();

            d.getwWindowHandles(false);
        try {
            d.implicitWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
            boolean a = d.findElement("xpath=fb.confirm").isDisplayed();
            if (a == true)
                return "View public profile";
            else
                return "no match";
        }

    //LinkedIn
    public String performLiSignIn(String userName,String password)
    {
            d.getwWindowHandles(false);
            d.findElement("ll.login").click();
            d.getwWindowHandles(false);
            d.findElement("ll.un").sendKeys(userName);
            d.findElement("ll.pw").sendKeys(password);
            d.findElement("ll.submit").click();
            d.getwWindowHandles(false);
        try {
            d.implicitWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean a = d.findElement("ll.confirm").isDisplayed();
        System.out.print(a);
        if (a == true)
            return "View public profile";
        else
            return "no match";
    }

    //GitHub
    public String performGitHubSignin(String userName,String password)
    {
        d.getwWindowHandles(false);

        d.findElement("gh.login").click();
        d.getwWindowHandles(false);
        d.findElement("gh.un").sendKeys(userName);
        d.findElement("gh.pw").sendKeys(password);
        d.findElement("gh.submit").click();
        try {
            d.implicitWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean a = d.findElement("xpath=gh.confirm").isDisplayed();
        if (a == true)
          return "View public profile";
        else
            return "no match";
    }

    //Google+
    public String performGooglePSignin(String userName,String password)
    {
        d.getwWindowHandles(false);
        d.findElement("gp.login").click();
        d.getwWindowHandles(false);
        d.findElement("gp.un").sendKeys(userName);
        d.findElement("gp.next").click();
        d.findElement("gp.pw").sendKeys(password);
        d.findElement("xpath=gp.submit").click();
        d.getwWindowHandles(false);
        try {
            d.implicitWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean a = d.findElement("gp.confirm").isDisplayed();
        if (a == true)
            return "View public profile";
        else
            return "no match";
    }

    //Twitter
    public String performTweeterSignin(String userName,String password)
    {

        d.getwWindowHandles(false);
        d.findElement("xpath=tw.login").click();
        d.getwWindowHandles(false);
        d.waitForLoad();
        d.findElement("tw.un").sendKeys(userName);
        d.findElement("tw.pw").sendKeys(password);
        d.findElement("tw.submit").click();
        d.getwWindowHandles(false);
        try {
            d.implicitWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean a = d.findElement("login.text").isDisplayed();
        if (a == true)
            return "View public profile";
        else
            return "no match";
    }

    //Logout
    public void Logout()
    {
          d.findElement("xpath=logout.button").click();
     }
}
