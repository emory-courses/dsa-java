/*
 * <author>Han He</author>
 * <email>me@hankcs.com</email>
 * <create-date>2019-08-27 13:35</create-date>
 *
 * <copyright file="Utils.java">
 * Copyright (c) 2019, Han He. All Rights Reserved, http://www.hankcs.com/
 * See LICENSE file in the project root for full license information.
 * </copyright>
 */
package edu.emory.cs.utils;

/**
 * @author hankcs
 */
public class Utils
{
    static public int getMiddleIndex(int beginIndex, int endIndex)
    {
        return beginIndex + (endIndex - beginIndex) / 2;
    }

    static public void main(String[] args)
    {
        System.out.println(getMiddleIndex(0, 10));
    }
}
