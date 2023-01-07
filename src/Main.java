import controller.LojaController;
import database.DbFunctions;
import model.Produto;
import view.LojaView;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LojaView view = new LojaView();
        view.menu();

    }
}