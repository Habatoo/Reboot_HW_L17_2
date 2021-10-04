package laptenkov;

import laptenkov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Написать веб-приложение, которое работает с формой (два
 * текстовых поля – заголовок поста и содержимое) и позволяет
 * добавлять посты в ленте и отображать их после отправки формы
 *
 * @author habatoo
 */
@WebServlet("/")
public class Servlet extends HttpServlet {

    public static final String FIRST_NAME = "userFirstName";
    public static final String LAST_NAME = "userLastName";

    /**
     * Метод возвращает значения из сессии по имени параметра
     * при запросе POST по адресу http://localhost:8080/HW_L17_2/
     *
     * @param request  запрос по адресу http://localhost:8080/HW_L17_2/
     * @param response ответ при запросе по адресу http://localhost:8080/HW_L17_2/
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");
            HttpSession session = request.getSession(true);
            String url = "/index.jsp";

            String userFirstName = request.getParameter(FIRST_NAME);
            String userLastName = request.getParameter(LAST_NAME);

            User user = new User(userFirstName, userLastName);
            request.setAttribute("user", user);
            session.setAttribute(userFirstName, userLastName);

            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);

        } catch (IOException exp) {
            exp.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод возвращает значения из сессии по имени параметра
     * при запросе GET по адресу http://localhost:8080/HW_L17_2/
     *
     * @param request  запрос по адресу http://localhost:8080/HW_L17_2/
     * @param response ответ при запросе по адресу http://localhost:8080/HW_L17_2/
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

}
