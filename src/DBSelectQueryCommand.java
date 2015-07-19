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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DBSelectQueryCommand extends Node
{
    public Parser parser;
    
    public DBSelectQueryCommand() {}
    
    public DBSelectQueryCommand(Parser parser)
    {
        this.parser = parser;
    }
    
    public Object eval()
    {                        
        String dbInfo = (String) parser.getVariable("dbInfo");
        String query  = (String) parser.getVariable("query");
    
        MySQLDataSource dataSource = SetDBInfo(dbInfo.split(";"));
        
        List<String> results = new ArrayList<String>();
        try (Connection connection = dataSource.getConnection())
        {
            try (PreparedStatement st = connection.prepareStatement(query))
            {                        
                ResultSet resultSet = st.executeQuery();
                
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                
                while (resultSet.next())
                {                           
                    StringBuffer column = new StringBuffer();
                    for (int index=0;index<columnsNumber;index++)
                    {
                        column.append( resultSet.getString(index+1) );
                        if (index != columnsNumber-1) column.append(";");
                    }                    
                    results.add(column.toString());                    
                }
                resultSet.close();
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in DBSelectQueryCommand.java--->eval(). " + e);
            System.exit(0);
        }
        return results;
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
