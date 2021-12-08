package ru.mai.java;

/**
 * @author Mikhail Lukoyanov
 */
//класс ученика
public class Child {
    private String name;
    private String pol;
    private int numberSchool;
    private int point;

    //конструктор класса
    public Child(String name, String pol, int numberSchool, int point) {
        this.name = name;
        this.pol = pol;
        this.numberSchool = numberSchool;
        this.point = point;
    }

    //метод сравнения строк
    public boolean equals(String name) {
        return Boolean.parseBoolean(this.name = name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public int getNumberSchool() {
        return numberSchool;
    }

    public void setNumberSchool(int numberSchool) {
        this.numberSchool = numberSchool;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
