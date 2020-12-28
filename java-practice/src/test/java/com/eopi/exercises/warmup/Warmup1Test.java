package com.eopi.exercises.warmup;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Warmup1Test {

    @Test
    void warmup1Test() {
        Warmup1 warmup = new Warmup1();
        warmup.run(1000);
        assertThat(warmup.getNumberCount()).isEqualTo(533);
        assertThat(warmup.getFizzCount()).isEqualTo(267);
        assertThat(warmup.getBuzzCount()).isEqualTo(134);
        assertThat(warmup.getFizzBuzzCount()).isEqualTo(66);
    }
}
