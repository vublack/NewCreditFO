package com.bars;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FilterBeforFillingTable {
    public void clearFilter(){
        $(byXpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Скасувати фільтри']")).shouldBe(visible).click();
    }
    public void setUserFilter(String externalCreditNumber){
        $(byXpath("(//*[@class='x-tab-inner x-tab-inner-center'])[text()='Звичайні']")).shouldBe(visible).click();
        $(byXpath("//input[@name='CC_ID']")).shouldBe(visible).setValue(externalCreditNumber);
    }
    public void saveUserFilter(String filterName){
        $(byXpath("(//*[@class='x-btn-icon-el save_brown '])[2]")).shouldBe(visible).click();
        $(byXpath("//*[@name='filterName']")).shouldBe(visible).setValue(filterName);
        $(byXpath("(//*[text()='Зберегти']/following-sibling::*[@class='x-btn-icon-el save '])[2]")).shouldBe(visible).click();
        $(byXpath("//*[text()='Фільтр успішно додано']/following::*[text()='OK']")).shouldBe(visible).click();
    }

    public void deleteUserFilter(String CooseRowByFilterName){
        $(byXpath("(//*[@class='x-tab-inner x-tab-inner-center'])[text()='Користувача']")).shouldBe(visible).click();
        String searchRowByFilterName = String.format("(//*[@class='x-grid-cell-inner '])[text()='%s']", CooseRowByFilterName);
        $(By.xpath(searchRowByFilterName)).shouldBe(visible).click();
        $(By.xpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Видалити']")).shouldBe(visible).click();
        $(By.xpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Так']")).shouldBe(visible).click();
        $(By.xpath("//*[text()='Рядок успішно видалено']")).shouldBe(visible).click();
        $(By.xpath("//*[@class='x-tool x-box-item x-tool-default x-tool-before-title']")).shouldBe(visible).click();
    }
    public void furtherButtonClick(){
        $(By.xpath("(//*[@class='x-btn-inner x-btn-inner-center'])[text()='Далі']")).shouldBe(visible).click();
    }
}
