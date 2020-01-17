package calculatorApp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaclulatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("./content/calculator.html; charset=UTF-8");
        String op1s = req.getParameter("op1");
        String op2s = req.getParameter("op2");
        String ops = req.getParameter("op");
        String ids = req.getParameter("id");
        int op1 = Integer.parseInt(op1s);
        int op2 = Integer.parseInt(op2s);
        int id = Integer.parseInt(ids);
        int r = CalculatorImpl.do_op(op1, op2, ops);
        DataBaseOperations.insert_op(op1, op2, ops, r, id);
    }
}

