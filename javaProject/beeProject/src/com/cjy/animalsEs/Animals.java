package com.cjy.animalsEs;

import java.util.Collection;
import java.util.TreeSet;

public class Animals  implements Comparable {
    private String name;
    private int age;
    private String sex;

    public Animals() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Object o) {
        Animals o1 = (Animals) o;
        if (this.age > o1.age) {
            return 1;
        } else if (this.age < o1.age) {

            return -1;
        } else  {

            return 0;
        }
    }
}
