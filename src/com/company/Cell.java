package com.company;

public class Cell {
    private int x;
    private int y;
    private boolean czyOtwartaPrawa;
    private boolean czyOtwartaLewa;
    private boolean czyOtwartaGora;
    private boolean czyOtwartyDol;
    private boolean czyOdwiedzona;

    public Cell(int x, int y){
        this.x=x;
        this.y=y;
        this.czyOtwartaPrawa = false;
        this.czyOtwartaLewa = false;
        this.czyOtwartaGora = false;
        this.czyOtwartyDol = false;
        this.czyOdwiedzona = false;

    }

    public boolean isCzyOdwiedzona() {
        return czyOdwiedzona;
    }

    public void setCzyOdwiedzona(boolean czyOdwiedzona) {
        this.czyOdwiedzona = czyOdwiedzona;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCzyOtwartaPrawa() {
        return czyOtwartaPrawa;
    }

    public boolean isCzyOtwartaLewa() {
        return czyOtwartaLewa;
    }

    public boolean isCzyOtwartaGora() {
        return czyOtwartaGora;
    }

    public boolean isCzyOtwartyDol() {
        return czyOtwartyDol;
    }

    public void setCzyOtwartaPrawa(boolean czyOtwartaPrawa) {
        this.czyOtwartaPrawa = czyOtwartaPrawa;
    }

    public void setCzyOtwartaLewa(boolean czyOtwartaLewa) {
        this.czyOtwartaLewa = czyOtwartaLewa;
    }

    public void setCzyOtwartaGora(boolean czyOtwartaGora) {
        this.czyOtwartaGora = czyOtwartaGora;
    }

    public void setCzyOtwartyDol(boolean czyOtwartyDol) {
        this.czyOtwartyDol = czyOtwartyDol;
    }
}

