package org.example;

public class Lambda{

    public static void main(String[] arg){
        //sending method implementation as an object of the interface

        Printable imp = () -> System.out.println("Good Morning");
        printAny(() -> System.out.println("Hello World"));
        printAny(imp);

        Printable2 imp2 = (e, f) -> System.out.println(f + " Good Luck" + e);
        printAny2((a, b) -> System.out.println(b + " Very Good" + a));
        printAny2(imp2);

        String s = getString(() -> "Hussain");
        System.out.println(s);

        Printable3 p3 = new Printable3(){

            @Override
            public String myString(){
                return "Help";
            }
        };
        System.out.println(p3.printString());
        System.out.println(p3.getClass().getName());
    }

    static void printAny(Printable p){

        p.print();
    }

    static void printAny2(Printable2 p){

        p.print("!!!", "->");
    }

    static String getString(Printable3 p){

        return p.myString();
    }
}

interface Printable{

    void print();
}

interface Printable2{

    void print(String s, String p);
}

interface Printable3{

    String myString();

    default String printString(){return myString();}
}