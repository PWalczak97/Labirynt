package com.company;

import com.sun.prism.paint.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Main  extends JPanel{

    static ArrayList<Cell> labiryntLista = new ArrayList<>();
    static int wielkosc = 15;

    public static void main(String[] args) {


        int x = 0;
        int y = 0;
        for(int i =0;i<wielkosc;i++){

            for(int j =0;j<wielkosc;j++){
                Cell cell = new Cell(x,y);
                labiryntLista.add(cell);
                x+=50;
            }
            x=0;
            y+=50;
        }

        pracka();
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main okno = new Main();
        window.add(okno);
        window.setVisible(true);
        window.pack();



    }

    public static void pracka(){

        ArrayList<Cell> stack = new ArrayList<>();
        labiryntLista.get(0).setCzyOtwartaLewa(true);
        labiryntLista.get(labiryntLista.size()-1).setCzyOtwartaPrawa(true);
        stack.add(labiryntLista.get(0));

        while(!stack.isEmpty()){
            Cell obecna = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            ArrayList<Cell> nieodwiedzone = new ArrayList<>();


            for(int i =0;i<labiryntLista.size();i++){

                //lewa

                if(labiryntLista.get(i).getX()==obecna.getX()-50&&labiryntLista.get(i).getY()==obecna.getY()
                        &&labiryntLista.get(i).isCzyOdwiedzona()==false){
                    nieodwiedzone.add(labiryntLista.get(i));
                }
                //prawa
                if(labiryntLista.get(i).getX()==obecna.getX()+50&&labiryntLista.get(i).getY()==obecna.getY()
                        &&labiryntLista.get(i).isCzyOdwiedzona()==false){
                    nieodwiedzone.add(labiryntLista.get(i));
                }
                //gora
                if(labiryntLista.get(i).getX()==obecna.getX()&&labiryntLista.get(i).getY()==obecna.getY()+50
                        &&labiryntLista.get(i).isCzyOdwiedzona()==false){
                    nieodwiedzone.add(labiryntLista.get(i));
                }
                //dol
                if(labiryntLista.get(i).getX()==obecna.getX()&&labiryntLista.get(i).getY()==obecna.getY()-50
                        &&labiryntLista.get(i).isCzyOdwiedzona()==false){
                    nieodwiedzone.add(labiryntLista.get(i));
                }
            }

            if(!nieodwiedzone.isEmpty()){
                stack.add(obecna);
                int random = (int)(Math.random()*nieodwiedzone.size());
                //lewa
                if(nieodwiedzone.get(random).getX()==obecna.getX()-50&&nieodwiedzone.get(random).getY()==obecna.getY()){
                    nieodwiedzone.get(random).setCzyOtwartaPrawa(true);
                    obecna.setCzyOtwartaLewa(true);
                }
                //prawa
                if(nieodwiedzone.get(random).getX()==obecna.getX()+50&&nieodwiedzone.get(random).getY()==obecna.getY()){
                    nieodwiedzone.get(random).setCzyOtwartaLewa(true);
                    obecna.setCzyOtwartaPrawa(true);
                }
                //dol
                if(nieodwiedzone.get(random).getX()==obecna.getX()&&nieodwiedzone.get(random).getY()==obecna.getY()+50){
                    nieodwiedzone.get(random).setCzyOtwartaGora(true);
                    obecna.setCzyOtwartyDol(true);
                }
                //gora
                if(nieodwiedzone.get(random).getX()==obecna.getX()&&nieodwiedzone.get(random).getY()==obecna.getY()-50){
                    nieodwiedzone.get(random).setCzyOtwartyDol(true);
                    obecna.setCzyOtwartaGora(true);
                }

                nieodwiedzone.get(random).setCzyOdwiedzona(true);
                stack.add(nieodwiedzone.get(random));

            }

        }

        for(int i =0;i<labiryntLista.size();i++)
            labiryntLista.get(i).setCzyOdwiedzona(false);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(wielkosc*50,wielkosc*50);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);


        rysujLabirynt(g);

    }

    public void rysujLabirynt(Graphics g){

        for(int i =0;i<labiryntLista.size();i++) {
            g.setColor(Color.gray);
            g.fillRect(labiryntLista.get(i).getX(), labiryntLista.get(i).getY(), 50, 50);
            if (!labiryntLista.get(i).isCzyOtwartaGora()) {
                g.setColor(Color.BLACK);
                g.fillRect(labiryntLista.get(i).getX(), labiryntLista.get(i).getY(), 50, 5);
            }
            if (!labiryntLista.get(i).isCzyOtwartyDol()) {
                g.setColor(Color.BLACK);
                g.fillRect(labiryntLista.get(i).getX(), labiryntLista.get(i).getY() + 45, 50, 5);
            }
            if (!labiryntLista.get(i).isCzyOtwartaLewa()) {
                g.setColor(Color.BLACK);
                g.fillRect(labiryntLista.get(i).getX(), labiryntLista.get(i).getY(), 5, 50);
            }
            if (!labiryntLista.get(i).isCzyOtwartaPrawa()) {
                g.setColor(Color.BLACK);
                g.fillRect(labiryntLista.get(i).getX() + 45, labiryntLista.get(i).getY(), 5, 50);

            }

            if(labiryntLista.get(i).isCzyOdwiedzona()){
                g.setColor(Color.GREEN);
                g.fillRect(labiryntLista.get(i).getX()+5,labiryntLista.get(i).getY()+5,40,40);
            }


        }




    }
}

