package Model.Util;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String PROPERTYDBDRIVER = "DBDRIVER";
    private static final String PROPERTYDBURL = "DBURL";
    private static final String PROPERTYNAME = "db_usn";
    private static final String PROPERTYPSW = "db_psw";
    private static String username;
    private static String password;
    private static String dbDriver;
    private static String dbURL;
    private static DBConnection conn;

    /**
     *
     */
    private static void init() {
        Properties p = new Properties(System.getProperties());
        try {
            p.load(new FileInputStream("properties/properties"));
            username=p.getProperty(PROPERTYNAME);
            password=p.getProperty(PROPERTYPSW);
            dbDriver =p.getProperty(PROPERTYDBDRIVER);
            dbURL =p.getProperty(PROPERTYDBURL);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param conn
     * @return
     */
    public static Connection startConnection(Connection conn)
    {
        init();

        if ( isOpen(conn) )
            closeConnection(conn);

        try
        {

            Class.forName(dbDriver);

            conn = DriverManager.getConnection(dbURL, username, password);// Apertura connessione

        }
        catch (Exception e)
        {

            e.printStackTrace();
            return null;
        }
        return conn;
    }

    /**
     *
     * @param conn
     * @return
     */
    public static boolean isOpen(Connection conn)
    {
        if (conn == null)
            return false;
        else
            return true;
    }

    /**
     *
     * @param conn
     * @return
     */
    public static Connection closeConnection(Connection conn)
    {
        if ( !isOpen(conn) )
            return null;
        try
        {

            conn.close();
            conn = null;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}

