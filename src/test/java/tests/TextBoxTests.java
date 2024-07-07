package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Enter data into the form fields
        $("#userName").setValue("Jon Snow");
        $("#userEmail").setValue("jon_snow@thenorth.com");
        $("#currentAddress").setValue("Winterfell");
        $("#permanentAddress").setValue("Castle Black");
        $("#submit").click();

        // Validation of data from a form
        $("#output").$("#name").shouldHave(text("Jon Snow"));
        $("#output").$("#email").shouldHave(text("jon_snow@thenorth.com"));
        $("#output").$("#currentAddress").shouldHave(text("Winterfell"));
        $("#output").$("#permanentAddress").shouldHave(text("Castle Black"));
    }
}