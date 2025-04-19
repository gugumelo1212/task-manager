package Task_Manager.Managers;

import Task_Manager.Enums.Priority;
import Task_Manager.Enums.Type;
import Task_Manager.Objects.Task;
import java.util.ArrayList;

public class Task_Manager {
    static ArrayList<Task> tasks_list = new ArrayList<Task>();

    public static void addNewTask(){
        Interface_Manager.showHeader("Add new task");

        System.out.println("Task name:");
        String task_name = System_Manager.getScan().nextLine();
        System.out.println("Task priority:");
        String task_priority = System_Manager.getScan().nextLine();
        System.out.println("Task type:");
        String task_type = System_Manager.getScan().nextLine();

        for(Task task : tasks_list){
            if(task.getTask_name().equals(task_name)){
                System.out.println("A task already has that name.");
                return;
            }
        }

        tasks_list.add(new Task(task_name, Priority.valueOf(task_priority), Type.valueOf(task_type)));
    }

    public static void removeTask(){
        Interface_Manager.showHeader("Remove task");

        System.out.println("Task name:");
        String task_name = System_Manager.getScan().nextLine();

        Task task_object = null;

        for(Task task : tasks_list){
            if(task.getTask_name().equals(task_name)){
                task_object = task;
            }
        }
        if(task_object == null){
            System.out.println("Invalid task.");
            return;
        }

        tasks_list.remove(task_object);
    }

    public static void showTasks(){
        Interface_Manager.showHeader("Show tasks");

        for(Task task : tasks_list){
            System.out.println(task.getTask_name() + " | " + task.getTask_priority() + " | " + task.getType() + " [" + (task.isCheck() ? "✅" : "❌") + "]");
        }
    }

    public static void checkTask(){
        Interface_Manager.showHeader("Check task");

        System.out.println("Task name:");
        String task_name = System_Manager.getScan().nextLine();

        Task task_object = null;

        for(Task task : tasks_list){
            if(task.getTask_name().equals(task_name)){
                task_object = task;
            }
        }
        if(task_object == null){
            System.out.println("Invalid task.");
            return;
        }

        task_object.setCheck(true);
    }

    public static void uncheckTask(){
        Interface_Manager.showHeader("Uncheck task");

        System.out.println("Task name:");
        String task_name = System_Manager.getScan().nextLine();

        Task task_object = null;

        for(Task task : tasks_list){
            if(task.getTask_name().equals(task_name)){
                task_object = task;
            }
        }
        if(task_object == null){
            System.out.println("Invalid task.");
            return;
        }

        task_object.setCheck(false);
    }
}
