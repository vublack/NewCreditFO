package com.bars;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.StringContains.containsString;

public class WorkCreditFoBriefcasePage {

    public void chooseCredit(String numCredit){
        String searchRowByNum = String.format("//*[text()='ФЛ стандарт']/preceding::*[text()='%s']", numCredit);
        $(By.xpath(searchRowByNum)).shouldBe(visible).click();
    }
    public void buildRepaymentSchedule(){
        $(By.xpath("//a[@data-qtip='КД: Побудова ГПК для обраного КД']")).shouldBe(visible).click();
    }
    public void getTableName(){
        System.out.println($("#mainReferenceGrid_header_hd").shouldBe(visible).getText());
    }
    public void matchingSumInGPK(String sumCredit){
        String repaymentOfDebt = $(By.xpath("(//tfoot/tr/td/div)[6]")).shouldBe(visible).shouldHave(text(sumCredit)).getText();
        System.out.println("Сума погашення осн. боргу: " + repaymentOfDebt);
    }
    public void eventsTimetableOfBriefcaseButton(){
        $(By.xpath("//a[@data-qtip='КП: Графік подій по портфелю']")).shouldBe(visible).click();
    }
    public void chooseInterval(String day){
        $(By.xpath("//input[@name ='B']")).shouldBe(visible).setValue(day);
        $(By.xpath("//input[@name ='E']")).shouldBe(visible).setValue(day);
        $(By.xpath("(//*[@class= 'x-btn-inner x-btn-inner-center'])[text()='Виконати']")).shouldBe(visible).click();
    }
    public void progressBar(){
        $(By.xpath("//*[@class = 'x-mask-msg-text']")).shouldNotBe(visible);
    }
    public void checkEventsTimetableOfBriefcase(String expectedNum){
        List<SelenideElement> eventsTimetable = $$(By.xpath("//div[@class='x-grid-cell-inner ']")).filter(visible).shouldHaveSize(54);
        List<String> eventsTimetableList = eventsTimetable.stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat("None of elements contains sub-string", eventsTimetableList, hasItem(containsString(expectedNum)));
        System.out.println("Графік подій по портфелю" + eventsTimetableList);
    }
}
