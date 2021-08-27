package org.example.framework.utils;

import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepFinished;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm;
import org.example.framework.managers.DriverManager;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static io.cucumber.plugin.event.Status.FAILED;

public class MyAllureListener extends AllureCucumber5Jvm {

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestStepFinished.class, testStepFinished -> {
            if(testStepFinished.getResult().getStatus().equals(FAILED)) {
                Allure.getLifecycle().addAttachment("screenshot", "image/jpeg", null,
                        ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES));
            }
        });

        super.setEventPublisher(publisher);
    }
}
