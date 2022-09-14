package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement buttonDebit = $$(".button__text").find(exactText("Купить"));
    private SelenideElement buttonCredit = $$(".button__text").find(exactText("Купить в кредит"));
    private SelenideElement pay = $$(".heading").find(exactText("Путешествие дня"));

    public MainPage() {
        pay.shouldBe(Condition.visible);
    }

    public DebitPage buyDebitCard() {
        buttonDebit.click();
        return new DebitPage();
    }

    public CreditPage buyCreditCard() {
        buttonCredit.click();
        return new CreditPage();
    }
}