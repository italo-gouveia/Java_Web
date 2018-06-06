package br.com.italo.springrest.avaliacaodesoftware.domain;

public enum Grupo {

    ADMIN('A'), BASIC('B');

    private char desc;

    Grupo(char desc) {
        this.desc = desc;
    }

    public char getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
	
}
