package com.company;

import java.awt.*;

public class R3Vector {
    private double x,y,z;
    public static double sproiz, vproiz;

    public R3Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void out(){
        System.out.println("("+ x +", "+ y +", "+ z +")");
    }
    public R3Vector sum(R3Vector a){
       return new R3Vector(x+a.x, y+a.y, z+a.z); // Вычисляем сумму векторов и сразу выводим резульат.
    }
    public static R3Vector sum(R3Vector a, R3Vector b){
        return new R3Vector(a.x + b.x, a.y + b.y, a.z + b.z);
    }
    public static void skal(R3Vector a, R3Vector b){
       sproiz = Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z)*Math.sqrt(b.x * b.x + b.y * b.y + b.z * b.z)*(a.x*b.x + a.y*b.y + a.z*b.z)/(Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z) * Math.sqrt(b.x * b.x + b.y * b.y + b.z * b.z));
       System.out.println("Скалярное произведение: " + sproiz);
    }


    public static R3Vector Vector(R3Vector a, R3Vector b){
        return new R3Vector((a.y*b.z-a.z*b.y), a.z*b.x-a.x*b.z, a.x*b.y-a.y*b.x);
    }

    public void scale(double k){
        this.x = this.x*k;
        this.y = this.y*k;
        this.z = this.z*k;
    }
    public void translate(double dx, double dy, double dz){
        this.x = this.x+dx;
        this.y = this.y+dy;
        this.z = this.z+dz;
    }
    public void rotateZ(double deg){
        double x;
        double y;
        x = this.x*Math.cos(Math.toRadians(deg)) + this.y*Math.sin(Math.toRadians(deg));
        y = this.y*Math.cos(Math.toRadians(deg)) - this.x*Math.sin(Math.toRadians(deg));
        this.x = x;
        this.y = y;
    }
    public void rotateY(double deg){
        double x;
        double z;
        x = this.x*Math.cos(Math.toRadians(deg)) + this.z*Math.sin(Math.toRadians(deg));
        z = this.z*Math.cos(Math.toRadians(deg)) - this.x*Math.sin(Math.toRadians(deg));
        this.x = x;
        this.z = z;
    }
    public void rotateX(double deg){
        double y;
        double z;
        y = this.y*Math.cos(Math.toRadians(deg)) + this.z*Math.sin(Math.toRadians(deg));
        z = this.z*Math.cos(Math.toRadians(deg)) - this.y*Math.sin(Math.toRadians(deg));
        this.y = y;
        this.z = z;
    }
    public void rotate(double ux, double uy, double uz){
        rotateX(ux);
        rotateY(uy);
        rotateZ(uz);
    }
    public double GetX(){
        return this.x;
    }
    public double GetY(){
        return this.y;
    }
    public double GetZ(){
        return this.z;
    }
    public static R3Vector diagonals(R3Vector vector1, R3Vector vector2){
        return new R3Vector(vector2.x-vector1.x, vector2.y-vector1.y, vector2.z-vector1.z);
    }
    public static R3Vector normal(R3Vector vector1, R3Vector vector2){
        return R3Vector.Vector(vector1, vector2);
    }

}
