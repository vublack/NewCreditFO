package com.bars;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BriefcaseNewCreditFoPage {
    public void pressCreateNewKD() {
        $("a[data-qtip='КП: Введення Нового КД']").shouldBe(Condition.visible).click();
    }
    public void pressRefreshBriefcase(){
        $(byXpath("//span[@class='x-btn-icon-el x-tbar-loading ']")).shouldBe(visible).click();
        $(byXpath("//*[@class = 'x-mask-msg-text']")).shouldNotBe(visible);
    }
    public void chooseNewCredit(String NumberOfCredit){
        String pathOfNumberOfCredit = String.format( "//*[text()='ФЛ стандарт']/preceding::*[text()='%s']", NumberOfCredit);
        $(byXpath(pathOfNumberOfCredit)).shouldBe(visible).click();
    }
    public void сreditAuthorization(String autorizationType){
        $(byXpath("//a[@data-qtip='КД: Авторизація КД']")).shouldBe(visible).click();
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Так']")).shouldBe(visible).click();
        $(byXpath("//input[@name='M']")).shouldBe(visible).setValue(autorizationType);
        $(byXpath("(//*[@class= 'x-btn-inner x-btn-inner-center'])[text()='Виконати']")).shouldBe(visible).click();
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='OK']")).shouldBe(visible).click();
    }
}
