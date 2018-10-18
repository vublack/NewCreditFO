package com.bars;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

class NewCreditFoPage {
    private SwitchWindow switchWindow = page(SwitchWindow.class);
    // Вкладка Параметри КД
    void fillNumSum(String num, String sum){
        $(byXpath("//*[@ng-model='credit.numValue']")).shouldBe(visible).setValue(num);
        $(byXpath("(//*[text()='Початкова сума']/following::*[@class='k-formatted-value k-input'])[1]")).shouldBe(visible).click();
        $(byXpath("//*[@k-ng-model='credit.sumValue']")).setValue(sum);
    }
    void initiativeButtonClick(){
        $(byXpath("//label[text()='Ініціатива']//following-sibling::button")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='BRANCH']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void filterInput(String znach){
        $(byXpath("//input[@data-bind='value:filters[0].value']")).shouldBe(visible).setValue(znach).pressEnter();
    }
    void filterInputClick(){
        $(byXpath("//div[text()='Рядки із записами']/following-sibling::span[@class='k-widget k-numerictextbox']")).shouldBe(visible).click();
    }
    void okpoButtonClick(){
        $(byXpath("//label[text()='OKПO']/preceding::button[@class='pf-icon pf-16 pf-book k-button'][1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='RNK']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void ratesButtonClick(){
        $(byXpath("//input[@id='refBaseNameRate']/preceding-sibling::button")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='BR_ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void typeOfCredit(String creditType){
        $(byXpath("//span[text()='Самостійно залучені кошти']/preceding::span[@class='k-select'][1]")).shouldBe(visible).click();
        String type = String.format("//li[text()='%s']", creditType);
        $(byXpath(type)).shouldBe(visible).click();
}
    void goalOfCredit(String creditGoal){
        $(byXpath("(//*[text()='Продукт']/following::span[@class='k-select'])[1]")).shouldBe(visible).click();
        String goal = String.format("//li[text()='%s']", creditGoal);
        $(byXpath(goal)).shouldBe(visible).click();
    }
    void productOfCredit1(){
        $(byXpath("//input[@id='refProd']/following-sibling::button")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//button[text()='Відмінити']")).shouldBe(visible).click();
    }
    void productOfCredit2(){
        $(byXpath("//input[@id='refProd']/following-sibling::button")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    String getConclusionDate(){
        String conclusionDateOfKD = $(byXpath("//input[@k-ng-model='credit.conslValue']")).getValue();
        System.out.println("firstPaymentDate = " + conclusionDateOfKD);
        return conclusionDateOfKD;
    }
    //Вкладка Дані про погашення
    void firstPaymentDate(String firstDate){
        $(byXpath("//*[text()='Дані про погашення']")).shouldBe(visible).click();
        $(byXpath("//input[@name='tbDayOfPay']/preceding-sibling::input")).shouldBe(visible).setValue("1");
        $(byXpath("//input[@name='dpFirtsPayDate']")).shouldBe(visible).click();
        $(byXpath("//input[@name='dpFirtsPayDate']")).sendKeys(firstDate);
    }
    //Вкладка Дод. параметри КД
        //Основні
    void creditInsurance(){
        $(byXpath("//span[text()='Дод. параметри КД']")).shouldBe(visible).click();
        $(byXpath("(//*[text()='Страхування кредиту']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
        //Додаткові
        void creditProduct(){
        $(byXpath("//span[text()='Додаткові']")).shouldBe(visible).click();
        $(byXpath("(//*[text()='Кредитний продукт']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='CPROD_ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
        // Застава
        void notary(){
        $(byXpath("//span[text()='Застава']")).shouldBe(visible).click();
        $(byXpath("(//*[text()='ПІБ нотаріуса']/following::a)[1]")).shouldBe(visible).click();
        switchWindow.switchToWindow();
        $(byXpath("//th[@data-field='ID']/a[@class='k-grid-filter']")).shouldBe(visible).click();
    }
    void updateParameter(){
        $(byXpath("//a[@class='k-button k-button-icontext k-primary k-grid-update']")).shouldBe(visible).click();
    }
    //Нажимаем на кнопку "Зберігти"
    void saveButtonClick(){
        $(byXpath("//button[@class='k-button k-toolbar-first-visible k-toolbar-last-visible']")).shouldBe(visible).click();
        $(byXpath("//button[@class='k-loading-image']")).shouldNotBe(exist);
    }
    void confirmOfCreditCreate(){
        $(byXpath("//*[contains(text(), 'Створено КД')]")).shouldBe(visible);
        $(byXpath("//button[@class='delete-confirm k-button k-primary']")).shouldBe(visible).click();
    }
    String getREF(){
        return $(By.tagName("h1")).shouldBe(visible).getText().replace("Кредитний договір (", "").replace(")", "");
    }


}
