import java.sql.*;

class DatabaseController {
    private static final String URL = "jdbc:mysql://localhost:3306/project3313";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DatabaseController() {
    }

    private static DatabaseController DatabaseSingleton = null;

    public static synchronized DatabaseController getInstance() {
        if (DatabaseSingleton == null)
            DatabaseSingleton = new DatabaseController();

        return DatabaseSingleton;
    }

    public void InitializeTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Create table if it does not exist
            String query = "CREATE TABLE IF NOT EXISTS stock_table (" +
                    "stock INT NOT NULL, " +
                    "sold INT NOT NULL);";
            statement.executeUpdate(query);

            // Check if 'id' column exists
            DatabaseMetaData dbMetaData = connection.getMetaData();
            ResultSet rs = dbMetaData.getColumns(null, null, "stock_table", "id");
            if (!rs.next()) {
                // Add 'id' column if it does not exist
                String alterTableQuery = "ALTER TABLE stock_table ADD COLUMN id INT AUTO_INCREMENT PRIMARY KEY";
                statement.executeUpdate(alterTableQuery);
                System.out.println("Primary key added.");
            } else {
                System.out.println("Primary key already exists.");
            }

            // Check if there is an existing row
            query = "SELECT COUNT(*) FROM stock_table";
            try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rsCount = stmt.executeQuery()) {
                if (rsCount.next() && rsCount.getInt(1) == 0) {
                    // Insert initial stock entry if no rows exist
                    String insertQuery = "INSERT INTO stock_table (stock, sold) VALUES (?, ?)";
                    try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                        insertStmt.setInt(1, 0); // Set stock to 0
                        insertStmt.setInt(2, 0); // Set sold to 0
                        int rowsAffected = insertStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Initial stock entry created successfully.");
                        } else {
                            System.out.println("Failed to create initial stock entry.");
                        }
                    }
                } else {
                    System.out.println("Stock table already has data.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void setStock(int stock) {
        String query = "UPDATE stock_table SET stock = ? WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, stock);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Stock updated.");
            } else {
                System.out.println("Stock update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getStock() {
        int stock = 0;
        String query = "SELECT stock FROM stock_table WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                stock = rs.getInt("stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }

    public void setSold(int sold) {
        String query = "UPDATE stock_table SET sold = ? WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sold);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sold updated.");
            } else {
                System.out.println("Sold update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSold() {
        int sold = 0;
        String query = "SELECT sold FROM stock_table WHERE id = 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                sold = rs.getInt("sold");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sold;
    }


}


