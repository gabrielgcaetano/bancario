package pessoas;

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
    
    public static String leString(String mensagem) {
        String x;
        
        Scanner in = new Scanner(System.in);
        System.out.print(mensagem);
        x = in.nextLine();
        
        return x;
    }
    
}
