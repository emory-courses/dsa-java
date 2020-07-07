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

/** @author Jinho D. Choi */
public abstract class SignedNumeral<T extends SignedNumeral<T>> implements Numeral<T> {
    /** The sign of this numeral. */
    protected Sign sign;

    /**
     * Create a signed numeral.
     * the default sign is {@link Sign#POSITIVE}.
     */
    public SignedNumeral() {
        this(Sign.POSITIVE);
    }

    /**
     * Create a signed numeral.
     * @param sign the sign of this numeral.
     */
    public SignedNumeral(Sign sign) {
        this.sign = sign;
    }

    /** @return true if this numeral is positive; otherwise, false. */
    public boolean isPositive() {
        return sign == Sign.POSITIVE;
    }

    /** @return true if this numeral is negative; otherwise, false. */
    public boolean isNegative() {
        return sign == Sign.NEGATIVE;
    }

    /** Flips the sign of this numeral. */
    public void flipSign() {
        sign = isPositive() ? Sign.NEGATIVE : Sign.POSITIVE;
    }

    /**
     * Subtracts `n` from this numeral.
     * @param n the numeral to be subtracted.
     */
    public void subtract(T n) {
        n.flipSign();
        add(n);
        n.flipSign();
    }

    /**
     * Divides this numeral by `n`.
     * @param n the numeral to be divided.
     */
    public abstract void divide(T n);
}