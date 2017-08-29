package pessoas;

import pessoa.Pessoa;

/**
 *
 * @author Avell-Caetano
 */
public class PessoaJuridica extends Pessoa{
    
    public String cnpj;

    public PessoaJuridica(String nome, String cnpj) throws Exception {
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return ""+ super.toString()  +" CNPJ: " + cnpj;
    }
    
}
