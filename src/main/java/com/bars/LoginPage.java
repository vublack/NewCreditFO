package com.bars;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

class LoginPage {

    void fillLoginForm(String login, String password) {
        $("#txtUserName").setValue(login);
        $("#txtPassword").setValue(password).pressEnter();
        }
    void goOn(){
        $(byXpath("//input[@value = 'Продовжити']")).shouldBe(visible).click();
        }
}
