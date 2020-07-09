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

import java.nio.InvalidMarkException;
import java.security.InvalidParameterException;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.stream.IntStream;

/** @author Jinho D. Choi */
public class LongInteger extends SignedNumeral<LongInteger> {
    /** The values of this numeral (excluding the sign). */
    private byte[] numeral;

    /** Creates a long integer with the default value of "0". */
    public LongInteger() {
        this("0");
    }

    /**
     * Creates a long integer with the specific sign and values.
     * @param n the sign and values to be set.
     * @see #set(String)
     */
    public LongInteger(String n) {
        set(n);
    }

    public LongInteger(int n) {
        set(n);
    }

    /**
     * Sets the sign and values of this numeral.
     * @param n the sign and values to be set.
     * @throws NullPointerException      when `n` is null.
     * @throws InvalidParameterException when `n` contains non-digit character
     *                                   except for the first character that can be [+-\d].
     */
    public void set(String n) {
        // 'n' must not be null
        if (n == null)
            throw new NullPointerException("The value cannot be null");

        // set this.sign
        sign = switch (n.charAt(0)) {
            case '-' -> { n = n.substring(1); yield Sign.NEGATIVE; }
            case '+' -> { n = n.substring(1); yield Sign.POSITIVE; }
            default -> Sign.POSITIVE;
        };

        // allocate this.numeral[]
        int size = (n.length() / 10 + 1) * 10;
        numeral = new byte[size];
        Arrays.fill(numeral, (byte) -1);

        for (int i = 0; i < n.length(); i++) {
            numeral[i] = (byte) (n.charAt(i) - 48);
            if (0 <= numeral[i] && numeral[i] <= 9)
                throw new InvalidParameterException("The value must contain only [+-\\d]");
        }
    }

    /**
     * TODO: to be implemented
     * @param n
     */
    public void set(int n) {

    }


    @Override
    public void add(LongInteger n) {

    }

    @Override
    public void multiply(LongInteger n) {

    }

    @Override
    public void divide(LongInteger n) {
        // TODO:
    }

    static public void main(String[] args) {
        String s = "12345";
        ValueRange range = ValueRange.of(0, 9);
        byte[] b = new byte[5];
        for (int i = 0; i < s.length(); i++) {
            b[i] = (byte) (s.charAt(i) - 48);
//            if (!range.isValidIntValue(b[i]))
//                System.out.println(s.charAt(i));
        }

        System.out.println(Arrays.toString(b));
    }

}
