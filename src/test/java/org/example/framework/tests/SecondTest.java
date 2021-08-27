package org.example.framework.tests;

import org.example.framework.basetestclass.BaseTests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SecondTest extends BaseTests {

//    private static Stream<Arguments> data() {
//        return Stream.of(
//                Arguments.of("500 000", "12 месяцев", "20 000", "0.15%", "720 920,60"),
//                Arguments.of("600 000", "3 месяца", "10 000", "0.05%", "620 076,04")
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("data")
//    public void startTest(String contributionAmount, String period, String replenish, String rate, String result) {
//
//        app.getHomePage()
//                .selectMenu("Вклады")
//                .selectCurrency("Доллары США")
//                .fillField("Сумма вклада", contributionAmount)
//                .selectPeriod(period)
//                .fillField("Ежемесячное пополнение", replenish)
//                .clickCheckboxByName("Ежемесячная капитализация")
//                .checkRate(rate)
//                .checkResult(result);
//    }
}
