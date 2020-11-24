package Zadanie1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel {
    private ArrayList<Kula> listaKul;
    private int size = 25;
    private Timer timer;
    private String message = "";
    private final int DELAY =16;
    public Panel(){
        listaKul = new ArrayList<>();
        setBackground(Color.BLACK);
        addMouseListener(new Event());
        addMouseWheelListener(new Event());
        timer = new Timer(DELAY, new Event());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Kula k : listaKul){
            g.setColor(k.color);
            g.drawOval(k.x, k.y, k.size, k.size);
        }
        g.setColor(Color.YELLOW);
        g.drawString(Integer.toString(listaKul.size()),40,40);
        g.drawString(""+size, 40, 60);
        g.drawString(message, 40, 20);
    }

    private class Event implements MouseListener, ActionListener, MouseWheelListener{
        @Override
        public void mouseClicked(MouseEvent e){
            message = "Zaczynamy.";
        }

        @Override
        public void mousePressed(MouseEvent e) {
            listaKul.add(new Kula(e.getX(), e.getY(), size));
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            message = "Można oglądać.";
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            message = "Wracamy do oglądania.";
        }

        @Override
        public void mouseExited(MouseEvent e) {
            message = "Opuściłeś oglądanie.";
        }

        @Override
        public void actionPerformed(ActionEvent e){
            for(Kula k : listaKul){
                k.update();
            }
            repaint();
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e){
            int scroll = e.getWheelRotation();
            if(scroll < 0 ) size++;
            else size--;
        }
    }

    private class Kula{
        public int x, y, size, xspeed, yspeed;
        public Color color;
        private final int MAX_SPEED = 5;

        public Kula(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
            do {
                xspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
                yspeed = (int) (Math.random() * MAX_SPEED * 2 - MAX_SPEED);
            }while(xspeed == 0 || yspeed == 0);
        }
        public void update() {
            x += xspeed;
            y += yspeed;
            if (x <= 0 || x >= getWidth()-size) xspeed = -xspeed;
            if (y <= 0 || y >= getHeight()-size) yspeed = -yspeed;
            for (Kula k : listaKul) {
                double odleglosc =  Math.pow((k.x+(size/2.0) - this.x+(size/2.0)), 2) + Math.pow((k.y+(size/2.0) - this.y+(size/2.0)), 2);
                double sumaPromieni = Math.pow(((double)k.size/2 + (double)this.size/2), 2);
                if (odleglosc <= sumaPromieni) {
                    int robxspeed, robyspeed;
                    robxspeed = this.xspeed;
                    robyspeed = this.yspeed;
                    this.xspeed = k.xspeed;
                    this.yspeed = k.yspeed;
                    k.xspeed = robxspeed;
                    k.yspeed = robyspeed;
                    //zderzenia(k);
                }
            }

        }
/*
        public void zderzenia(Kula k2){
            Wektor normalny = new Wektor(x, y, k2.x, k2.y);
            normalny = normalny.normalny();
            Wektor styczny = normalny.prostopadly();

            Wektor v1 = new Wektor(xspeed, yspeed);
            Wektor v2 = new Wektor(k2.xspeed, k2.yspeed);

            double v1n = normalny.iloczynSkalarny(v1);
            double v2n = normalny.iloczynSkalarny(v2);
            double v1n2 = (v1n * (size-k2.size) + 2 * k2.size * v2n)/(size + k2.size);
            double v2n2 = (v2n * (k2.size-size) + 2 * size * v1n)/(size + k2.size);

            Wektor v12n = normalny.mnozPrzezSkalar(v1n2);
            Wektor v22n = normalny.mnozPrzezSkalar(v2n2);

            double v1s = styczny.iloczynSkalarny(v1);
            double v2s = styczny.iloczynSkalarny(v2);

            Wektor v12s = styczny.mnozPrzezSkalar(v1s);
            Wektor v22s = styczny.mnozPrzezSkalar(v2s);

            Wektor v12 = v12n.dodaj(v12s);
            Wektor v22 = v22n.dodaj(v22s);

            xspeed = (int)(v12.x > 0 ? Math.ceil(v12.x) : Math.floor(v12.x));
            yspeed = (int)(v12.y > 0 ? Math.ceil(v12.y) : Math.floor(v12.y));
            k2.xspeed = (int)(v22.x > 0 ? Math.ceil(v22.x) : Math.floor(v22.x));
            k2.yspeed = (int)(v22.y > 0 ? Math.ceil(v22.y) : Math.floor(v22.y));
        }
        private class Wektor{
            public double x, y;

            public Wektor(double x, double y){
                this.x = x;
                this.y = y;
            }
            public Wektor(double xp, double yp, double xk, double yk){
                x = xk - xp;
                y = yk - yp;
            }
            public Wektor normalny(){
                double l = Math.sqrt(x*x + y*y);
                return new Wektor(x/l, y/l);
            }
            public Wektor prostopadly(){
                return new Wektor(-y, x);
            }
            public double iloczynSkalarny(Wektor w2){
                return x * w2.x + y * w2.y;
            }
            public Wektor mnozPrzezSkalar(double s){
                return new Wektor(s*x, s*y);
            }
            public Wektor dodaj(Wektor w2){
                return new Wektor(x + w2.x, y + w2.y);
            }
        }*/
    }
}



