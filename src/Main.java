import controller.LojaController;
import database.DbFunctions;
import model.Produto;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LojaController controller = new LojaController();
        controller.menu();

    }
}