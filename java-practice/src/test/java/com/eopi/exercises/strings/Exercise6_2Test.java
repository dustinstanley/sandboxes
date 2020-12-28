package com.eopi.exercises.strings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Exercise6_2Test {

    static Object[][] convertBaseProvider() {
        return new Object[][] {
                {"", 16, 10, ""}
        };
    }

    @ParameterizedTest
    @MethodSource("convertBaseProvider")
    void convertBase_isOk(String input, int baseOne, int baseTwo, String expected) {
        assertThat(Exercise6_2.convertBase(input, baseOne, baseTwo)).isEqualTo(expected);
    }
}
