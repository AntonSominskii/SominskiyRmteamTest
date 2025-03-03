package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PublicPageTest extends PublicPageBaseTest {

    @Test
    @Owner("Антон Соминский")
    @Severity(SeverityLevel.NORMAL)
    @Story("Боковое меню(слева)")
    @DisplayName("Работа кнопки управления \"Продукты\"")
    @Description("Тест проверяет нажатие кнопки \"Продукты\" с последующей проверкой хедера после нажатия")
    public void productsButtonWork() {
        publicPage.clickProductsButton();
    }

    @Test
    @Owner("Антон Соминский")
    @Severity(SeverityLevel.NORMAL)
    @Story("Боковое меню(слева)")
    @DisplayName("Просмотр информации о продукте")
    @Description("Тест переходит к разделу \"Продукты\", нажимает на кнопку показателя продукта \"Smartlink\" - " +
            "\"Обмен информацией\" с последующей проверкой хедера после нажатия")
    public void productInformationExchangeGetInfo() {
        publicPage.clickProductsButton();
        publicPage.clickSmartlinkInformationExchangeButton();
    }

    @Test
    @Owner("Антон Соминский")
    @Severity(SeverityLevel.NORMAL)
    @Story("Боковое меню(слева)")
    @DisplayName("Форма обратной связи")
    @Description("""
            Тест переходит к разделу "Контакты", заполняет поля, выставляет чекбоксы и проверяет, что:
            1) При заполнении номера телефона активирована кнопка "Получить код подтверждения"
            2) При заполнении всех полей и установке всех чекбоксов активирована кнопка "Свяжитесь со мной\"""")
    public void feedbackForm() {
        publicPage.clickContactsButton();
        publicPage.clickContactUsButton();
        publicPage.contactUsModalWindowFilling(fio, email, phone, confirmationCode);
    }
}