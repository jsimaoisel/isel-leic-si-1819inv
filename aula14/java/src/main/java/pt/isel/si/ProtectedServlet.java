package pt.isel.si;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;


public class ProtectedServlet extends HttpServlet {
    Random rnd = new Random();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("WWW-Authenticate", "Basic realm=\"SIDomain\"");
        resp.setStatus(401);
    }

}


        /*Cookie c;
        if ((c = hasCookie(req, "SIDemo"))!=null) {
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(resp.getOutputStream()));
            writer.write("<html><p>Valid cookie was sent by the user-agent</p>");
            writer.write("<code>"+c.getName()+":"+c.getValue()+"</code></html>");
            writer.close();
            resp.setStatus(200);
        } else {
            String authnHeaderValue = req.getHeader("Authorization");
            if (authnHeaderValue == null) {
                resp.addHeader("WWW-Authenticate", "Basic realm=\"SIDomain\"");
                resp.setStatus(401);
            } else {
                resp.addHeader("Set-Cookie", "SIDemo=" + rnd.nextInt());
                resp.setStatus(200);
                BufferedWriter writer =
                        new BufferedWriter(
                                new OutputStreamWriter(resp.getOutputStream()));
                writer.write("Success with : " + authnHeaderValue);
                writer.close();
            }
        }*/


    /*private Cookie hasCookie(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }*/
