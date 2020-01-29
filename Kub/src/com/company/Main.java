package com.company;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static int K, x1, y1, z1, x2, y2, z2;

    public static void main(String[] args) {
        //Scanner Ko = new Scanner(System.in);

        //System.out.println("Введите на сколько сместить вектор 1 по x, y, z: ");
        //x1 = Ko.nextInt();
        //y1 = Ko.nextInt();
        //z1 = Ko.nextInt();
        //System.out.println("Введите на сколько сместить вектор 2 по x, y, z: ");
        //x2 = Ko.nextInt();
        //y2 = Ko.nextInt();
        //z2 = Ko.nextInt();

       //R3Vector a = new R3Vector(10+x1,20+y1,30+z1);
       //R3Vector b = new R3Vector(30+x2,20+y2,10+z2);
       //a.out();
       //b.out();
       //a.sum(a);

       //R3Vector.sum(R3Vector.sum(a,a), R3Vector.sum(a,a)).out();
       //R3Vector.skal(a, b);

      // a.rotateZ(90);
        //a.out();

        //Facet f = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0), new R3Vector(0,1,0));
        //f.print();


        Cube cube = new Cube();
        cube.scale(100);
        cube.rotate(125,125,125);
        Viewer v = new Viewer(cube);
        Controller с = new Controller(cube,v);
       //a.sum(a).sum(a.sum(a)).out(); //a.sum(a) - Результат суммы векторов. Далее мы используем метод out для вывода результата суммы. a.sum(a.sum(a)) - результат суммы трех векторов.  a.sum(a).sum(a.sum(a)) - результат суммы четырех векторов.
    }
}
