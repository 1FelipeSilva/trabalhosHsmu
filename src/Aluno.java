public class Aluno {

    String nome;
    Atividades[] bimestre;
    float mediaTotal;
    //int[] notas;

    Aluno(String nome) {
        this.nome = nome;
        this.bimestre = new Atividades[2];
        this.mediaTotal = 0;
    }
}
                                                                                                 