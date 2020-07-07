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
public class LongInteger extends SignedNumeral<LongInteger> {
    private byte[] numeral;

//    public LongInteger(String value) {
//        numeral = new byte[size];
//    }

    public LongInteger(int size) {
        numeral = new byte[size];
    }

    public void set(String value) {
//        sign = switch(value.charAt(0)) {
//            case '-' ->
//        }

        System.out.println("SDFSF");
    }


    @Override
    public void add(LongInteger n) {

    }

    @Override
    public void multiply(LongInteger n) {

    }

    @Override
    public void divide(LongInteger n) {

    }

    static public void main(String[] args) {
        System.out.println("SDFSFS");
    }

}
