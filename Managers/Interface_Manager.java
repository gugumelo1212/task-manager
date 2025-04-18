package Task_Manager.Managers;

import java.util.ArrayList;

public class Interface_Manager {
    public static void showMenuOptions(){
        System.out.println("--------------------");
        for(int i = 0; i < System_Manager.getMenu_options_list().length; i++){
            System.out.println("[ " + i + " ] " + System_Manager.getMenu_options_list()[i]);
        }
        System.out.println("--------------------");
    }

    public static void showHeader(String text){
        System.out.println("--------------------");
        System.out.println(text);
        System.out.println("~~~~~~~~~~");
    }
}
