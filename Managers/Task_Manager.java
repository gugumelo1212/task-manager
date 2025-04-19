package Task_Manager.Managers;

import Task_Manager.Enums.Priority;
import Task_Manager.Enums.Type;
import Task_Manager.Objects.Task;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task_Manager {
    private static final ArrayList<Task> tasks_list = new ArrayList<>();

    public static void addNewTask() {
        try {
            Interface_Manager.showHeader("Adicionar Nova Tarefa");

            System.out.println("Nome da tarefa:");
            String task_name = System_Manager.getScan().nextLine();
            
            System.out.println("Prioridade (LOW, MEDIUM, HIGH):");
            String task_priority = System_Manager.getScan().nextLine().toUpperCase();
            
            System.out.println("Tipo (LEISURE, STUDY, WORK, PERSONAL):");
            String task_type = System_Manager.getScan().nextLine().toUpperCase();

            if (taskExists(task_name)) {
                System.out.println("Já existe uma tarefa com esse nome.");
                return;
            }

            try {
                Priority priority = Priority.valueOf(task_priority);
                Type type = Type.valueOf(task_type);
                tasks_list.add(new Task(task_name, priority, type));
                System.out.println("Tarefa adicionada com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Prioridade ou tipo inválido. Use as opções disponíveis.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }

    public static void removeTask() {
        Interface_Manager.showHeader("Remover Tarefa");

        System.out.println("Nome da tarefa:");
        String task_name = System_Manager.getScan().nextLine();

        Task task = findTask(task_name);
        if (task == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        tasks_list.remove(task);
        System.out.println("Tarefa removida com sucesso!");
    }

    public static void showTasks() {
        Interface_Manager.showHeader("Lista de Tarefas");

        if (tasks_list.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        // Ordenar por prioridade (HIGH primeiro)
        List<Task> sortedTasks = tasks_list.stream()
            .sorted(Comparator.comparing(Task::getTask_priority).reversed())
            .collect(Collectors.toList());

        for (Task task : sortedTasks) {
            System.out.println(task);
        }
    }

    public static void checkTask() {
        Interface_Manager.showHeader("Marcar Tarefa como Concluída");

        System.out.println("Nome da tarefa:");
        String task_name = System_Manager.getScan().nextLine();

        Task task = findTask(task_name);
        if (task == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        task.setCheck(true);
        System.out.println("Tarefa marcada como concluída!");
    }

    public static void uncheckTask() {
        Interface_Manager.showHeader("Marcar Tarefa como Pendente");

        System.out.println("Nome da tarefa:");
        String task_name = System_Manager.getScan().nextLine();

        Task task = findTask(task_name);
        if (task == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        task.setCheck(false);
        System.out.println("Tarefa marcada como pendente!");
    }

    public static void showTasksByType() {
        Interface_Manager.showHeader("Tarefas por Tipo");

        System.out.println("Digite o tipo (LEISURE, STUDY, WORK, PERSONAL):");
        String typeStr = System_Manager.getScan().nextLine().toUpperCase();

        try {
            Type type = Type.valueOf(typeStr);
            List<Task> filteredTasks = tasks_list.stream()
                .filter(task -> task.getType() == type)
                .collect(Collectors.toList());

            if (filteredTasks.isEmpty()) {
                System.out.println("Nenhuma tarefa encontrada para este tipo.");
                return;
            }

            filteredTasks.forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido. Use as opções disponíveis.");
        }
    }

    private static boolean taskExists(String taskName) {
        return tasks_list.stream()
            .anyMatch(task -> task.getTask_name().equalsIgnoreCase(taskName));
    }

    private static Task findTask(String taskName) {
        return tasks_list.stream()
            .filter(task -> task.getTask_name().equalsIgnoreCase(taskName))
            .findFirst()
            .orElse(null);
    }
}
