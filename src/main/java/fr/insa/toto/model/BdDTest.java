/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.toto.model;

import fr.insa.beuvron.utils.database.ConnectionSimpleSGBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author francois
 */
public class BdDTest {

    public static void createBdDTestV1(Connection con) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement("insert into utilisateur (id,surnom) values (?,?)")) {
            pst.setInt(1, 1);
            pst.setString(2, "toto");
            pst.executeUpdate();
            pst.setInt(1, 2);
            pst.setString(2, "titi");
            pst.executeUpdate();
        }
    }

    public static void createBdDTestV2(Connection con) throws SQLException {
        List<Utilisateur> users = List.of(
                new Utilisateur("toto", "p1", 1),
                new Utilisateur("titi", "p2", 2),
                new Utilisateur("tutu", "p2", 2)
        );
        for (var u : users) {
            u.saveInDB(con);
        }
        List<Loisir> loisirs = List.of(
                new Loisir("tennis", "c'est fatiguant"),
                new Loisir("sieste", "c'est reposantm"),
                new Loisir("lecture", "trop intello")
        );
        for (var lo : loisirs) {
            lo.saveInDB(con);
        }
        int[][] apprecient = new int[][]{
            {0, 1},
            {1, 1},
            {1, 2},
            {2, 1},};
        try (PreparedStatement app = con.prepareStatement(
                "insert into apprecie (u1,u2) values (?,?)")) {
            for (int[] a : apprecient) {
                app.setInt(1, users.get(a[0]).getId());
                app.setInt(2, users.get(a[1]).getId());
                app.executeUpdate();
            }
        }
        int[][] pratiques = new int[][]{
            {0, 1, 1},
            {1, 0, 2},
            {1, 2, -2},
            {2, 1, -1},};
        try (PreparedStatement pra = con.prepareStatement(
                "insert into pratique (idutilisateur,idloisir,niveau) values (?,?,?)")) {
            for (int[] p : pratiques) {
                pra.setInt(1, users.get(p[0]).getId());
                pra.setInt(2, loisirs.get(p[1]).getId());
                pra.setInt(3, p[2]);
                pra.executeUpdate();
            }
        }
    }

    public static void main(String[] args) {
        try (Connection con = ConnectionSimpleSGBD.defaultCon()) {
            GestionSchema.razBdd(con);
            createBdDTestV2(con);
        } catch (SQLException ex) {
            throw new Error(ex);
        }
    }

}
