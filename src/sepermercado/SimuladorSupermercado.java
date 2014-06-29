package sepermercado;

/*
 * Programa principal da simulacaoos
 */
public class SimuladorSupermercado
{
    public static void main(String[] args)
    {
        Simulacao sim = new Simulacao(true);
        sim.simular();
        sim.imprimirResultados();
    }
}
