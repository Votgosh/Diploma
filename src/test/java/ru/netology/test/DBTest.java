package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.DataBaseHelper;
import ru.netology.page.MainPage;
import ru.netology.page.CreditPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class DBTest {


    @BeforeEach
    void openForTests() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Тест APPROVED карты")
    void shouldCheckValidDebitCard() {
        var validCardInformation = DataHelper.getApprovedCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(validCardInformation);
        debitPage.approved();
        assertEquals("APPROVED", new DataBaseHelper().getPaymentStatus());
        assertEquals(45000, new DataBaseHelper().getPaymentAmount());
        assertNull(new DataBaseHelper().getCreditId());
    }

    @Test
    @DisplayName("Тест DECLINED карты")
    void shouldCheckDebitDeclinedCard() {
        var invalidCardInformation = DataHelper.getDeclinedCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        assertEquals("DECLINED", new  DataBaseHelper().getPaymentStatus());
        assertNull(new  DataBaseHelper().getCreditId());
        debitPage.declined();
    }

    @Test
    @DisplayName("Тест с картой APPROVED")
    void shouldCheckApprovedCard() {
        var validCardInformation = DataHelper.getApprovedCard();
        var paymentPage = new MainPage();
        paymentPage.buyCreditCard();
        var creditPage = new CreditPage();
        creditPage.creditCardInformation(validCardInformation);
        creditPage.approved();
        assertEquals("APPROVED", new DataBaseHelper().getCreditRequestStatus());
        assertNull(new DataBaseHelper().getCreditId());
    }

    @Test
    @DisplayName("Тест карты DECLINED")
    void shouldCheckDeclinedCard() {
        var invalidCardInformation = DataHelper.getDeclinedCard();
        var paymentPage = new MainPage();
        paymentPage.buyCreditCard();
        var creditPage = new CreditPage();
        creditPage.creditCardInformation(invalidCardInformation);
        assertEquals("DECLINED", new DataBaseHelper().getCreditRequestStatus());
        assertNull(new DataBaseHelper().getCreditId());
        creditPage.declined();
    }
}