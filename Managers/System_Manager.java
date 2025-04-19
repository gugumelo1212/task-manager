package Task_Manager.Managers;

import java.util.Scanner;

public class System_Manager {
    private static Scanner scan = new Scanner(System.in);

    private static boolean system_open = true;
    private static String[] menu_options_list = {"Add new task", "Remove task", "Show task", "Check task", "Uncheck task", "Exit system"};

    public static boolean isSystem_open() {
        return system_open;
    }

    public static void setSystem_open(boolean system_open) {
        System_Manager.system_open = system_open;
    }

    public static String[] getMenu_options_list() {
        return menu_options_list;
    }

    public static Scanner getScan() {
        return scan;
    }
}
