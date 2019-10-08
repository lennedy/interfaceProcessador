/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lennedy.form;
import lennedy.form.cpu.Cpu;
/**
 *
 * @author lenne
 */
public class ComputadorExemplo implements InterfaceForm{
    private DadosCpu dadosCpu;
    private Barramento dadosBarramento;
    private Cpu cpu;
    int index;
    int index1;
    final int BUSCAR=0;
    final int DECODIFICAR=1;
    final int BUSCAR_DADOS=2;
    final int EXECUTAR=3;
    final int SALVAR_DADOS=4;
    
    public ComputadorExemplo(){
        dadosCpu= new DadosCpu();
        dadosBarramento = new Barramento();
        cpu = new Cpu();
    }

    public void clock(){
        dadosBarramento = cpu.clock(dadosBarramento);
        
    }

    
    public void clock1(){
        
        switch(index1){
            case BUSCAR:
                dadosBarramento = cpu.buscar1(dadosBarramento);
            break;
            case DECODIFICAR:
                cpu.buscar2(dadosBarramento);
                cpu.decodificar();
                if(cpu.isBuscarDados()) 
                    index++;
            break;
            case BUSCAR_DADOS:
                dadosBarramento = cpu.buscarDados(dadosBarramento);
            break;
            case EXECUTAR:
                cpu.executar();
                if(cpu.isSalvarDados()) 
                    index++;
            break;
            case SALVAR_DADOS:
                    dadosBarramento = cpu.salvarDados(dadosBarramento);
            break;
        };
        
        index++;
        if(index>4){
            index=0;
        }
        System.out.println("Index: " + index1);
        System.out.println("BusEnd: \t"+ dadosBarramento.getEnd());
        System.out.println("BusDados: \t"+ dadosBarramento.getDado());
        
    }
    
    public void clock2(){
    }
       
    
    public DadosCpu getDadosCpu(){
        dadosCpu = cpu.getDadosCpu();
        return dadosCpu;
    }
    
    public Barramento getDadosBarramento(){
        return dadosBarramento;
    }
}
