package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
    public static void main(String[] args) {
        Consulta consultaBD = new Consulta();
        consultaBD.consulta();
    }

    public void consulta() {
//        Conexao conexao = new Conexao();
//        Connection conn = conexao.conectar();
//        try {
//            String consulta = "SELECT * FROM PRODUTOSLOJA WHERE NOME like 'A%'";
//
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery(consulta);
//
//            while(rs.next()) {
//                System.out.print(" - " +rs.getString("nome")+" ");
//                System.out.println(" - " +rs.getString("quantidade")+" ");
//                System.out.println(" - " +rs.getString("preco")+" ");
//                System.out.println(" - " +rs.getString("tipo")+" ");
//            }
//        } catch (SQLException ex) {
//            System.out.println("Não conseguiu consultar os dados do Produto.");
//        } finally {
//            conexao.desconectar(conn);
//        }
//
    }
}
