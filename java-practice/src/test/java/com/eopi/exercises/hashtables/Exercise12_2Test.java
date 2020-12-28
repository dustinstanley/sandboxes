package com.eopi.exercises.hashtables;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise12_2Test {

    @Test
    void isLetterConstructible_magazineHasEnoughCharacters_returnsTrue() {
        String magazineText = "i think this magazine text will have enough characters to construct the letter text.b";
        String letterText = "this letter text is constructible.";

        assertThat(Exercise12_2.isLetterConstrucibleFromMagazine(magazineText, letterText)).isTrue();
    }

    @Test
    void isLetterConstructible_magazineDoesNotHaveEnoughCharacters_returnsFalse() {
        String magazineText = "this magazine text will not be constructible.";
        String letterText = "this letter text is not constructible! qzwx";

        assertThat(Exercise12_2.isLetterConstrucibleFromMagazine(magazineText, letterText)).isFalse();
    }
}
