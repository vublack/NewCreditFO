package com.bars;

import java.util.Random;

public class Calculation {
    public String randomNum(){
        //Вставка рандомного числа
        Random random = new Random();
        int number = random.nextInt(899)+100;
        return String.valueOf(number);
    }
}
