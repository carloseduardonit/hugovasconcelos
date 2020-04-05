/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infoq.documento;

import br.com.infoq.dal.ModuloConexao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author carlos
 */
public class CertidaodeNascimento {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void CertidaodeNascimento() {
        conexao = ModuloConexao.conector();

    }

    private void erro() {

    }

    public void incluirCN(String nomeCompleto, String nomeMae, String nomePai,String nomedoCartorio,String enderecodoCartorio, Date dataNas,String localNas ) {

        String sql = "insert into tbCN (nomeCompleto,nomeMae,nomePai,nomedoCartorio,enderecodoCartorio,dataNas,localNas) values(?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nomeCompleto);
            pst.setString(2, nomeMae);
            pst.setString(3, nomePai);
            pst.setString(4, nomedoCartorio);
            pst.setString(5, enderecodoCartorio);
            pst.setDate(6, dataNas, Calendar.getInstance());
            pst.setString(7, localNas);

            if (nomeCompleto.isEmpty() || nomeMae.isEmpty() || nomePai.isEmpty() ||nomedoCartorio.isEmpty() || dataNas.toString().isEmpty()) {
                String erro = "E um campo Obrigatorio:\n";
                int count = 0;
                if (nomeCompleto.isEmpty()) {
                    count++;
                    erro += "Nome completo,\n";
                }
                if (nomeMae.isEmpty()) {
                    count++;
                    erro += "Nome da Mãe,\n";
                }
                if (nomePai.isEmpty()) {
                    count++;
                    erro += "Nome do Pai,\n";
                }
                if(nomedoCartorio.isEmpty()){
                    count++;
                    erro+="Nome do Cartorio,\n";
                }
                if (dataNas.toString().isEmpty()) {
                    count++;
                    erro += "Data de Nascimento,\n";
                }
                if (count == 1) {
                    erro += "Preencha o campo informados.";
                } else {
                    erro += "Preencha os campos informados.";
                }
                JOptionPane.showConfirmDialog(null, erro);

            } else {
                int adicionar = pst.executeUpdate();
                if (adicionar > 0) {
                    \\//JOptionPane.showConfirmDialog(null, "");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void alterarCN() {
        String sql = "";
    }

    public static void deletarCN() {

    }

    public static void pesquisarCN() {

    }
}
