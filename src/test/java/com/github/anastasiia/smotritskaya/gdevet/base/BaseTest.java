package com.github.anastasiia.smotritskaya.gdevet.base;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Базовый класс, содержащий настройки запуска для всех тестов
 */
@Epic("UI Tests for Veterinary Aggregator")
public class BaseTest {
    @BeforeEach
    void setUp() {
        System.out.println("Setting up test...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--lang=en");

        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;
        Configuration.headless = false;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after test...");
    }
}
