package ru.mai.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Mikhail Lukoyanov
 */
//Класс для работы с входными данными
public class Parser {
    //Регулярное выражение
    private static final String REGEX = "([А-Я][а-я]+\s[А-я][а-я]+)\s([МД])\s(\\d+)\s(\\d+)";
    //входной поток
    private InputStream inPut;
    //выходной поток
    private Writer outPut;
    //список всех учеников
    private ArrayList<Child> childList;
    //список призеров
    private ArrayList<Child> winner;
    //объект сканера
    static Scanner in;

    //конструктор класса
    public Parser(InputStream inPut, Writer outPut) {
        this.inPut = inPut;
        this.outPut = outPut;
    }
    //метод считывающий данные из файла и работающий с ними
     public void getAllChild() {
         in = new Scanner(inPut);
         Pattern pattern = Pattern.compile(REGEX);
         int currentLine = 1;
         childList = new ArrayList<>();
         winner = new ArrayList<>();
         //считываем все что есть в файле и заносим в переменную list
         List<String> list = in.findAll(".+")
                 .map(MatchResult::group)
                 .collect(Collectors.toList());
         //пробегаемся и начинаем сравнивать с нашим регулярным выражением
         for (String str : list) {
             Matcher matcher = pattern.matcher(str);
             //если нашли добавляем ученика
             if (matcher.find()) {
                 childList.add(new Child(matcher.group(1), matcher.group(2),
                         Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4))));

             }else {
                 System.out.println("неверный формат данных в строчке"+ currentLine);
             }
             currentLine++;
         }
         //метод нахождения призеров
         winner = getWinner(childList);
         String strNumberSch;
         String strPoint;
         //вывод призеров на экран
         for (Child ch : winner) {
             try {
                 strNumberSch = String.valueOf(ch.getNumberSchool());
                 strPoint = String.valueOf(ch.getPoint());
                 outPut.write(ch.getName() + " " + ch.getPol() + " " + strNumberSch + " " + strPoint + "\n");
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }


     }

     //метод лоя нахождения призеров
     private ArrayList<Child> getWinner(ArrayList<Child> childList) {
        //создаем пустой список
        ArrayList<Child> listWinner = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int maxPoint = -1;
            int maxIndex = -1;
            int index = 0;
            for (Child ch : childList) {
                if (maxPoint < ch.getPoint()) {
                    maxPoint = ch.getPoint();
                    maxIndex = index;
                }
                index++;
            }
            //добавляем в список ученика с макс баллами
            listWinner.add(childList.get(maxIndex));
            //удаляем ученика из списка всех учеников
            childList.remove(maxIndex);
        }
        return listWinner;
     }
}

