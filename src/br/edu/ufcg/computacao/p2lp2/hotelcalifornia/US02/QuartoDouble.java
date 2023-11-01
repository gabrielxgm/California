package br.edu.ufcg.computacao.p2lp2.hotelcalifornia.US02;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class QuartoDouble implements QuartoI{
    private int vagas;
    private double valorBasico;
    private double valorPessoa;
    private int id;
    private double valorDiaria;
    private String listaPedidos;




    public QuartoDouble(double valorBasico, double valorPessoa, int id, String Pedidos) {
        this.valorBasico = valorBasico;
        this.valorPessoa = valorPessoa;
        this.id = id;
        this.vagas = 2;
        this.valorDiaria = valorBasico + (valorPessoa * 2);
        this.listaPedidos = formataListaPedidos(Pedidos);

    }

    public QuartoDouble(double valorBasico, double valorPessoa, int id) {
        this.valorBasico = valorBasico;
        this.valorPessoa = valorPessoa;
        this.id = id;
        this.vagas = 2;
        this.valorDiaria = valorBasico + (valorPessoa * 2);
        this.listaPedidos = "(nenhum)";

    }

    @Override
    public String toString() {
        return "[" + this.id + "] Quarto Double (custo basico: R$" + this.valorBasico + ", adicional por pessoa: R$" + this.valorPessoa + " >>> R$" + this.valorDiaria + " diária). Pedidos: " + this.listaPedidos ;
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
