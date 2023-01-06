package database;

import java.sql.Connection;

public class Conector {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db("produtos","postgres","waer9a0s");
       // db.createTable(conn,"Produtos");
        db.insert_row(conn,"Produtos","Notebook",1, 3812,"Eletronicos");
    }
}
