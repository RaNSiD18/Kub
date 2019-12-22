package com.company;
import javax.swing.*;
import java.awt.*;

public class Cube {
    private Facet[] facets;

    public Cube(){
        facets = new Facet[6];
        facets[0]= new Facet(new R3Vector(0, 0, 0), new R3Vector(1, 0, 0), new R3Vector(1, 1, 0), new R3Vector(0, 1, 0));
        facets[0].set_color(Color.green);
        facets[1]= new Facet(new R3Vector(1, 0, 1), new R3Vector(1, 1, 1), new R3Vector(1, 1, 0), new R3Vector(1, 0, 0));
        facets[1].set_color(Color.yellow);
        facets[2]= new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 1, 0), new R3Vector(0, 1, 1), new R3Vector(0, 0, 1));
        facets[2].set_color(Color.orange);
        facets[3]= new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 0, 1), new R3Vector(1, 0, 1), new R3Vector(1, 0, 0));
        facets[3].set_color(Color.red);
        facets[4]= new Facet(new R3Vector(0, 1, 0), new R3Vector(1, 1, 0), new R3Vector(1, 1, 1), new R3Vector(0, 1, 1));
        facets[4].set_color(Color.green);
        facets[5]= new Facet(new R3Vector(0, 0, 1), new R3Vector(0, 1, 1), new R3Vector(1, 1, 1), new R3Vector(1, 0, 1));
        facets[5].set_color(Color.magenta);
    }

    public void draw(Graphics2D g){
        for(int i = 0; i < facets.length; i++){
            facets[i].draw(g);
        }
    }

    public void drawPers(Graphics2D g, double p){
        for(int i = 0; i<facets.length; i++){
            facets[i].drawPers(g, p);
        }
    }

    public void rotate(double ux, double uy, double uz){
        for(int i=0; i<facets.length; i++){
            facets[i].rotate(ux,uy,uz);
        }
    }

    public void scale(double k){
        for(int i=0; i<facets.length; i++){
            facets[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz) {
        for(int i=0; i<facets.length; i++){
            facets[i].translate(dx,dy,dz);
        }
    }
}
