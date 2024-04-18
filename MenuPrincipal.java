import javax.swing.JOptionPane;
import java.util.*;

class Curso {
    String nome;
    int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return nome + " - " + alunos + " alunos";
    }
}

public class MenuPrincipal {
    public static void main(String[] args) {
        while (true) {
            exibirMenu();

            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:"));

            switch (opcao) {
                case 1:
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));
                    exibirAntecessorESucessor(numero);
                    break;
                case 2:
                    List<Curso> cursos1 = obterCursos();
                    exibirCursosOrdenados(cursos1);
                    break;
                case 3:
                    List<Curso> cursos2 = obterCursos();
                    exibirCursosFiltrados(cursos2);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa. Até mais!");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, selecione uma opção válida.");
            }
        }
    }

    private static void exibirMenu() {
        String menu = "=========== Menu ===========\n" +
                "1. Exercício 1: Imprimir Antecessor e Sucessor de um Número\n" +
                "2. Exercício 2: Ordenar Cursos de Graduação por Quantidade de Alunos\n" +
                "3. Exercício 3: Filtrar Cursos com Quantidade de Alunos Entre 10 e 20\n" +
                "0. Sair";
        JOptionPane.showMessageDialog(null, menu);
    }

    private static void exibirAntecessorESucessor(int numero) {
        JOptionPane.showMessageDialog(null, "O antecessor de " + numero + " é: " + (numero - 1) + "\n" +
                "O sucessor de " + numero + " é: " + (numero + 1));
    }

    private static List<Curso> obterCursos() {
        List<Curso> cursos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String nomeCurso = JOptionPane.showInputDialog("Nome do curso " + (i + 1) + ":");
            int alunosCurso = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de alunos do curso " + (i + 1) + ":"));
            cursos.add(new Curso(nomeCurso, alunosCurso));
        }

        return cursos;
    }

    private static void exibirCursosOrdenados(List<Curso> cursos) {
        cursos.sort(Comparator.comparingInt(Curso::getAlunos).reversed());

        StringBuilder cursosOrdenados = new StringBuilder("Cursos de graduação ordenados por quantidade de alunos:\n");
        for (Curso curso : cursos) {
            cursosOrdenados.append(curso).append("\n");
        }

        JOptionPane.showMessageDialog(null, cursosOrdenados.toString());
    }

    private static void exibirCursosFiltrados(List<Curso> cursos) {
        List<Curso> cursosFiltrados = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getAlunos() >= 10 && curso.getAlunos() <= 20) {
                cursosFiltrados.add(curso);
            }
        }

        StringBuilder cursosFiltradosString = new StringBuilder("Cursos de graduação com quantidade de alunos entre 10 e 20:\n");
        for (Curso curso : cursosFiltrados) {
            cursosFiltradosString.append(curso).append("\n");
        }

        int totalAlunos = cursosFiltrados.stream().mapToInt(Curso::getAlunos).sum();
        cursosFiltradosString.append("Total de alunos nos cursos filtrados: ").append(totalAlunos);

        JOptionPane.showMessageDialog(null, cursosFiltradosString.toString());
    }
}