package controller;;
import javax.faces.bean.ManagedBean;
import java.sql.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.personModel;
 
@ManagedBean(name="personController")
public class personController {

    personModel pm = new personModel();
    public int dbQueryConnection(String UName,String PWord) throws SQLException, ClassNotFoundException
    {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String SQL_Str;
        Boolean bool = false;
        int controlnum = -1;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","987654321");
            ps = con.prepareStatement("Select * from users");    
            rs=ps.executeQuery();
            while (rs.next()) {
                
                if(rs.getString("username").equals(UName) && rs.getString("password").equals(PWord) ){
                    controlnum = 1;
                    break;
                }
                else{
                    controlnum =0;
                }
                }
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Exception Occur :" + ex);
        }
        return controlnum;
    }

    public String logout() {
		HttpSession session = getSession();
		session.invalidate();
		return "index";
	}
    public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

    
    
    
}