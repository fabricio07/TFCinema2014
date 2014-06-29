package sepermercado;

public class Atendente {

    private Cliente clienteAtual; //cliente sendo atendido no caixa
    private int numeroAtendidos;
    private int stage;

    public Atendente(int stage) {
        clienteAtual = null;
        numeroAtendidos = 0;
        this.stage = stage;
    }

    public void atenderNovoCliente(Cliente c) {
        clienteAtual = c;
    }

    public Cliente dispensarClienteAtual() {
        if (stage == 1) {

            Cliente c = clienteAtual;
            clienteAtual = null;
            numeroAtendidos++;
            return c;
        } else if (clienteAtual.isHasIngresso()) {
        }
        return null;
    }

    public boolean estaVazio() {
        return (clienteAtual == null);
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public int getNumeroAtendidos() {
        return numeroAtendidos;
    }
}
