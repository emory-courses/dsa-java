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

import java.security.InvalidParameterException;
import java.util.Arrays;

/** @author Jinho D. Choi */
public class LongInteger extends SignedNumeral<LongInteger> implements Comparable<LongInteger> {
    /** The values of this numeral (excluding the sign). */
    protected byte[] numeral;

    /** Creates a long integer with the default value of "0". */
    public LongInteger() {
        this("0");
    }

    /**
     * Creates a long integer by copying the specific object.
     * @param n the object to be copied.
     */
    public LongInteger(LongInteger n) {
        super(n.sign);
        numeral = Arrays.copyOf(n.numeral, n.numeral.length);
    }

    /**
     * Creates a long integer with the specific sign and values.
     * @param n the sign and values to be set.
     * @see #set(String)
     */
    public LongInteger(String n) {
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
            byte v = (byte)(n.charAt(i) - 48);
            if (0 > v || v > 9)
                throw new InvalidParameterException(String.format("%d is not a valid value", v));
            numeral[n.length() - i - 1] = v;
        }
    }

    @Override
    public void add(LongInteger n) {
        if (sign == n.sign)
            addSameSign(n);
        else
            addDifferentSign(n);
    }

    /**
     * Adds the specific integer that has the same sign as this integer.
     * @param n the integer to be added with the same sign.
     */
    protected void addSameSign(LongInteger n) {
        int m = Math.max(numeral.length, n.numeral.length);
        byte[] result = new byte[m + 1];
        System.arraycopy(numeral, 0, result, 0, numeral.length);

        for (int i = 0; i < n.numeral.length; i++) {
            result[i] += n.numeral[i];

            if (result[i] >= 10) {
                result[i] -= 10;
                result[i + 1] += 1;
            }
        }

        numeral = result[m] == 0 ? Arrays.copyOf(result, m) : result;
    }

    /**
     * Adds the specific integer that has a different sign as this integer.
     * @param n the integer to be added with a different sign
     */
    protected void addDifferentSign(LongInteger n) {
        throw new UnsupportedOperationException("Cannot add two LongIntegers with different signs");
    }

    @Override
    public void multiply(LongInteger n) {
        byte[] result = new byte[numeral.length + n.numeral.length];

        for (int i = 0; i < numeral.length; i++) {
            for (int j = 0; j < n.numeral.length; j++) {
                int k = i + j, prod = numeral[i] * n.numeral[j];
                result[k] += prod;
                result[k + 1] += result[k] / 10;
                result[k] %= 10;
            }
        }

        int i; for (i = result.length - 1; i >= 0; i--) {
            if (result[i] != 0) {
                if (i + 1 < result.length)
                    result = Arrays.copyOf(result, i + 1);
                break;
            }
        }

        if (i < 0) result = Arrays.copyOf(result, 1);
        sign = sign == n.sign ? Sign.POSITIVE : Sign.NEGATIVE;
        numeral = result;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        if (sign == Sign.NEGATIVE) build.append("-");
        for (int i = numeral.length - 1; i >= 0; i--)
            build.append(numeral[i]);
        return build.toString();
    }

    @Override
    public int compareTo(LongInteger n) {
        if (isPositive())
            return n.isNegative() ? 1 : compareAbs(n);
        else
            return n.isPositive() ? -1 : -compareAbs(n);
    }

    /**
     * @param n the object to be compared.
     * @return a negative integer, zero, or a positive integer as the absolute value of this object is
     * less than, equal to, or greater than the absolute value of the specified object.
     */
    public int compareAbs(LongInteger n) {
        int diff = numeral.length - n.numeral.length;

        if (diff == 0) {
            for (int i = numeral.length - 1; i >= 0; i--) {
                diff = numeral[i] - n.numeral[i];
                if (diff == 0) break;
            }
        }

        return diff;
    }
}
