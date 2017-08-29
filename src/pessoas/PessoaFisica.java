package pessoas;

import pessoa.Pessoa;

/**
 *
 * @author Avell-Caetano
 */
public class PessoaFisica extends Pessoa {

    public String cpf;
    
    
    public PessoaFisica(String nome, String cpf) throws Exception {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return ""+super.toString()+" CPF: " + cpf;
    }
    
}
