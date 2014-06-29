package sepermercado;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Classe com a logica da simulacao passo-a-passo
 */
public class Simulacao {

    private static final int duracao = 200;
    private static final double probabilidadeChegada = 0.1;
//    private QueueTAD<Cliente> filaCaixa;
//    private QueueTAD<Cliente> filaEntrada;
//    private Atendente caixa;
//    private Atendente entrada;
    private static int nroAtendenteCaixa;
    private static int nroAtendenteEntrada;
    private static int nroFilaCaixa;
    private static int nroFilaEntrada;
    private static int tempoMinAtendimentoCaixa;
    private static int tempoMaxAtendimentoCaixa;
    private static int tempoMinAtendimentoEntrada;
    private static int tempoMaxAtendimentoEntrada;
    private static int stageCaixa;
    private static int stageEntrada;
    private static int stageFilaCaixa;
    private static int stageFilaEntrada;
    private GeradorClientes geradorClientes;
    private Acumulador statTemposEsperaFila;
    private Acumulador statComprimentosFila;
    private boolean trace; //valor indica se a simulacao ira imprimir passo-a-passo os resultados

    public Simulacao(boolean t) {
//        fila = new QueueLinked<Cliente>();
//        caixa = new Atendente();
//        geradorClientes = new GeradorClientes(probabilidadeChegada);
//        statTemposEsperaFila = new Acumulador();
//        statComprimentosFila = new Acumulador();
//        trace = t;
     
    }

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./src/sepermercado/cinema.properties");
        props.load(file);
        return props;
    }

    private Simulacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void lerArquivo() {
        try {
           
            Properties prop = getProp();
            nroAtendenteCaixa = Integer.valueOf(prop.getProperty("atendente_caixa"));
            nroAtendenteEntrada = Integer.valueOf(prop.getProperty("atendente_entrada"));
            nroFilaCaixa = Integer.valueOf(prop.getProperty("fila_caixa"));
            nroFilaEntrada = Integer.valueOf(prop.getProperty("fila_entrada"));
            tempoMinAtendimentoCaixa = Integer.valueOf(prop.getProperty("timeMinCaixa"));
            tempoMaxAtendimentoCaixa = Integer.valueOf(prop.getProperty("timeMaxCaixa"));
            tempoMinAtendimentoEntrada = Integer.valueOf(prop.getProperty("timeMinEntrada"));
            tempoMaxAtendimentoEntrada = Integer.valueOf(prop.getProperty("timeMaxEntrada"));
            stageCaixa = Integer.valueOf(prop.getProperty("caixa_stage"));
            stageEntrada = Integer.valueOf(prop.getProperty("entrada_stage"));
            stageFilaCaixa = Integer.valueOf(prop.getProperty("fila_caixa"));
            stageFilaEntrada = Integer.valueOf(prop.getProperty("fila_entrada"));
           
        } catch (IOException ex) {
            Logger.getLogger(Simulacao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
  public static void main(String[] args) {
       lerArquivo();
        System.out.println("Comprimento medio da fila:");

  }
    
//    public void simular()
//    {
//        //realizar a simulacao por um certo numero de passos de duracao
//        for(int tempo=0; tempo<duracao; tempo++)
//        {
//            //verificar se um cliente chegou
//            if(geradorClientes.gerar())
//            {
//                //se cliente chegou, criar um cliente e inserir na fila do caixa
//                Cliente c = new Cliente(geradorClientes.getQuantidadeGerada(),tempo);
//                fila.add(c);
//                if(trace)
//                    System.out.println(tempo + ": cliente " + c.getNumero() + " ("+c.getTempoAtendimento()+" min) entra na fila - " + fila.size() + " pessoa(s)");
//            }
//            //verificar se o caixa esta vazio
//            if(caixa.estaVazio())
//            {
//                //se o caixa esta vazio, atender o primeiro cliente da fila se ele existir
//                if(!fila.isEmpty())
//                {
//                    //tirar o cliente do inicio da fila e atender no caixa
//                    caixa.atenderNovoCliente(fila.remove());
//                    statTemposEsperaFila.adicionar(tempo - caixa.getClienteAtual().getInstanteChegada());
//                    if(trace)
//                        System.out.println(tempo + ": cliente " + caixa.getClienteAtual().getNumero() + " chega ao caixa.");
//                }
//            }
//            else
//            {
//                //se o caixa ja esta ocupado, diminuir de um em um o tempo de atendimento ate chegar a zero
//                if(caixa.getClienteAtual().getTempoAtendimento() == 0)
//                {
//                    if(trace)
//                        System.out.println(tempo + ": cliente " + caixa.getClienteAtual().getNumero() + " deixa o caixa.");
//                    caixa.dispensarClienteAtual();
//                }
//                else
//                {
//                    caixa.getClienteAtual().decrementarTempoAtendimento();
//                }
//            }
//            statComprimentosFila.adicionar(fila.size());
//        }
//    }
//    
//    public void limpar()
//    {
//        fila = new QueueLinked<Cliente>();
//        caixa = new Atendente();
//        geradorClientes = new GeradorClientes(probabilidadeChegada);
//        statTemposEsperaFila = new Acumulador();
//        statComprimentosFila = new Acumulador();
//    }
//    
//    public void lerArquivo (){
//        
//    }
//    
//    
//    public void imprimirResultados()
//    {
//        System.out.println();
//        System.out.println("Resultados da Simulacao");
//        System.out.println("Duracao:" + duracao);
//        System.out.println("Probabilidade de chegada de clientes:" + probabilidadeChegada);
//        System.out.println("Tempo de atendimento minimo:" + Cliente.tempoMinAtendimento);
//        System.out.println("Tempo de atendimento maximo:" + Cliente.tempoMaxAtendimento);
//        System.out.println("Cliente atendidos:" + caixa.getNumeroAtendidos());
//        System.out.println("Clientes ainda na fila:" + fila.size());
//        System.out.println("Cliente ainda no caixa:" + (caixa.getClienteAtual() != null));
//        System.out.println("Total de clientes gerados:" + geradorClientes.getQuantidadeGerada());
//        System.out.println("Tempo medio de espera:" + statTemposEsperaFila.getMedia());
//        System.out.println("Comprimento medio da fila:" + statComprimentosFila.getMedia());
//    }
}
