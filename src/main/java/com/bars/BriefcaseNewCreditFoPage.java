package com.bars;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

class BriefcaseNewCreditFoPage {
    void pressCreateNewKD() {
        $("a[data-qtip='КП: Введення Нового КД']").shouldBe(Condition.visible).click();
    }
    void pressRefreshBriefcase(){
        $(byXpath("//span[@class='x-btn-icon-el x-tbar-loading ']")).shouldBe(visible).click();
        $(byXpath("//*[@class = 'x-mask-msg-text']")).shouldNotBe(visible);
    }
    void chooseCredit(String creditType, String refCredit){
        $(byXpath("//*[text()='"+creditType+"']/preceding::*[text()='"+refCredit+"']")).shouldBe(visible).click();
    }
    void сreditAuthorization(String autorizationType){
        $(byXpath("//a[@data-qtip='КД: Авторизація КД']")).shouldBe(visible).click();
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Так']")).shouldBe(visible).click();
        $(byXpath("//input[@name='M']")).shouldBe(visible).setValue(autorizationType);
        $(byXpath("(//*[@class= 'x-btn-inner x-btn-inner-center'])[text()='Виконати']")).shouldBe(visible).click();
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='OK']")).shouldBe(visible).click();
    }
}
