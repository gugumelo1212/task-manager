package Task_Manager.Managers;

import java.util.ArrayList;

public class Interface_Manager {
    public static void showMenuOptions() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("0 - Adicionar nova tarefa");
        System.out.println("1 - Remover tarefa");
        System.out.println("2 - Mostrar todas as tarefas");
        System.out.println("3 - Marcar tarefa como concluída");
        System.out.println("4 - Marcar tarefa como pendente");
        System.out.println("5 - Mostrar tarefas por tipo");
        System.out.println("6 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    public static void showHeader(String title) {
        System.out.println("\n=== " + title + " ===");
    }
}
