package view;

import java.util.Scanner;

import controller.CTRLFeriado;


public class Main {   
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Nome do feriado:");
    	String nomeFeriado=sc.nextLine();
    	CTRLFeriado feriado=new CTRLFeriado();
    	feriado.lerEApresentarData(nomeFeriado);
    }
}

