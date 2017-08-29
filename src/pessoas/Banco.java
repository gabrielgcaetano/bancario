package pessoas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 *
 * @author Avell-Caetano
 */
public class Banco {

    Integer i, j;
    PessoaFisica pf;
    PessoaJuridica pj;
    BufferedWriter bw;
    Banco banco;
    Util u;

    private PessoaFisica[] pessoaF;
    private PessoaJuridica[] pessoaJ;

    public Banco() throws InterruptedException {
        pessoaF = new PessoaFisica[100];
        pessoaJ = new PessoaJuridica[100];
        menu();

    }

    public void cadastrarArquivo() throws IOException, Exception {
        try {
            bw = new BufferedWriter(new FileWriter("c:\\Temporario\\pessoa.txt", true));
            for (int i = 0; i < pessoaF.length; i++) {
                if (pessoaF[i] != null) {
                    Object pes = pessoaF[i];
                    Field fs = pes.getClass().getSuperclass().getDeclaredField("nome");
                    fs.setAccessible(true);
                    bw.write(fs.get(pes) + ":" + pessoaF[i].getCpf() + ":pf");
                    bw.newLine();
                    bw.flush();
                }
            }
            for (int i = 0; i < pessoaJ.length; i++) {
                if (pessoaJ[i] != null) {
                    Object pes = pessoaJ[i];
                    Field fs = pes.getClass().getSuperclass().getDeclaredField("nome");
                    fs.setAccessible(true);
                    bw.write(fs.get(pes) + ":" + pessoaJ[i].getCnpj() + ":pj");
                    bw.newLine();
                    bw.flush();
                }
            }
        } finally { // always close the file
            if (bw != null) {
                bw.close();

            }
        }
    }

    public void find() throws IOException, Exception {
        u = new Util();
        int i = 0;
        j = 0;

        String linha;
        FileReader arq = new FileReader("c:\\Temporario\\pessoa.txt");
        BufferedReader lerArq = new BufferedReader(arq);
//        String array[] = new String[100];

        do {
            linha = lerArq.readLine();
            String vetorLinha[] = linha.split(":");

            if (vetorLinha[2].equals("pf")) {
                PessoaFisica pf = new PessoaFisica(vetorLinha[0], vetorLinha[1]);
                pessoaF[i] = pf;
                i++;
            } else if (vetorLinha[2].equals("pj")) {
                PessoaJuridica pj = new PessoaJuridica(vetorLinha[0], vetorLinha[1]);
                pessoaJ[j] = pj;
            }

        } while (linha != null);
        arq.close();
    }

    public void findPJ() {

    }

    void menu() throws InterruptedException {
        u = new Util();
        int escolha = 0;
        do {
            System.out.println("Menu");
            System.out.println(" 1 - Cadastrar Pessoa");
            System.out.println(" 2 - Carregar Pessoas");
            System.out.println(" 3 - Lista Pessoa");
            System.out.println(" 4 - Cadastrar Arquivo");
            System.out.println("9- Sair");

            try {
                escolha = u.lermenu("Escolha uma opção: ");
                switch (escolha) {
                    case 1:
                        cadastrarPessoa();
                        break;
                    case 2:
                        find();
                        break;
                    case 3:
                        listarPessoa();
                        break;
                    case 4:
                        cadastrarArquivo();
                        break;
                    default:
                        System.err.println("Opção inválida!");
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } while (escolha != 9);
    }

    private int cadastrarPessoa() throws Exception {
        for (int i = 0; i < pessoaF.length; i++) {
            if (pessoaF[i] == null) {
                String nome = Util.leString("Digite Nome: ");
                String documento = Util.leString("Digite o Documento: ");

                if (documento.length() == 11) {
                    PessoaFisica pf = new PessoaFisica(nome, documento);
                    pessoaF[i] = pf;
                } else if (documento.length() == 14) {
                    PessoaJuridica pj = new PessoaJuridica(nome, documento);
                    pessoaJ[i] = pj;
                } else {
                    System.out.println("Documento Invalido");
                }

                System.out.println("+-------------------------------------------------------------------+");

                return i;
            }
        }
        return -1;
    }

    private void listarPessoa() {
        System.out.println("Pessoa Fisica:");
        for (int i = 0; i < pessoaF.length; i++) {
            if (pessoaF[i] != null) {
                System.out.printf("[%d] %s", i, pessoaF[i] + "\n");
            }
        }
        System.out.println("Pessoa Juridica:");
        for (int i = 0; i < pessoaJ.length; i++) {
            if (pessoaJ[i] != null) {
                System.out.printf("[%d] %s", i, pessoaJ[i] + "\n");
            }
        }

    }

}
