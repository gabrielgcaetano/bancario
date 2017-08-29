package pessoas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Avell-Caetano
 */
public class Util {
    
    Banco banco;
    String nome, doc;
    Integer opcao;
    
    public Integer lermenu(String texto) throws Exception{
        System.out.println(texto);
        Scanner ler = new Scanner(System.in);
        opcao = ler.nextInt();
        return opcao;
        
    }
    
    
    
//    public void lerCadastro() throws IOException, Exception {
//        Scanner ler = new Scanner(System.in);
//        System.out.printf("Informe o nome:\n");
//        nome = ler.nextLine();
//        System.out.printf("Informe o Documento:\n");
//        doc = ler.nextLine();
//        PessoaFisica pf = new PessoaFisica(nome, doc);
//        banco.cadastrar(nome, doc);
//    }
    
//    public String leitorArquivos() throws FileNotFoundException, IOException{
//       
//        return linha;
//    }
    
    
    
    
    
    
    
    public static String leString(String mensagem) {
        String x;
        
        Scanner in = new Scanner(System.in);
        System.out.print(mensagem);
        x = in.nextLine();
        
        return x;
    }
    
}
