package com.fast.springboot.basic.algorithm;

import java.util.stream.IntStream;

/**
 * 输入描述.
 *
 * @author : weibo
 * @version : v1.0
 * @since : 2020/1/2 16:51
 */
public class BitMapDemo {
    private static final int ARRAY_DATA_COUNT = 1025;
    private int capacity;
    private byte[][] bitArr;

    public BitMapDemo(int capacity) {
        this.capacity = capacity;
        this.bitArr = new byte[(capacity / ARRAY_DATA_COUNT) + 1][ARRAY_DATA_COUNT];
    }

    public static void main(String[] args) {
        BitMapNew bitMapNew = new BitMapNew(2000);
        testAdd(bitMapNew);
        // testClear(bitMapNew);
    }

    private static void testAdd(BitMapNew bitMapNew) {
        IntStream.rangeClosed(1, 1000).forEach(data -> {
            bitMapNew.add(data);
        });

        IntStream.rangeClosed(1, 1002).forEach(data -> {
            boolean exist = bitMapNew.contains(data);
            System.out.println(String.format("%s exist: %s", data, exist));
        });

        System.out.println();
    }

    private static void testClear(BitMapNew bitMapNew) {
        IntStream.rangeClosed(1, 10).forEach(data -> {
            bitMapNew.clear(data);
        });

        IntStream.rangeClosed(1, 12).forEach(data -> {
            boolean exist = bitMapNew.contains(data);
            System.out.println(String.format("%s exist: %s", data, exist));
        });

        System.out.println();
    }

    private int getArrayIndex(int number) {
        return number / ARRAY_DATA_COUNT;
    }

    private int getByteIndex(int number) {
        // number = 9, ARRAY_DATA_COUNT = 8, 期望值：1
        return number % ARRAY_DATA_COUNT;
    }

    public void add(int number) {
        int arrayIndex = getArrayIndex(number); //向右移3位 = 除以8
        int byteIndex = getByteIndex(number);
        bitArr[arrayIndex][byteIndex] = 1;
    }

    public boolean contains(int number) {
        int arrayIndex = getArrayIndex(number);
        int byteIndex = getByteIndex(number);
        return bitArr[arrayIndex][byteIndex] == 1;
    }

    public void clear(int number) {
        int arrayIndex = getArrayIndex(number);
        int byteIndex = getByteIndex(number);
        bitArr[arrayIndex][byteIndex] = 0;
    }
}
