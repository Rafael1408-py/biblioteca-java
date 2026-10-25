package pratica;

import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] livros = new String[10];
        String[] emprestados = new String[10];
        int quantidadeEmprestimos = 0;
        int quantidade = 0;
        int op = 1;
        boolean querContinuar = true;
        

        while (op != 0) {

        

        System.out.println("Escolha a opção:");
        System.out.println("1 - Cadastrar um livro á biblioteca");
        System.out.println("2 - Consultar livros e preços");
        System.out.println("3 - Fazer o emprestimo de um livro");
        System.out.println("4 - Devolver livro");
        System.out.println("0 - Sair");

        op = sc.nextInt();
        sc.nextLine();


            if (op == 1 ){
                querContinuar = true;
                while (querContinuar && quantidade < livros.length) {

            System.out.println("Digite o nome do livro:");
            livros[quantidade] = sc.nextLine();
            quantidade++;

            System.out.println("Quer cadastrar outro livro? [S/N]");
            String resposta = sc.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                querContinuar = true;
            } else if (resposta.equalsIgnoreCase("N")) {
                querContinuar = false;
            } else {
                System.out.println("Digite S ou N.");
                querContinuar = false;
            }
        }
            }
            if (op == 2 && querContinuar == true) {
                for(int i = 0 ; i < quantidade ; i++){
                    System.out.println(livros[i]);
                    }
                
        }

            if (op == 3) {
    System.out.println("Escreva o livro que quer pegar:");
    String escolha = sc.nextLine();
    boolean livroEncontrado = false;

    for (int i = 0; i < quantidade && livroEncontrado == false; i++) {

        if (escolha.equalsIgnoreCase(livros[i])) {

            if (quantidadeEmprestimos < emprestados.length) {
                livroEncontrado = true;

                emprestados[quantidadeEmprestimos] = livros[i];
                quantidadeEmprestimos++;

                for (int j = i; j < quantidade - 1; j++) {
                    livros[j] = livros[j + 1];
                }

                quantidade--;

                System.out.println(
                    "Livro encontrado, você tem 30 dias para devolvê-lo."
                );

            } else {
                livroEncontrado = true;
                System.out.println("Não há espaço para mais empréstimos.");
            }
        }
    }

    if (livroEncontrado == false) {
        System.out.println("Livro não encontrado.");
    }
}

            if (op == 4) {
    System.out.println("Informe o livro que quer devolver:");
    String devolva = sc.nextLine();
    boolean livroEncontrado = false;

    for (int i = 0; i < quantidadeEmprestimos && livroEncontrado == false; i++) {
        if (devolva.equalsIgnoreCase(emprestados[i])) {

            if (quantidade < livros.length) {
                livroEncontrado = true;

                livros[quantidade] = emprestados[i];
                quantidade++;

                for (int j = i; j < quantidadeEmprestimos - 1; j++) {
                    emprestados[j] = emprestados[j + 1];
                }

                quantidadeEmprestimos--;

                System.out.println("Livro devolvido.");
            }
        }
    }

    if (livroEncontrado == false) {
        System.out.println("Livro não encontrado nos empréstimos.");
    }
}

    }
    System.out.println("Sistema fechado, até a próxima.");
}
}
