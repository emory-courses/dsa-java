/*
 * Copyright 2020 Emory University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.cs.algebraic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** @author Jinho D. Choi */
public class LongIntegerTest {
    @Test
    public void testConstructors() {
        // default constructor
        assertEquals("0", new LongInteger().toString());

        // constructor with a string parameter
        assertEquals("12", new LongInteger("12").toString());
        assertEquals("34", new LongInteger("+34").toString());
        assertEquals("-56", new LongInteger("-56").toString());
        assertEquals("-0", new LongInteger("-0").toString());

        // copy constructor
        assertEquals("12", new LongInteger(new LongInteger("12")).toString());
        assertEquals("-34", new LongInteger(new LongInteger("-34")).toString());
    }

    @Test
    public void testAddSameSign() {
        LongInteger a = new LongInteger("0");

        // 0 + positive
        a.add(new LongInteger("123"));
        assertEquals("123", a.toString());

        // positive + 0
        a.add(new LongInteger("0"));
        assertEquals("123", a.toString());

        // no carry
        a.add(new LongInteger("111"));
        assertEquals("234", a.toString());

        // add itself
        a.add(a);
        assertEquals("468", a.toString());

        // carry -> significant digit
        a.add(new LongInteger("556"));
        assertEquals("1024", a.toString());

        // add an integer with a smaller number of digits
        a.add(new LongInteger("76"));
        assertEquals("1100", a.toString());

        // add an integer with a greater number of digits
        a.add(new LongInteger("1009001"));
        assertEquals("1010101", a.toString());

        // -0 + negative
        a.set("-0");
        a.add(new LongInteger("-123"));
        assertEquals("-123", a.toString());

        // negative + -0
        a.add(new LongInteger("-0"));
        assertEquals("-123", a.toString());

        // negative + negative
        a.add(new LongInteger("-456"));
        assertEquals("-579", a.toString());

        // negative + negative: carry -> significant digit
        a.add(a);
        assertEquals("-1158", a.toString());

        // carry multiple digits
        a = new LongInteger("999");
        a.add(new LongInteger("1"));
        assertEquals("1000", a.toString());

        a = new LongInteger("1");
        a.add(new LongInteger("999"));
        assertEquals("1000", a.toString());
    }

    @Test
    public void testMultiply() {
        LongInteger a = new LongInteger("123456789");

        a.multiply(new LongInteger("1"));
        assertEquals("123456789", a.toString());

        a.multiply(new LongInteger("-1"));
        assertEquals("-123456789", a.toString());

        a.multiply(new LongInteger("-1234567890123456789"));
        assertEquals("152415787517146788750190521", a.toString());

        a.multiply(new LongInteger("0"));
        assertEquals("0", a.toString());

        a.multiply(new LongInteger("-0"));
        assertEquals("-0", a.toString());
    }

    @Test
    public void testMultiply2() {
        LongInteger a = new LongInteger("1");

        // 1 * positive
        a.multiply(new LongInteger("12"));
        assertEquals("12", a.toString());

        // positive * 1
        a.multiply(new LongInteger("1"));
        assertEquals("12", a.toString());

        // multiply 1 digit
        a.multiply(new LongInteger("2"));
        assertEquals("24", a.toString());

        // multiply itself
        a.multiply(a);
        assertEquals("576", a.toString());

        // multiply an integer with a smaller number of digits
        a.multiply(a);
        assertEquals("331776", a.toString());

        // multiply an integer with a greater number of digits
        a.multiply(new LongInteger("6789012"));
        assertEquals("2252431245312", a.toString());

        // challenge a large integer
        a.multiply(a);
        assertEquals("5073446514857767121977344", a.toString());

        // positive * -1
        a.set("123");
        a.multiply(new LongInteger("-1"));
        assertEquals("-123", a.toString());

        // negative * -1
        a.multiply(new LongInteger("-1"));
        assertEquals("123", a.toString());

        // positive * negative
        a.multiply(new LongInteger("-456"));
        assertEquals("-56088", a.toString());

        // negative * positive
        a.multiply(new LongInteger("78"));
        assertEquals("-4374864", a.toString());

        // negative * negative
        a.multiply(a);
        assertEquals("19139435018496", a.toString());

        a.multiply(new LongInteger("0"));
        assertEquals("0", a.toString());

        a.multiply(new LongInteger("-0"));
        assertEquals("-0", a.toString());
    }

    @Test
    public void testCompareAbs() {
        assertEquals(0, new LongInteger("0").compareAbs(new LongInteger("-0")));
        assertEquals(0, new LongInteger("-0").compareAbs(new LongInteger("0")));

        assertTrue(0 > new LongInteger("12").compareAbs(new LongInteger("-34")));
        assertTrue(0 > new LongInteger("-12").compareAbs(new LongInteger("34")));

        assertTrue(0 < new LongInteger("-34").compareAbs(new LongInteger("12")));
        assertTrue(0 < new LongInteger("34").compareAbs(new LongInteger("-12")));
    }

    @Test
    public void testCompareTo() {
        assertTrue(0 < new LongInteger("0").compareTo(new LongInteger("-0")));
        assertTrue(0 > new LongInteger("-0").compareTo(new LongInteger("0")));

        assertTrue(0 < new LongInteger("12").compareTo(new LongInteger("-34")));
        assertTrue(0 > new LongInteger("-12").compareTo(new LongInteger("34")));

        assertTrue(0 > new LongInteger("-34").compareTo(new LongInteger("12")));
        assertTrue(0 < new LongInteger("34").compareTo(new LongInteger("-12")));
    }
}
