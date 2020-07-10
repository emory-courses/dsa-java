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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public LongInteger(LongInteger li) {

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
            throw new NullPointerException();

        // set this.sign
        sign = switch (n.charAt(0)) {
            case '-' -> { n = n.substring(1); yield Sign.NEGATIVE; }
            case '+' -> { n = n.substring(1); yield Sign.POSITIVE; }
            default -> Sign.POSITIVE;
        };

        // allocate this.numeral[]
        numeral = new byte[n.length()];

        for (int i = 0; i < n.length(); i++) {
            numeral[i] = (byte) (n.charAt(i) - 48);
            if (0 > numeral[i] || numeral[i] > 9)
                throw new InvalidParameterException(String.format("%d is not a valid value", numeral[i]));
        }
    }

    @Override
    public void add(LongInteger n) {
        List<Byte> result = new ArrayList<>();
        int size = Math.max(numeral.length, n.numeral.length), r = 0;

        if (sign == n.sign)
            ;
        else
            ;
    }

    private byte[] addSameSign(LongInteger n) {
        return null;
    }

    private byte[] addDifferentSign(LongInteger n) {
        return null;
    }

    @Override
    public void multiply(LongInteger n) {

    }

    @Override
    public void divide(LongInteger n) {
        // TODO:
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        if (isNegative()) build.append("-");
        for (byte n : numeral) build.append(n);
        return build.toString();
    }

    static public void main(String[] args) {
        String a = "123";
        String b = "+456";
        String c = "-789";

        LongInteger la = new LongInteger(a);
        LongInteger lb = new LongInteger(b);
        LongInteger lc = new LongInteger(c);

        System.out.println(la);
        System.out.println(lb);
        System.out.println(lc);

    }

//    implements Comparable<LongInteger>
//    @Override
//    public int compareTo(LongInteger o) {
//        return 0;
//    }
}
