package com.company;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] vertex;
    public static int i;
    private Color color;
    private Random r = new Random();

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4){
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        this.color = color;
    }

    public void print(){
        for(i=0; i<4; i++){
            if (i == 3){
                vertex[3].out();
                System.out.println(" - ");
                vertex[0].out();
                System.out.println("");
                return;
            }
        vertex[i].out();
        System.out.println(" - ");
        vertex[i+1].out();
        System.out.println("");
        }
    }

    public void rotate(double ux, double uy, double uz){
        for (int i = 0; i<vertex.length; i++)
            vertex[i].rotate(ux, uy, uz);
    }

    public void scale(double k){
        for(int i=0; i<vertex.length; i++){
            vertex[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz){
        for(int i=0; i<vertex.length; i++){
            vertex[i].translate(dx,dy,dz);
        }
    }

    public void draw(Graphics2D g){
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].GetX(), vertex[0].GetY());
        path.lineTo(vertex[1].GetX(), vertex[1].GetY());
        path.lineTo(vertex[2].GetX(), vertex[2].GetY());
        path.lineTo(vertex[3].GetX(), vertex[3].GetY());
        path.lineTo(vertex[0].GetX(), vertex[0].GetY());
        path.closePath();
        if(light()){
            g.setColor(this.color);
            g.fill(path);
        }
    }

    public void drawPers(Graphics2D g, double p){
        Path2D path = new Path2D.Double();
        double t[] = new double[4];
        R3Vector[] vertex1 = new R3Vector[4];
        for (int i = 0; i < 4; i++)
        {
            t[i] = -p/(vertex[i].GetZ()-p);
            vertex1[i] = new R3Vector(vertex[i].GetX()*t[i], vertex[i].GetY()*t[i], vertex[i].GetZ());
        }
        path.moveTo(vertex1[0].GetX(), vertex1[0].GetY());
        path.lineTo(vertex1[1].GetX(), vertex1[1].GetY());
        path.lineTo(vertex1[2].GetX(), vertex1[2].GetY());
        path.lineTo(vertex1[3].GetX(), vertex1[3].GetY());
        path.lineTo(vertex1[0].GetX(), vertex1[0].GetY());
        path.closePath();
        Facet facet = new Facet(vertex1[0], vertex1[1], vertex1[2], vertex1[3]);
        if(light()){
            g.setColor(this.color);
            g.fill(path);
        }
    }


    public boolean light(){
        if(R3Vector.normal(R3Vector.diagonals(vertex[0], vertex[1]),R3Vector.diagonals(vertex[0], vertex[3])).GetZ()<=0){
            return true;
        }else
            return false;
    }
    public void set_color(Color color){
        this.color = color;
    }
}
