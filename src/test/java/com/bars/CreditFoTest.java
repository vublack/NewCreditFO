package com.bars;

import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreditFoTest {
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();
    public TestRule report = new TextReport();

    @BeforeClass
    public static void setup() {
        timeout = 80000;
        collectionsTimeout = 80000;
        baseUrl = "http://10.10.17.50:8080/barsroot/";
        browser = "ie";
        InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).arch32().setup();
        open("/");
    }
    @Test
    public void kreditFoTest() {
        Calculation calculation = page(Calculation.class);
        NewCreditFoPage newCreditFoPage = page(NewCreditFoPage.class);
        SearchPage searchPage = page(SearchPage.class);
        SwitchWindow switchWindow = page(SwitchWindow.class);
        BriefcaseNewCreditFoPage briefcaseNewCreditFoPage = page(BriefcaseNewCreditFoPage.class);
        LoginPage loginPage = page(LoginPage.class);
        FilterBeforFillingTable filterBeforFillingTable = page(FilterBeforFillingTable.class);
        WorkCreditFoBriefcasePage workCreditFoBriefcasePage = page(WorkCreditFoBriefcasePage.class);
        //Логин
        loginPage.FillLoginForm("absadm01", "qwerty");
        loginPage.Сontinue();
        //Страница поиска
        switchWindow.switchToMainFrame();
        searchPage.h1();
        switchWindow.switchToDefaultContent();

        searchPage.searchFunction("Портфель НОВИХ кредитів ФО");
        switchWindow.switchToMainFrame();
        //Кнопка Новый КД(переключение на окно Нового КД)
        String briefcaseNewKdWindow = getWebDriver().getWindowHandle();
        briefcaseNewCreditFoPage.pressCreateNewKD();
        switchWindow.forceSwitchToWindow(briefcaseNewKdWindow);
        switchWindow.windowMaximize();
        // !!Заполнение полей КД!!
        // Вкладка Параметри КД
        String newKdWindow = getWebDriver().getWindowHandle();
        String numSum = calculation.randomNum();
        newCreditFoPage.fillNumSum(numSum, numSum);
        newCreditFoPage.initiativeButtonClick();
        newCreditFoPage.filterInput("/300465/");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditFoPage.okpoButtonClick();
        newCreditFoPage.filterInputClick();
        newCreditFoPage.filterInput("96281701");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditFoPage.ratesButtonClick();
        newCreditFoPage.filterInputClick();
        newCreditFoPage.filterInput("9999");
        newCreditFoPage.typeOfCredit();
        newCreditFoPage.goalOfCredit();
        newCreditFoPage.productOfCredit1();
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditFoPage.productOfCredit2();
        newCreditFoPage.filterInput("220301");
        //Вкладка Дані про погашення
        String firstPaymentDate = newCreditFoPage.getConclusionDate();
        newCreditFoPage.firstPaymentDate(firstPaymentDate);
        //Вкладка Дод. параметри КД
        newCreditFoPage.creditInsurance();
        newCreditFoPage.filterInput("NO");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditFoPage.updateParameter();
        newCreditFoPage.creditProduct();
        newCreditFoPage.filterInputClick();
        newCreditFoPage.filterInput("2");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditFoPage.updateParameter();
        newCreditFoPage.notary();
        newCreditFoPage.filterInputClick();
        newCreditFoPage.filterInput("2134");
        switchWindow.switchToOldWindow(newKdWindow);
        newCreditFoPage.updateParameter();
        //Нажимаем на кнопку "Зберігти"
        newCreditFoPage.saveButtonClick();
        newCreditFoPage.confirmOfCreditCreate();
        switchWindow.closeWindow(newKdWindow);
        switchWindow.switchToOldWindow(briefcaseNewKdWindow);
        switchWindow.switchToMainFrame();
        briefcaseNewCreditFoPage.pressRefreshBriefcase();
        //Авторизація
        briefcaseNewCreditFoPage.chooseNewCredit(numSum);
        briefcaseNewCreditFoPage.сreditAuthorization("0");
        switchWindow.switchToDefaultContent();

/*
        String numSum = "449";
        String firstPaymentDate = "01/08/2018";
*/
        //Портфель Робочих КД ФО
        searchPage.searchFunction("Портфель РОБОЧИХ кредитів ФО");
        switchWindow.switchToMainFrame();
        //Робота з фільтром
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(numSum);
        filterBeforFillingTable.saveUserFilter(numSum);
        filterBeforFillingTable.deleteUserFilter(numSum);
        filterBeforFillingTable.furtherButtonClick();
        //Портфель Робочих кредитів(Побудава ГПК та Графіку подій по портфелю)
        String workCreditFoBriefcaseWindow = getWebDriver().getWindowHandle();
        workCreditFoBriefcasePage.chooseCredit(numSum);

        workCreditFoBriefcasePage.buildRepaymentSchedule();
        switchWindow.forceSwitchToWindow(workCreditFoBriefcaseWindow);
        switchWindow.windowMaximize();
        String gpkWindow = getWebDriver().getWindowHandle();
        workCreditFoBriefcasePage.getTableName();
        workCreditFoBriefcasePage.matchingSumInGPK(numSum+".00");
        switchWindow.closeWindow(gpkWindow);
        switchWindow.switchToOldWindow(workCreditFoBriefcaseWindow);
        switchWindow.switchToMainFrame();
        workCreditFoBriefcasePage.chooseCredit(numSum);
        workCreditFoBriefcasePage.eventsTimetableOfBriefcaseButton();
        switchWindow.forceSwitchToWindow(workCreditFoBriefcaseWindow);
        switchWindow.windowMaximize();
        workCreditFoBriefcasePage.chooseInterval(firstPaymentDate);
        filterBeforFillingTable.clearFilter();
        filterBeforFillingTable.setUserFilter(numSum);
        filterBeforFillingTable.furtherButtonClick();
        String eventsTimetableWindow = getWebDriver().getWindowHandle();
        workCreditFoBriefcasePage.progressBar();
        workCreditFoBriefcasePage.checkEventsTimetableOfBriefcase(numSum);
        switchWindow.closeWindow(eventsTimetableWindow);
    }
}
