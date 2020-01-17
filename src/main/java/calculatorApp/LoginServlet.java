package calculatorApp;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginServlet extends HttpServlet implements Constant {

   AuthHashMap authHash = new AuthHashMap();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Files.copy(Paths.get("./content/login.html"), resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.printf("name:%s\n",name);
        System.out.printf("paswd:%s\n",password);
        authHash.db.put(name, password);
        try (PrintWriter w = resp.getWriter()) {
            if(authHash.check(name, password)) {
                w.printf("Auth for user:%s passwd:%s Error", name, password);
                Cookie c = new Cookie(COOKIE_NAME, name);
                resp.addCookie(c);
            } else {
                w.printf("Auth for user:%s passwd:%s Error", name, password);
                Cookie c = new Cookie(COOKIE_NAME, name);
                resp.addCookie(c);
            }
        }

    }
}
