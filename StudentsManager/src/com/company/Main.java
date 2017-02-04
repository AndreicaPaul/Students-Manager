package com.company;
import com.company.controller.Controller;
import com.company.repository.Repository;
import com.company.view.Menu;
public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Controller controller = new Controller(repository);
        Menu menu = new Menu(controller);
        menu.run();
    }
}
