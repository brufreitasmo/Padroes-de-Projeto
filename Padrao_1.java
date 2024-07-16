public class Padrao_1 {

    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua 4 Casa 144", "Centro", "São José", "RN", "50940-144");

        Enderecador enderecador = new EnderecadorSimples();
        enderecador = new EnderecadorCaixaAlta(enderecador);
        enderecador = new EnderecadorComBorda(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(endereco);

        System.out.println(enderecoFormatado);
    }

}

//----------------------------------------------------

class Endereco {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//----------------------------------------------------

interface Enderecador {
    String preparaEndereco(Endereco endereco);
}

//----------------------------------------------------

class EnderecadorSimples implements Enderecador {
    public String preparaEndereco(Endereco endereco) {
        StringBuilder sb = new StringBuilder();
        sb.append(endereco.logradouro);
        sb.append("\n");
        sb.append(endereco.bairro);
        sb.append("\n");
        sb.append(endereco.cidade);
        sb.append('/');
        sb.append(endereco.uf);
        sb.append("\n");
        sb.append(endereco.cep);
        return sb.toString();
    }
}

//----------------------------------------------------

abstract class EnderecadorBase implements Enderecador {
    Enderecador enderecador;

    public EnderecadorBase(Enderecador enderecador) {
        super();
        this.enderecador = enderecador;
    }
}

//----------------------------------------------------

class EnderecadorCaixaAlta extends EnderecadorBase {
    
    public EnderecadorCaixaAlta(Enderecador enderecador) {
        super(enderecador);
    }
    
    public String preparaEndereco(Endereco endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
    
}

//----------------------------------------------------

class EnderecadorComBorda extends EnderecadorBase {

    public EnderecadorComBorda(Enderecador enderecador) {
        super(enderecador);
    }

    public String preparaEndereco(Endereco endereco) {
        String preparaEndereco = enderecador.preparaEndereco(endereco);
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------\n");
        preparaEndereco.lines().forEach(l -> sb.append("| " + l + "\n"));
        sb.append("---------------------");
        return sb.toString();
    }
}