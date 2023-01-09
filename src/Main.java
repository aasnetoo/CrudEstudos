import controller.LojaController;
import database.DbFunctions;
import model.Produto;
import view.LojaView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        LojaView view = new LojaView();
        view.menu();

    }
}