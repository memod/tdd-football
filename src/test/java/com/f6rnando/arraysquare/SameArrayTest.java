package com.f6rnando.arraysquare;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SameArrayTest {

    // Two arrays are the same if array b contains only element in a squared
    // Order does not matter
    //-- Array a and b's length should be the same
    //-- If any array is null return false
    //-- If a or b are empty return false

    @Test
    public void arraysShouldNotBeEmpty() {
        int[] arrayA = {};
        int[] arrayB = {};

        assertFalse(SameArray.compare(arrayA, arrayB));
    }

    @Test
    public void arraysShouldNotBeNull() {
        assertFalse(SameArray.compare(null, null));
    }

    @Test
    public void arraysLengthShouldBeTheSame() {
        int[] arrayA = {1, 2};
        int[] arrayB = {3, 4};

        assertTrue(SameArray.compare(arrayA, arrayB));
    }

    @Test
    public void arraysWithDifferentLengthShouldReturnFalse() {
        int[] arrayA = {1, 2};
        int[] arrayB = {3, 4, 5};

        assertFalse(SameArray.compare(arrayA, arrayB));
    }
}
