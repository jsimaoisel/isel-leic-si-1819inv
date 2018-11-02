package pt.isel.si;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServer {

   /*
    * TCP port where to listen.
    * Standard port for HTTP is 80 but might be already in use
    */
   private static final int LISTEN_PORT = 3080;
        
   public static void main(String[] args) throws Exception {

       System.setProperty("org.slf4j.simpleLogger.levelInBrackets","true");

        Logger logger = LoggerFactory.getLogger(HttpServer.class);
        logger.info("Starting main...");

        String portDef = System.getenv("PORT");
        int port = portDef != null ? Integer.valueOf(portDef) : LISTEN_PORT;
    	Server server = new Server(port);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(
                new ServletHolder(new ProtectedServlet()), "/index");
        server.start();
        logger.info("Server started");
        server.join();

       logger.info("main ends.");
    }    
}
