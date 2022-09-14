package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    public static String approvedStatusCard = "4444 4444 4444 4441";
    public static String declinedStatusCard = "4444 4444 4444 4442";

    public static Faker faker = new Faker(new Locale("en"));
    public static Faker fakerRUS = new Faker(new Locale("ru"));


    public DataHelper() {
    }

    @Value
    public static class CardInfo {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    public static String getZeroCardNumber() {
        return ("0000 0000 0000 0000");
    }

    public static String getInvalidCardNumber() {
        return "0000 0000 0000  0001";
    }

    public static String getEmptyCardNumber() {
        return " ";
    }

    public static String getHugeCardNumber() {
        return ("5555 6666 7777 8888 9999");
    }

    public static String getSmallCardNumber() {
        return ("5555 6666");
    }

    public static String getTextCardNumber() {
        return ("aaaa bbbb cccc dddd");
    }
    public static String getValidMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getPreviousMonth() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM")); }

    public static String getZeroMonth() {
        return "00";
    }

    public static String getInvalidMonth() {
        return "13";
    }

    public static String getOneNumberMonth() {
        return "9";
    }

    public static String getTextMonth() {
        return "ab";
    }

    private static String getSymbolMonth() {
        return "@#";
    }

    public static String getValidYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String getInvalidYear() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getZeroYear() {
        return ("00");
    }

    public static String getTextYear() {
        return "ab";
    }

    private static String getSymbolYear() {
        return "@#";
    }

    private static String getOneNumberYear() {
        return "5";
    }

    public static String getHolderName() {
        return faker.name().fullName();
    }

    public static String getHolderNameRus() {
        return fakerRUS.name().lastName() + " " + fakerRUS.name().firstName();
    }

    public static String getHolderLastName() {
        return faker.name().lastName();
    }

    public static String getEmptyHolderName() {
        return "";
    }

    public static String getOneLetterHolderName() {
        return "a";
    }

    public static String getHugeHolderName() {
        return "abrakadddddddaaaaaabbbbbbbbbbbrrrrrrrraaaaaaaaaaaaa";
    }

    public static String getNumberHolderName() {
        return "123453434 422321311";
    }

    public static String getValidCVV() {
        return faker.numerify("###");
    }

    public static String getSymbolCVVField() {
        return "@#$";
    }

    public static String getZeroCVVField() {
        return "000";
    }

    public static String getShortCVV() {
        return faker.numerify("##");
    }

    public static String getOneCVV() {
        return faker.numerify("#");
    }

    private static String getTextCVV() {
        return "abc";
    }

    private static String getLongCVV() {
        return "1234";
    }

    private static String getSymbol() {
        return "<|@#$%^&*()~-+/*?>";
    }

    public static String getEmptyField() {
        return " ";
    }

    public static CardInfo getApprovedCard() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo(declinedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getEmptyCard() {
        return new CardInfo(getEmptyCardNumber(), getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getHugeCard() {
        return new CardInfo(getHugeCardNumber(), getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getZeroCard() {
        return new CardInfo(getZeroCardNumber(), getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getInvalidCard() {
        return new CardInfo(getInvalidCardNumber(), getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getSymbolCard() {
        return new CardInfo(getSymbol(), getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getTextCard() {
        return new CardInfo(getTextCardNumber(), getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }
    public static CardInfo getSmallCard() {
        return new CardInfo(getSmallCardNumber(), getValidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getEmptyMonthField() {
        return new CardInfo(approvedStatusCard, getEmptyField(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getPreviousMonthField() {
        return new CardInfo(approvedStatusCard, getPreviousMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getZeroMonthField() {
        return new CardInfo(approvedStatusCard, getZeroMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getInvalidMonthField() {
        return new CardInfo(approvedStatusCard, getInvalidMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getOneNumberMonthField() {
        return new CardInfo(approvedStatusCard, getOneNumberMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getTextMonthField() {
        return new CardInfo(approvedStatusCard, getTextMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getSymbolMonthField() {
        return new CardInfo(approvedStatusCard, getSymbolMonth(), getValidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getInvalidYearField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getInvalidYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getZeroYearField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getZeroYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getEmptyYear() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getEmptyField(), getHolderName(), getValidCVV());
    }

    public static CardInfo getTextYearField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getTextYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getOneNumberYearField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getOneNumberYear(), getHolderName(), getValidCVV());
    }
    public static CardInfo getSymbolYearField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getSymbolYear(), getHolderName(), getValidCVV());
    }

    public static CardInfo getSymbolNameHolder() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getSymbol(), getValidCVV());
    }

    public static CardInfo getRusNameHolder() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(),  getHolderNameRus(), getValidCVV());
    }

    public static CardInfo getNumberNameHolder() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getNumberHolderName(), getValidCVV());
    }

    public static CardInfo getLastNameHolder() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderLastName(), getValidCVV());
    }

    public static CardInfo getEmptyNameHolder() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getEmptyHolderName(), getValidCVV());
    }

    public static CardInfo getOneLetterNameHolderField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getOneLetterHolderName(), getValidCVV());
    }

    public static CardInfo getHugeNameHolderField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHugeHolderName(), getValidCVV());
    }

    public static CardInfo getEmptyCVV() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getEmptyField());
    }

    public static CardInfo getOneNumberCVV() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getOneCVV());
    }

    public static CardInfo getTwoNumberCVV() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getShortCVV());
    }

    public static CardInfo getSymbolCVV() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getSymbolCVVField());
    }

    public static CardInfo getZeroCVV() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getZeroCVVField());
    }

    public static CardInfo getTextCVVField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getTextCVV());
    }

    public static CardInfo getLongCVVField() {
        return new CardInfo(approvedStatusCard, getValidMonth(), getValidYear(), getHolderName(), getLongCVV());
    }

    public static CardInfo getEmptyCardFields() {
        return new CardInfo(getEmptyCardNumber(), getEmptyField(), getEmptyField(), getEmptyField(), getEmptyField());
    }
}