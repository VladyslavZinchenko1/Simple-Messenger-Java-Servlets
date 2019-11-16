package controller;

import db.DBManager;
import entity.User;
import utility.Constans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignIn")
public class SignInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constans.SIGN_IN).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        User user =initUser(manager,req);
        req.getSession().setAttribute("user", user);
        if(user.getId()==0){
            resp.sendRedirect("/SignIn");
        }
        else {
            resp.sendRedirect("/FindUser");
        }
    }
    private User initUser(DBManager dbManager, HttpServletRequest request){
return dbManager.getUserByUsernameAndPassword(request.getParameter("username"),request.getParameter("password"));
    }
}
