package Task_Manager;

import Task_Manager.Managers.Interface_Manager;
import Task_Manager.Managers.System_Manager;
import Task_Manager.Managers.Task_Manager;

public class Main {
    public static void main(String[] args) {
        while(System_Manager.isSystem_open()){
            Interface_Manager.showMenuOptions();

            switch(Integer.parseInt(System_Manager.getScan().nextLine())){
                case 0:
                    Task_Manager.addNewTask();
                    break;
                case 1:
                    Task_Manager.removeTask();
                    break;
                case 2:
                    Task_Manager.showTasks();
                    break;
                case 3:
                    Task_Manager.checkTask();
                    break;
                case 4:
                    Task_Manager.uncheckTask();
                    break;
                case 5:
                    System_Manager.setSystem_open(false);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
