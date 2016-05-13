package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.DefaultSocketClient;
import exception.AutoException;
import model.Automobile;


/**
 * Model Option Choices.
 * Get the data for the list of available OptionSets.
 * @author Jiaqi Zhang
 *
 */
@WebServlet(name = "ModelOptions", urlPatterns = "/ModelOptions")
public class ModelOptions extends HttpServlet {

    /**
	 * Default serial ID.
	 */
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String modelSelect = request.getParameter("modelSelect");
        PrintWriter out = response.getWriter();
        DefaultSocketClient clientSocket = new DefaultSocketClient("localhost", 7799);
        // get the information of the selected model
        Automobile auto = clientSocket.getModelInfo(modelSelect);
        String docType =
        	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        	      "Transitional//EN\">\n";
        out.println(docType + "<html>\n<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"show.css\">");
        out.println("<title>Basic Car Choice</title></head>");
        out.println("<body><div>");
        out.println("<h1>Basic Car Choice</h1>");
        // print the form
        out.println("<form action=\"show.jsp\">"
        		+ "<table action=\"ConfigModel\">");
        out.println("<tr><td class=\"midbold\">Make/Model: </td><td>"
            					+ auto.getName() + "</td></tr>");
        for (int i = 0; i < auto.getOptionSetSize(); i++) {
        	String optSet = auto.getOptionSetName(i);
            out.println("<tr><td class=\"midbold\"><b>" + optSet + ": " +"</b></td>");
            out.println("<td><select name=\"" + optSet + "\">");
            for(int j = 0; j < auto.getOptionSize(i); j++) {
            	String optionName;
				try {
					optionName = auto.getOptionName(optSet, j);
					out.println("<option value=\"" + optionName + "\">"
										+ optionName + "</option>");
				} catch (AutoException e) {
					e.fix(e.getErrorNo());
				}
            }
            out.println("</select></td>\n</tr>");	
        }
        out.println("<tr><td class=\"input\" colspan=2>"
            		+ "<input type=\"submit\" value=\"Done\"/></td></tr>");
        out.println("</table>\n</form>\n</div>\n</body>\n</html>");
        // use http session so that the show.jsp can get this automobile
        HttpSession session = request.getSession(true);
        session.setAttribute("automobile", auto);
    }

    /** POST and GET requests handled identically. */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}