import java.io.PrintStream;
import java.util.Scanner;

public class Notas{

    public static void main(String[] args) {
        Notas programa = new Notas();
        programa.executar();
    }

    private final Scanner entrada = new Scanner(System.in);
    private final PrintStream saida = System.out;

    public void executar() {
        escrever("Digite a quantidade de aluno: \n");
        int qtdAlunos = lerInteiro();
        //escrever("Quantidade de alunos: "+Integer.toString(qtdAlunos));  
        Aluno[] alunos = new Aluno[qtdAlunos];
        //Felipeescrever(Integer.toString(alunos.length));
        for (int i = 0; i < alunos.length; i++) {    
            escrever("Digite o nome do(a) " + (i + 1) + "° aluno(a): \n");
            Aluno aluno = new Aluno(lerTexto());
            //escrever("Tamanho aluno"+ Integer.toString(aluno.bimestre.length) + " \n");
            for (int n = 0; n < 2; n++) {
                escrever("Digite a nota da prova do " + (n + 1) +"° Bimestre do(a) aluno(a) "+ aluno.nome +"\n");
                float notaProva = lerDecimal();

                escrever("Digite a nota do projeto  do " + (n + 1) +"° Bimestre do(a) aluno(a) "+ aluno.nome +"\n");
                float notaProjeto = lerDecimal();

                escrever("Digite a nota da lista  do " + (n + 1) +"° Bimestre do(a) aluno(a) "+ aluno.nome +"\n");
                float notaLista = lerDecimal();

                float mediaNota = ((notaProva * 5 + notaProjeto * 3 + notaLista * 2)/(5+3+2));

                Atividades bimestre = new Atividades(notaProva, notaLista, notaProjeto, mediaNota);

                escrever("Média das notas do "+ (n + 1) +"° Bimestre do(a) aluno(a) "+ aluno.nome +" é: \n " + Float.toString(mediaNota )+ "\n");
                aluno.bimestre[n] = bimestre;
            }  
            alunos[i] = aluno;

            
            //escrever(Integer.toString(alunos[i].bimestre.length));

        }
        float maior = 0, menor = 10, totalMediasTurma =0, mediaTotal = 0;
        int totalAprovado = 0, totalAvaliaçãoFinal = 0, totalReprovado = 0; 
        for(int m = 0; m < alunos.length; m++){
            //float mediaTotal = (alunos[m].bimestre[0].media + alunos[m].bimestre[1].media)/2;
            String statusAprovacao;
            alunos[m].mediaTotal = (alunos[m].bimestre[0].media + alunos[m].bimestre[1].media)/2;
            totalMediasTurma += alunos[m].mediaTotal;
            if(alunos[m].mediaTotal >= 8) {
                statusAprovacao = "Aluno(a) Aprovado(a)!";
                totalAprovado++;
            } else if (alunos[m].mediaTotal > 5 && alunos[m].mediaTotal < 8) {
                statusAprovacao = "Aluno deve realizar a Avaliação Final (AF).";
                totalAvaliaçãoFinal++;
            } else {
                statusAprovacao = "Aluno(a) Reprovado(a).";
                totalReprovado++;
            }
            escrever("A média Semestral do(a) aluno(a) " + alunos[m].nome + " é: " + alunos[m].mediaTotal +". "+ statusAprovacao + "\n");
            if(alunos[m].mediaTotal > maior){
                maior = alunos[m].mediaTotal;
            }
            if(alunos[m].mediaTotal<menor){
               menor = alunos[m].mediaTotal; 
            }
        } 
        escrever("A maior média Semestral é: " + maior + "\n");
        escrever("A menor média Semestral é: " + menor+ "\n");
        escrever("A média Geral da turma é: " + (totalMediasTurma/alunos.length)+ "\n");
        escrever("Quantidade de aluno(as) aprovados(as): " + totalAprovado+ "\n");
        escrever("Quantidade de aluno(as) Reprovados(as): " + totalReprovado+ "\n");
        escrever("Quantidade de aluno(as) que farão a Avaliação Final (AF): " + totalAvaliaçãoFinal+ "\n");
    }
    private void escrever(String mensagem) {
        saida.print(mensagem);
    }

    private int lerInteiro() {
        return Integer.parseInt(lerTexto());
    }
    
    private Float lerDecimal() {
        return Float.parseFloat(lerTexto());
    }

    private String lerTexto() {
        return entrada.nextLine();
    }
}