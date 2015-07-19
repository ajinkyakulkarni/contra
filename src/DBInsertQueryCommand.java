import org.mariadb.jdbc.MySQLDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DBInsertQueryCommand extends Node
{
    public Parser parser;
    
    public DBInsertQueryCommand() {}
    
    public DBInsertQueryCommand(Parser parser)
    {
        this.parser = parser;
    }
    
    public Object eval()
    {                                
        String dbInfo = (String) parser.getVariable("dbInfo");
        String query  = (String) parser.getVariable("query");
        List queryParams = (List) parser.getVariable("queryParams");
        
        MySQLDataSource dataSource = SetDBInfo(dbInfo.split(";"));
        
        int result = 0;
        try (Connection connection = dataSource.getConnection())
        {
            try (PreparedStatement st = connection.prepareStatement(query))
            {                
                if (queryParams != null)
                {
                    int index = 1;
                    for (Object param: queryParams)
                    {
                        st.setObject(index++, param);
                    }                                
                }
                result = st.executeUpdate();
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in DBInsertQueryCommand.java--->eval(). " + e);
            System.exit(0);
        }        
        
        return new Integer(result);
    }
        
    public static MySQLDataSource SetDBInfo(String[] dbInfoParts)
    {
        MySQLDataSource dataSource = new MySQLDataSource();    
        dataSource.setURL(dbInfoParts[0]);
        dataSource.setDatabaseName(dbInfoParts[1]);
        dataSource.setUserName(dbInfoParts[2]);
        dataSource.setPassword(dbInfoParts[3]);
        
        return dataSource;
    }
}