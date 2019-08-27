package edu.emory.cs.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void getMiddleIndexTest()
    {
        assertEquals(5, Utils.getMiddleIndex(0, 10));
    }
}
