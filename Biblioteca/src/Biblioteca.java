
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author 1-2023229296
 */
public class Biblioteca {
    Scanner sc = new Scanner(System.in);
    private  List<Livro> acervo;


    public Biblioteca()  {
        this.acervo = new ArrayList <> ();


    }
    public void adicionarLivro(){
        String resposta;
        do
        {


            System.out.println("Nome do livro:");
            String nomeLivro = sc.nextLine();

            System.out.println("Autor do livro:");
            String autorLivro = sc.nextLine();

            System.out.println("Editora do livro:");
            String editoraLivro = sc.nextLine();


            System.out.println("ISBN do livro:");
            String ISBN = sc.nextLine();

            boolean encontrado = false;
            for(Livro livro : acervo) {
                if(livro.getISBN().toLowerCase().contains(ISBN.toLowerCase())){
                    System.out.println("ERRO! IBSN JÁ PRESENTE NA BIBLIOTECA ");
                    encontrado = true;

                }
            } if (!encontrado){

            System.out.println("Ano do livro:");
            int anoLivro = sc.nextInt();

            System.out.println("Quantidade de livro:");
            int quantidadeLivro = sc.nextInt();
            sc.nextLine();

            Livro livroRec = new Livro (nomeLivro, autorLivro, editoraLivro, anoLivro, ISBN, quantidadeLivro);

            acervo.add(livroRec);
            System.out.println("Livro adicionado com sucesso!");

        }System.out.println("Deseja adicionar outro livro? s/n ");
            resposta = sc.nextLine();


        }while(resposta.equalsIgnoreCase("s"));

    }
    public void emprestimo() {
        System.out.println("Nome do usuário: ");
        String usuario = sc.nextLine();
        System.out.println("Livro requisitado: ");
        String livroPedido = sc.nextLine();
        Date dataEmprestimo = new Date();
        Livro livroParaEmprestimo = null;

        for (Livro livro : acervo) {
            if (livroPedido.equalsIgnoreCase(livro.getTitulo())) {
                livroParaEmprestimo = livro;

            }
        }
        if (livroParaEmprestimo != null && livroParaEmprestimo.getQuantidadeDisponivel() > 0) {
            System.out.println(("Empréstimo do livro \"" + livroPedido + "\", pelo usuário \"" + usuario + "\" na data: " + dataEmprestimo));
            livroParaEmprestimo.setQuantidadeDisponivel(livroParaEmprestimo.getQuantidadeDisponivel() - 1);
            System.out.println("Quantidade de livros atualizada: " + livroParaEmprestimo.getQuantidadeDisponivel());
        } else {
            System.out.println("Livro não encontrado ou indisponível para empréstimo.");
        }
    }
    public void devolucao() {
        System.out.println("Nome do usuário: ");
        String usuario = sc.nextLine();
        System.out.println("Livro para devolução: ");
        String livroDevolvido = sc.nextLine();
        Date date = new Date();
        Livro livroDevolucao = null;

        for (Livro livro : acervo) {
            if (livroDevolvido.equalsIgnoreCase(livro.getTitulo())) {
                livroDevolucao = livro;
            }

        }
        if (livroDevolucao != null) {
            System.out.println("Livro Devolvido,pelo usuário " + usuario + " na data de : " + date);
            livroDevolucao.setQuantidadeDisponivel(livroDevolucao.getQuantidadeDisponivel() + 1);
            System.out.println("Quantidade de livros atualizada: " + livroDevolucao.getQuantidadeDisponivel());
        } else {
            System.out.println("Livro não consta no acervo");
        }

    }

    public void exclusaoLivro() {
        System.out.println("Digite o Titulo do Livro que deseja Excluir: ");
        String exclusao = sc.nextLine();

        Livro excluir = null;

        for (Livro livro : acervo) {
            if (exclusao.equalsIgnoreCase(livro.getTitulo())) {
                excluir = livro;

            }
        }
        if (excluir != null) {
            System.out.println("O livro " + excluir.ToString() + " foi removido do acervo");
            acervo.remove(excluir);
        } else {
            System.out.println("Livro não encontrado no sistema;");

        }
        {

        }



    }
    public List<Livro> getAcervo() {
        return acervo;
    }
    public void buscarLivro() {
        System.out.println("Digite o termo a ser pesquisado (título, autor ou ISBN): ");
        String termoBusca = sc.nextLine();

        boolean encontrado = false;
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(termoBusca.toLowerCase()) ||
                    livro.getAutor().toLowerCase().contains(termoBusca.toLowerCase()) ||
                    livro.getISBN().toLowerCase().contains(termoBusca.toLowerCase())) {
                System.out.println("Livro encontrado: " + livro.ToString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Livro não encontrado!");
        }}
    public void atualizarLivro() {
        System.out.println("Digite o ISBN do livro que deseja atualizar: ");
        String attLivro = sc.nextLine();

        boolean encontrado = false;
        for (Livro livro : acervo){
            if (livro.getISBN().toLowerCase().contains(attLivro.toLowerCase())){
                System.out.println("Digite 1 para mudar o Titulo \n ");
                System.out.println("Digite 2 para mudar o Autor \n");
                System.out.println("Digite 3 para mudar a Editora \n");
                System.out.println("Digite 4 para mudar o Ano de Publicação \n");
                System.out.println("Digite 5 para mudar o ISBN \n");
                System.out.println("Digite 6 para mudar a Quantidade \n");
                System.out.println("Digite 7 para sair do menu de Atualização \n");
                int n = sc.nextInt();
                sc.nextLine();

                switch(n){
                    case 1:
                        System.out.println("Digite um novo Titulo para o Livro: ");
                        livro.setTitulo(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Digite um novo Autor para o Livro: ");
                        livro.setAutor(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Digite uma nova Editora para o Livro: ");
                        livro.setEditora(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Digite um novo Ano de Publicação para o Livro: ");
                        livro.setAnoPublicacao(sc.nextInt());
                        sc.nextLine();
                        break;
                    case 5:
                        System.out.println("Digite um novo ISBN para o Livro: ");
                        livro.setISBN(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Digite a nova quantidade do mesmo Livro: ");
                        livro.setQuantidadeDisponivel(sc.nextInt());
                        sc.nextLine();
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opção Invalida!!");
                        return;
                }



                encontrado = true;
                break;
            }

        }
        if(!encontrado){
            System.out.println("Livro com ISBN" + attLivro + "nao encontrado");
        }

    } public void listaLivros(){
        System.out.println("Acervo da Biblioteca");
        for (Livro livro : this.acervo)
        {
            System.out.println(livro.ToString());
        }
    }
    public void menuBiblioteca() {
        boolean continuar = true;
        do{
            System.out.println("Menu:\n 1-Cadastro de Livros\n 2-Busca de Livros\n 3-Atualização de Livros\n 4-Exclusão de Livros\n 5-Empréstimo de Livro \n 6-Devolução de Livros \n 7-Lista de Livros \n 8-Sair da biblioteca");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    buscarLivro();
                    break;
                case 3:
                    atualizarLivro();
                    break;
                case 4:
                    exclusaoLivro();
                    break;
                case 5:
                    emprestimo();
                    break;
                case 6:
                    devolucao();
                    break;
                case 7:
                    listaLivros();
                    break;
                case 8:
                    continuar = false;
                    System.out.println("Você saiu da biblioteca!");
            }

        }while(continuar);
    }

    public List<Livro> ToString(){
        return this.acervo;
    }
}





