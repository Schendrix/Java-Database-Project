
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void createNewTable(){
        String url = "jdbc:sqlite:seminar10_1050.db";
        String sql = "CREATE TABLE IF NOT EXISTS STUDENT (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nume varchar(50),\n"
                + "	media double\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) {
        createNewTable();
        System.out.println("1 - Adaugare inregistrare");
        System.out.println("2 - Stergere inregistrare");
        System.out.println("3 - Modificare inregistrare");
        System.out.println("4 - Afisare tabela");
        System.out.println("5 - Exit\n");
        System.out.println("Optiune:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

                switch (choice) {
                    //CASE 1 (Introducere inregistrare)
                    case 1:
                        System.out.println("Optiune: 1 - Adaugare inregistrare");
                        try {
                            Scanner input = new Scanner(System.in);
                            System.out.println("Id: ");
                            int id = input.nextInt();
                            System.out.println("Nume: ");
                            String nume = input.next();
                            System.out.println("Media: ");
                            double media = input.nextDouble();
                            String url = "jdbc:sqlite:seminar10_1050.db";
                            Connection conn = DriverManager.getConnection(url);
                            Statement st = conn.createStatement();
                            st.executeUpdate("INSERT INTO STUDENT " +
                                    "VALUES (" + id + ", '" + nume + "', " + media + ")");


                            conn.close();
                        } catch (Exception e) {
                            System.err.println("Got an exception! ");
                            System.err.println(e.getMessage());
                        }
                        break;
                    //CASE 2 (Stergere iregistrare)
                    case 2:
                        System.out.println("Optiune: 2 - Stergere inregistrare");
                        try {
                            Scanner input = new Scanner(System.in);
                            System.out.println("Id:");
                            int id = input.nextInt();
                            String url = "jdbc:sqlite:seminar10_1050.db";
                            Connection conn = DriverManager.getConnection(url);
                            Statement st = conn.createStatement();
                            st.executeUpdate("DELETE FROM STUDENT " +
                                    "WHERE id = " + id + "");

                            conn.close();
                            System.out.println("Stergere efectuata.");
                        } catch (Exception e) {
                            System.err.println("Got an exception! ");
                            System.err.println(e.getMessage());
                        }
                        break;

                    //CASE 3(Update)
                    case 3:
                        try {
                            Scanner input = new Scanner(System.in);
                            System.out.println("Id: ");
                            int id = input.nextInt();
                            System.out.println("Nume: ");
                            String nume = input.next();
                            System.out.println("Media: ");
                            Double media = input.nextDouble();
                            String url = "jdbc:sqlite:seminar10_1050.db";
                            Connection conn = DriverManager.getConnection(url);
                            Statement st = conn.createStatement();
                            st.executeUpdate("UPDATE STUDENT " +
                                    "SET media = " + media + ", nume = '" + nume + "' WHERE id =" + id + "");

                            System.out.println("Modificare efectuata.");
                            conn.close();
                        } catch (Exception e) {
                            System.err.println("Got an exception! ");
                            System.err.println(e.getMessage());
                        }

                        break;

                    //CASE 4 (Afisarea Tabelelor)
                    case 4:
                        try {
                            System.out.println("Optiune: 4\n");
                            System.out.println("Continut tabela:");
                            String url = "jdbc:sqlite:seminar10_1050.db";
                            Connection conn = DriverManager.getConnection(url);
                            Statement st = conn.createStatement();
                            ResultSet rs = st.executeQuery("SELECT id, nume, media FROM STUDENT ");
                            while (rs.next()) {
                                //Display values
                                System.out.print("\nID: " + rs.getInt("id"));
                                System.out.print(", Nume: " + rs.getString("nume"));
                                System.out.print(", Media: " + rs.getDouble("media"));
                            }
                            conn.close();
                        } catch (Exception e) {
                            System.err.println("Got an exception! ");
                            System.err.println(e.getMessage());
                        }
                        break;

                    //Comanda de Exit
                    case 5:

                        break;

                }

        }
    }

