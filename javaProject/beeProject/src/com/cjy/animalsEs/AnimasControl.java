package com.cjy.animalsEs;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/*将动物信息（种类，性别，年龄）保存在集合中（可以先保存一部分，再添加新的；也可以后面录入。在
这里要不同的动物可能会有不同的属性）在控制台输入指令，系统可以对动物信息进行基本的增加、删除、修
改、查询、对年龄进行排序然后输出像C语言题库里面的那种菜单式的系统，如输入1进行...操作，输入2进行...操作
考察内容：面向对象，泛型，异常，集合*/
public class AnimasControl {
    public static void main(String[] args) {
        TreeSet<Animals> set = new TreeSet();
        while (true) {
            System.out.println("------------Wellcome To Animals System!--------------");
            System.out.println("(1):添加动物信息                       (2):修改动物信息");
            System.out.println("(3):删除动物信息                       (4):查询数据");
            System.out.println("(5)：退出系统");
            System.out.println("-----------------------------------------------------");
            try {
                System.out.println("请选择数字：");
                Scanner sc = new Scanner(System.in);
                int number = sc.nextInt();
                switch (number) {
                    case 1:
                        add(set);
                        break;
                    case 2:
                        alert(set);
                        break;
                    case 3:
                        del(set);
                        break;
                    case 4:
                        check(set);
                        break;
                    case 5:
                        System.out.println("感谢您的使用！");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("没有该功能，请重新输入：");
                        break;
                }
            }catch (RuntimeException e){
                System.out.println("输入类型错误或没有该功能！请重新输入");
                return;
            }
        }
    }
    public static void check(TreeSet<Animals> set){
        System.out.println("请输入要查询的动物品种：");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        for(Object obj:set){
            Animals o1=(Animals)obj;
            if(o1.getName().equals(name)){
                System.out.println("种类："+o1.getName()+"年龄："+
                        o1.getAge()+"性别："+o1.getSex());
                return;
            }
        }
        System.out.println("没有该动物的信息！");
        return;
    }
    public static void add(TreeSet<Animals> set) {
        Scanner sc = new Scanner(System.in);
        try{System.out.println("请输入动物种类：");
        String name = sc.next();
        System.out.println("请输入动物年龄：");
        int age = sc.nextInt();
        System.out.println("请输入动物性别：");
        String sex = sc.next();
        Animals animal = new Animals();
        animal.setAge(age);
        animal.setName(name);
        animal.setSex(sex);
        set.add(animal);}catch (RuntimeException e){
           System.out.println("输入类型错误,请重新输入:");
           return;
        }
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            Animals t=(Animals)iterator.next();
            System.out.println("种类："+t.getName()+"年龄："+t.getAge()+
                    "性别："+t.getSex());
        }
        System.out.println("添加动物成功！");
    }


    public static int del(TreeSet set){
        System.out.println("请输入需要删除动物的姓名：");
        try{Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        if(set.size()==0)
        {
            System.out.println("无动物信息可以删除！");
            return 0;
        }
        Boolean b=true;
        for(Object o2:set ) {
            Animals o3 = (Animals) o2;
            if (o3.getName().equals(str)) {
                b = true;
            }else {
                b=false;
            }
        }
        if(b==true){
        for (Object o : set) {
            Animals o1 = (Animals) o;
            if (o1.getName().equals(str)){
                set.remove(o);
            }
        }
        }
        if(b==false){
            System.out.println("没有该动物的信息！");
            return 0;
        }
        }catch (RuntimeException e){
            System.out.println("输入的类型错误，请重新输入：");
            return 0;
        }
        System.out.println("删除成功!");
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            Animals t=(Animals)iterator.next();
            System.out.println("种类："+t.getName()+"年龄："+t.getAge()+"性别："+
                    t.getSex());
        }
        return 0;
    }
    public static int alert(TreeSet set){
        System.out.println("请输入所需修改动物种类：");
        try {
            Scanner input = new Scanner(System.in);
            String str;
            str = input.nextLine();
            for (Object o : set) {
                Animals o1 = (Animals) o;
                if (o1.getName().equals(str)) {
                    System.out.println("请选择所需修改的信息,1、年龄2、性别：");
                    int a = input.nextInt();
                    if (a == 1) {

                        System.out.println("请输入修改后的数值：");
                        int age = input.nextInt();
                        o1.setAge(age);

                    } else {
                        System.out.println("请输入修改后的性别：");
                        String sex = input.next();
                        o1.setSex(sex);
                    }
                    System.out.println("修改成功！");
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Animals t = (Animals) iterator.next();
                        System.out.println("种类：" + t.getName() + "年龄：" +
                                t.getAge() + "性别：" + t.getSex());
                    }
                    return 0;
                }
            }
        }catch (RuntimeException e){
            System.out.println("输入的类型错误，请重新输入：");
            return 0;
        }
       return 0;
    }
}


