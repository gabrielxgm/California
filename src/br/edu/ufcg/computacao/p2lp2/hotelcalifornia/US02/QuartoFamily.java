package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class QuartoFamily implements QuartoI{
    private int vagas;
    private double valorBasico;
    private double valorPessoa;
    private int id;
    private double valorDiaria;
    private String listaPedidos;



    public QuartoFamily(int vagas, double valorBasico, double valorPessoa, int id, String Pedidos) {
        this.vagas = vagas;
        this.valorBasico = valorBasico;
        this.valorPessoa = valorPessoa;
        this.id = id;
        this.valorDiaria = valorBasico + (valorPessoa * vagas);
        this.listaPedidos = formataListaPedidos(Pedidos);

    }

    public QuartoFamily(int vagas, double valorBasico, double valorPessoa, int id) {
        this.vagas = vagas;
        this.valorBasico = valorBasico;
        this.valorPessoa = valorPessoa;
        this.id = id;
        this.valorDiaria = valorBasico + (valorPessoa * vagas);
        this.listaPedidos = "(nenhum)";

    }

    @Override
    public String toString() {

        return null;
    }

    @Override
    public Double getValorBasico() {
        return this.valorBasico;
    }

    public double getValorPessoa() {
        return valorPessoa;
    }

    @Override
    public int getVagas() {
        return vagas;
    }

    @Override
    public double getValorDiaria() {
        return valorDiaria;
    }


    private String formataListaPedidos(String Pedidos){
        return "[" + Pedidos + "]";
    }

    @Override
    public int getId() {
        return id;
    }
}
