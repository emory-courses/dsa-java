package edu.emory.cs.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest
{
    @Test
    public void getMiddleIndex()
    {
        assertEquals(5, Utils.getMiddleIndex(0, 10));
    }
}