package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PublicPage {

    private SelenideElement productsButton = $("nav ul li:nth-of-type(2)");
    private SelenideElement productsHeader = $(".products-header");
    private SelenideElement smartlinkInformationExchangeButton = $("#products")
            .find(byText("Обмен информацией"));
    private SelenideElement modalWindowInformationExchangeHeader = $(".id");
    private SelenideElement contactsButton = $("li.ng-star-inserted:nth-of-type(7)");
    private SelenideElement contactsHeader = $(".contacts-title");
    private SelenideElement contactUsButton = $(".contact-us-button");
    private SelenideElement contactUsModalWindowHeader = $(".header");
    private SelenideElement fioInput = $("#mat-input-0");
    private SelenideElement emailInput = $("#mat-input-1");
    private SelenideElement phoneInput = $("#mat-input-2");
    private SelenideElement confirmationCodeInput = $("#mat-input-3");
    private SelenideElement personalDataCheckbox = $("#mat-mdc-checkbox-1-input");
    private SelenideElement privacyPolicyCheckbox = $("#mat-mdc-checkbox-2-input");
    private SelenideElement userAgreementCheckbox = $("#mat-mdc-checkbox-3-input");
    private SelenideElement getConfirmationCodeButton = $(".button-timer");
    private SelenideElement contactMeButton = $(".footer button:nth-of-type(2)");
    private SelenideElement productImage = $("#mat-mdc-dialog-0 product-feature-dialog div:nth-of-type(2) img");

    public void clickProductsButton() {
        productsButton.shouldBe(visible).shouldBe(enabled).shouldHave(text("Продукты")).click();
        productsHeader.shouldBe(visible).shouldHave(text("Продукты"));
    }

    public void clickSmartlinkInformationExchangeButton() {
        smartlinkInformationExchangeButton.shouldBe(visible).shouldBe(enabled).shouldHave(text("Обмен информацией")).click();
        modalWindowInformationExchangeHeader.shouldBe(visible).shouldHave(text("Обмен информацией"));
        productImage.shouldBe(visible).shouldHave(attributeMatching("src", "^(https?://).*"));
    }

    public void clickContactsButton() {
        contactsButton.shouldBe(visible).shouldBe(enabled).shouldHave(text("Контакты")).click();
        contactsHeader.shouldBe(visible).shouldHave(text("Контакты"));
    }

    public void clickContactUsButton() {
        contactUsButton.shouldBe(visible).shouldBe(enabled).shouldHave(text("Связаться с нами")).click();
    }

    public void contactUsModalWindowFilling(String fio, String email, String phone, String confirmationCode) {
        contactUsModalWindowHeader.shouldBe(visible).shouldHave(text("Связаться с нами"));
        fioInput.shouldBe(visible).shouldBe(enabled).setValue(fio);
        emailInput.shouldBe(visible).shouldBe(enabled).setValue(email);
        phoneInput.shouldBe(visible).shouldBe(enabled).setValue(phone);
        getConfirmationCodeButton.shouldBe(visible).shouldBe(enabled).shouldHave(text("Получить код подтверждения"));
        confirmationCodeInput.shouldBe(visible).shouldBe(enabled).setValue(confirmationCode);

        // shouldBe(visible) в данном случае не использую на этих чекбоксах - не успевает он их увидеть
        // click() и так в Selenide автоматически ждет видимости и кликабельности элемента
        personalDataCheckbox.shouldBe(enabled).click();
        privacyPolicyCheckbox.shouldBe(enabled).click();
        userAgreementCheckbox.shouldBe(enabled).click();

        contactMeButton.shouldBe(visible).shouldBe(enabled).shouldHave(text("Свяжитесь со мной"));
    }
}