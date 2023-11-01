package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class QuartoSingle implements QuartoI{
    private int vagas;
    private double valorBasico;
    private double valorPessoa;
    private int id;
    private double valorDiaria;



    public QuartoSingle(double valorBasico, double valorPessoa, int id) {
        this.vagas = 1;
        this.valorBasico = valorBasico;
        this.valorPessoa = valorPessoa;
        this.id = id;
        this.valorDiaria = valorBasico * valorPessoa;

    }

    @Override
    public String toString() {
        return "[" + this.id + "] Quarto Single (custo basico: R$" + this.valorBasico + "; adicional por pessoa: R$" + this.valorPessoa + " >>> R$" + this.valorDiaria + " diária)";
    }

    @Override
    public Double getValorBasico() {
        return this.valorBasico;
    }

    @Override
    public int getVagas() {
        return vagas;
    }

    @Override
    public double getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public int getId() {
        return id;
    }

    public double getValorPessoa() {
        return valorPessoa;
    }
}
