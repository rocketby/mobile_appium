package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("selenide_android")
public class WikiAndroidTests extends TestBase {

    @Test
    @DisplayName("Getting started tests in Wikipedia on Android")
    void gettingStartedWikiTest() {
        step("Verify content on main page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("The Free Encyclopedia …in over 300 languages")));

        step("Click continue button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Verify text on opened page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));

        step("Click continue button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Verify text on opened page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));

        step("Click continue button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Verify text on opened page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));

    }

}