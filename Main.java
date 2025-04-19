package Task_Manager;

import Task_Manager.Managers.Interface_Manager;
import Task_Manager.Managers.System_Manager;
import Task_Manager.Managers.Task_Manager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Gerenciador de Tarefas!");
        
        while(System_Manager.isSystem_open()){
            Interface_Manager.showMenuOptions();

            try {
                int option = Integer.parseInt(System_Manager.getScan().nextLine());
                
                switch(option){
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
                        Task_Manager.showTasksByType();
                        break;
                    case 6:
                        System_Manager.setSystem_open(false);
                        System.out.println("Obrigado por usar o Gerenciador de Tarefas!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }
}
