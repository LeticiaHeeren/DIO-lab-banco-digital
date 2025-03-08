import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String senha;
    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
