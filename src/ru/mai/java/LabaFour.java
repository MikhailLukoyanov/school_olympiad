package ru.mai.java;

import  java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Mikhail Lukoyanov
 */
//Основной класс
public class LabaFour {
    static final String INPUT_FILE = "t.txt";
    static final String OUTPUT_FILE = "f.txt";
    public static void main(String[] args) {
        Writer outPut = null;
        //создаем входной и выходной потоки
        try (FileInputStream inPut = new FileInputStream(INPUT_FILE)) {
            outPut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE), StandardCharsets.UTF_8));
            //создаем объект класса
            Parser parser = new Parser(inPut, outPut);
            //Вызываем метод класса
            parser.getAllChild();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Потоки не создались");;
        } finally {
            try {
                //закрываем выходной поток
                outPut.close();
            } catch (IOException e) {
                System.out.println("Поток не закрылся");;
            }
        }

    }
}


