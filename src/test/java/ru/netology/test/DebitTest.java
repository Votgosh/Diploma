package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.MainPage;
import static com.codeborne.selenide.Selenide.open;

public class DebitTest{


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
    @DisplayName("Тест раздела <Купить> сайта")
    void shouldCheckLoading() {
        MainPage main = new MainPage();
        main.buyDebitCard();
    }

    @Test
    @DisplayName("Тест с пустым полем номера карты")
    void shouldCheckTheEmptyCardNumber() {
        var invalidCardInformation = DataHelper.getEmptyCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест с большим номером карты")
    void shouldCheckTheHugeNumberCard() {
        var invalidCardInformation = DataHelper.getHugeCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест с нулевым номером карты")
    void shouldCheckTheZeroNumberCard() {
        var invalidCardInformation = DataHelper.getZeroCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест с несуществующим номером карты")
    void shouldCheckTheInvalidCard() {
        var invalidCardInformation = DataHelper.getInvalidCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.declined();
    }

    @Test
    @DisplayName("Тест с символами в поле номера")
    void shouldCheckTheSymbolNumberCard() {
        var invalidCardInformation = DataHelper.getSymbolCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест с текстовым номером")
    void shouldCheckTheTextNumberCard() {
        var invalidCardInformation = DataHelper.getTextCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест с коротким номером")
    void shouldCheckTheShortNumberCard() {
        var invalidCardInformation = DataHelper.getSmallCard();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldNumberCard();
    }

    @Test
    @DisplayName("Тест c пустым полем месяца")
    void shouldCheckTheEmptyMonth() {
        var invalidCardInformation = DataHelper.getEmptyMonthField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест невалидного месяца")
    void shouldCheckTheInvalidMonth() {
        var invalidCardInformation = DataHelper.getPreviousMonthField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.expiredDataMessage();
    }

    @Test
    @DisplayName("Тест нулевого месяца")
    void shouldCheckTheZeroMonth() {
        var invalidCardInformation = DataHelper.getZeroMonthField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.declined();
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест несуществующего (13) месяца")
    void shouldCheckTheImpossibleMonth() {
        var invalidCardInformation = DataHelper.getInvalidMonthField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест c одним числом в поле месяца")
    void shouldCheckTheOneNumberMonth() {
        var invalidCardInformation = DataHelper.getOneNumberMonthField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест c текстом в поле месяца")
    void shouldCheckTheTextMonth() {
        var invalidCardInformation = DataHelper.getTextMonthField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест c символами в поле месяца")
    void shouldCheckTheSymbolMonth() {
        var invalidCardInformation = DataHelper.getSymbolMonthField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldMonth();
    }

    @Test
    @DisplayName("Тест с истекшим сроком действия карты")
    void shouldBeCheckedWithAnExpiredExpirationDate() {
        var invalidCardInformation = DataHelper.getInvalidYearField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.expiredDataMessage();
    }

    @Test
    @DisplayName("Тест с нулевым годом")
    void shouldCheckZeroYear() {
        var invalidCardInformation = DataHelper.getZeroYearField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.expiredDataMessage();
    }

    @Test
    @DisplayName("Тест с пустым полем года")
    void shouldCheckEmptyYear() {
        var invalidCardInformation = DataHelper.getEmptyYear();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест с текстом в поле года")
    void shouldCheckTextYear() {
        var invalidCardInformation = DataHelper.getTextYearField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.invalidDataMessage();
    }

    @Test
    @DisplayName("Тест с одной цифрой года")
    void shouldCheckOneNumberYear() {
        var invalidCardInformation = DataHelper.getOneNumberYearField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест с символами в поле года")
    void shouldCheckSymbolYear() {
        var invalidCardInformation = DataHelper.getSymbolYearField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldYear();
    }

    @Test
    @DisplayName("Тест владельца символами")
    void shouldCheckSymbolHolder() {
        var invalidCardInformation = DataHelper.getSymbolNameHolder();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест владельца по-русски")
    void shouldCheckRussianHolder() {
        var invalidCardInformation = DataHelper.getRusNameHolder();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест владельца карты цифрами")
    void shouldCheckNumberHolder() {
        var invalidCardInformation = DataHelper.getNumberNameHolder();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест владельца карты только фамилия")
    void shouldCheckSurnameHolder() {
        var invalidCardInformation = DataHelper.getLastNameHolder();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест незаполненного имени")
    void shouldCheckEmptyNameHolder() {
        var invalidCardInformation = DataHelper.getEmptyNameHolder();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldHolder();
    }

    @Test
    @DisplayName("Тест короткого имени владельца")
    void shouldCheckOneShortNameHolder() {
        var invalidCardInformation = DataHelper.getOneLetterNameHolderField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест длинного имени владельца")
    void shouldCheckLongNameHolder() {
        var invalidCardInformation = DataHelper.getHugeNameHolderField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValidFieldHolder();
    }

    @Test
    @DisplayName("Тест пустого CVV")
    void shouldCheckEmptyCVV() {
        var invalidCardInformation = DataHelper.getEmptyCVV();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из одного числа")
    void shouldCheckOneNumberCVV() {
        var invalidCardInformation = DataHelper.getOneNumberCVV();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из двух чисел")
    void shouldCheckTwoNumberCVV() {
        var invalidCardInformation = DataHelper.getTwoNumberCVV();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест символьного CVV")
    void shouldCheckSymbolCVV() {
        var invalidCardInformation = DataHelper.getSymbolCVV();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест нулевого CVV")
    void shouldCheckZeroNumberCVV() {
        var invalidCardInformation = DataHelper.getZeroCVV();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест текстового CVV")
    void shouldCheckTextCVV() {
        var invalidCardInformation = DataHelper.getTextCVVField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест CVV из 4 цифр")
    void shouldCheckFourNumberCVV() {
        var invalidCardInformation = DataHelper.getLongCVVField();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.shouldValueFieldCVV();
    }

    @Test
    @DisplayName("Тест отправка пустой формы")
    void shouldSendAnEmptyForm() {
        var invalidCardInformation = DataHelper.getEmptyCardFields();
        var debitPage = new MainPage().buyDebitCard();
        debitPage.debitCardInformation(invalidCardInformation);
        debitPage.emptyFieldMessage();
        debitPage.improperFormatMessage();
        debitPage.shouldValueFieldCVV();
        debitPage.shouldValueFieldYear();
        debitPage.shouldValueFieldMonth();
        debitPage.shouldValueFieldNumberCard();
        debitPage.shouldValueFieldHolder();
    }
}