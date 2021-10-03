package Laptenkov;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Написать веб-приложение, которое работает с формой (два
 * текстовых поля – заголовок поста и содержимое) и позволяет
 * добавлять посты в ленте и отображать их после отправки формы
 *
 * @author habatoo
 */
@WebServlet("/")
public class Servlet extends HttpServlet {

    /**
     * Метод возвращает значения из сессии по имени параметра
     * при запросе GET по адресу http://localhost:8080/HW_L17_2/users
     *
     * @param request  запрос по адресу http://localhost:8080/HW_L17_2/users
     * @param response ответ при запросе по адресу http://localhost:8080/HW_L17_2/users
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        try (ServletOutputStream outputStream = response.getOutputStream())
        {
            response.setContentType("text/html");
            HttpSession session = request.getSession(true);

            outputStream.println("<form action=\"\">");
            outputStream.println("    User FirstName:<input type=\"text\" name=\"userFirstName\"/><br/>");
            outputStream.println("    User LastName:<input type=\"text\" name=\"userLastName\"/><br/>");
            outputStream.println("    <input type=\"submit\" value=\"submit\"/>");
            outputStream.println("</form>");

            String firstName = request.getParameter("userFirstName");
            String lastName = request.getParameter("userLastName");

            session.setAttribute(firstName, lastName);

            Enumeration keys = session.getAttributeNames();
            while (keys.hasMoreElements())
            {
                String key = (String) keys.nextElement();
                outputStream.println("User FirstName: " + key + ", LastName: " + session.getValue(key) + "<br>");
            }

        } catch (IOException exp){
            exp.printStackTrace();
        }
    }

}
