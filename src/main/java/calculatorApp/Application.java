package calculatorApp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;



public class Application {

    public static void main(String[] args) throws Exception {

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(CaclulatorServlet.class, "/calculate/*");
        handler.addServlet(LoginServlet.class, "/login/*");
        handler.addServlet(CookieImpl.class, "/cookie/*");


        Server server = new Server(9001);
        server.setHandler(handler);
        server.start();
        server.join();

    }


}
