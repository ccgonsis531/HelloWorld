package day02;

import sun.security.krb5.internal.ccache.CCacheInputStream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeset {
    public static void main(String[] args) {
//        Set<Integer> set = new TreeSet<Integer>();
//
//        set.add(5);
//        set.add(2);
//        set.add(4);
//        set.add(3);
//
//        System.out.println(set);
//
//        Iterator<Integer> it = set.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        //更好用
//        for (Integer i : set){
//            System.out.println(i);
//        }
        Person p1 = new Person("cc1", 12 );
        Person p2 = new Person("cc2", 15);
        Person p3 = new Person("cc3", 10);
        Person p4 = new Person("cc4", 16);

        Set<Person> set = new TreeSet<Person>(new Person());
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        for (Person p : set){
            System.out.println(p.name + "   " + p.age);
        }

    }
}

/**
 * 1.可以使用一个专门存放重写后的comparator比较方法的类implements Comparator，并用此来启动Treeset（第35行）。
 * 2.也可以将Person类和该方法合并，但Person类中必须有一个public Person（）{} 的空方法来启动Treeset
 * 3.还有种方式实现该目标，同2一样，只不过不需要再Person类中加入空方法，而是在启动Treeset时（第35行）给其赋予一个随意的初始值即可。e.g.
 * Set<Person> set = new TreeSet<Person>(new Person("cc", 0))
 */

class Person implements Comparator<Person> {
    int age;
    String name;

    public Person(){

    }

    public Person(String name, int age){
        this.age = age;
        this.name = name;

    }

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.age > o2.age){
            return 1;
        }else if (o1.age < o2.age){
            return -1;
        }else{
            return 0;
        }
    }
}


