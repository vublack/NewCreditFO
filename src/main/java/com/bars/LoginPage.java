package com.bars;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void FillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
        }
    public void Сontinue(){
        $(By.xpath("//input[@value = 'Продовжити']")).shouldBe(visible).click();
        }
}
