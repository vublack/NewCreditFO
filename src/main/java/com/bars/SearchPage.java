package com.bars;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    public void h1() {
        $(By.tagName("h1")).shouldHave(text("Оголошення"));
    }

    public void searchFunction(String functionName) {
        $("#findOpersText").shouldBe(visible).setValue(functionName).pressEnter();
        String Opername = String.format("//*[@class='oper-name']/span[text()='%s']", functionName);
        $(By.xpath(Opername)).shouldBe(visible).click();
    }
}
