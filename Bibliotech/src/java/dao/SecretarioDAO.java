/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Secretario;
import util.ConectaBanco;

/**
 *
 * @author Jefferson
 */
public class SecretarioDAO {
    
    public static final String SELECT = "SELECT * FROM secretario WHERE cpf=? AND dn=?";

    public static int validarDados(Secretario secretario) {

        Connection conexao = null;
        PreparedStatement pstmt = null;
        int r=0;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(SELECT);
            pstmt.setString(1, secretario.getCpf());
            pstmt.setInt(2, secretario.getDn());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                r=r+1;
                secretario.setCpf(rs.getString("cpf"));
                secretario.setDn(rs.getInt("dn"));
            } 
            if (r ==1){
                return 1;
            } else {
                return 0;
            }
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
