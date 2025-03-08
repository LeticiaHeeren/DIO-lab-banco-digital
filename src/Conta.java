import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            historico.add("Saque: -" + valor);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historico.add("Depósito: +" + valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            historico.add("Transferência: -" + valor);
        }
    }
    
    public void imprimirHistorico() {
        System.out.println("=== Histórico de Transações ===");
        for (String transacao : historico) {
            System.out.println(transacao);
        }
    }
    
    protected void imprimirInfosComuns() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }
}
