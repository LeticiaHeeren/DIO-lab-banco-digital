
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital");

        Cliente cliente1 = new Cliente("Alice", "1234");
        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente1);
        
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(500);
        cc.sacar(100);
        cc.transferir(200, poupanca);
        ((ContaPoupanca) poupanca).aplicarJuros();
        
        banco.listarContas();
    }
}
