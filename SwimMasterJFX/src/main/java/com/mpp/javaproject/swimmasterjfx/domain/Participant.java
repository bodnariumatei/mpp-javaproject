package com.mpp.javaproject.swimmasterjfx.domain;

public class Participant extends Entity<Integer> {
    private String nume;
    private int varsta;
    public Participant(Integer id, String nume, int varsta) {
        super(id);
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getnume() {
        return nume;
    }

    public void setnume(String nume) {
        this.nume = nume;
    }

    public int getvarsta() {
        return varsta;
    }

    public void setvarsta(int varsta) {
        this.varsta = varsta;
    }
}
