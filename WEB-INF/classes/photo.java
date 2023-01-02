import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
public class photo extends HttpServlet 
{
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
   {
	 String branch=req.getParameter("BRO");
	 String start=req.getParameter("from");
	 String end=req.getParameter("to");
	 res.setContentType("text/html");
     PrintWriter out=res.getWriter();
	 out.println(" <html>");
    out.println(" <body>");
	out.println("<div style='width:auto;height:auto;margin-top: 20px;margin-left:20px;margin-right: 20px;background-image: linear-gradient(43deg,rgb(89, 205, 255),rgb(138, 251, 225),rgb(118, 251, 194),rgb(89, 205, 255));padding-top: 20px;padding-left: 50px;margin-right: 50px;padding-bottom: 50px;float: left;border-radius:40px'>");
	out.println("<center><p style='font-size:50px;font-weight:bolder;'>WELCOME TO GALLERY</p></center>");
	 char startChar = start.charAt(8);
        char endChar = end.charAt(8);
        int startDigit = Integer.parseInt(start.substring(9));
        int endDigit = Integer.parseInt(end.substring(9));

        for (char c = startChar; c <= endChar; c++) {
            int startIndex = (c == startChar) ? startDigit : 1;
            int endIndex = (c == endChar) ? endDigit : 10;
			if((c!=':')&&(c!=';')&&(c!='<')&&(c!='=')&&(c!='>')&&(c!='@')&&(c!='?')){
            for (int i = startIndex; i <= endIndex; i++) {
                String rollNumber = "20881A05" + c;
                if (i == 10) {
                    rollNumber += "0";
                } else {
                    rollNumber += i;
                }
				String roll=start.substring(0,8)+rollNumber.substring(8);
               // out.print("<img src='http://studentscorner.vardhaman.org/images/"+branch+"/"+roll+".jpg' width='200px' height='200px'>"+roll);
			    out.println("<div style='height:300px;background-color:azure;border-radius: 20px;float: auto;margin-right: 30px;float: left;width: 200px;margin-top:30px;padding-bottom:10px'>");
                out.println("<img src='http://studentscorner.vardhaman.org/images/"+branch+"/"+roll+".jpg' height='250px' width='200px' style='border-top-left-radius: 20px;border-top-right-radius:20px;'>");
                 out.println("<div><h1 style='text-align:center;margin-top:10px;'>"+roll+"</h1></div>");
                out.println("</div>");
			}}
		}
	out.println("</div>");
    out.println("</body>");
    out.println("</html>");
   }
}

