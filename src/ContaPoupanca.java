public class ContaPoupanca extends Conta {
    private static final double JUROS = 0.02;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void aplicarJuros() {
        saldo += saldo * JUROS;
        historico.add("Juros aplicados: +" + (saldo * JUROS));
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}