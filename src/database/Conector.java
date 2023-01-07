package database;

import java.sql.Connection;

public class Conector {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("produtos1","postgres","waer9a0s");
        //db.createTable(conn,"Produtos1");
        //db.insert_row(conn,"Produtos1","Ovo",30, 3.53,"Alimentos");
//        db.read_data(conn,"Produtos1");
    }
}
