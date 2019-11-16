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
import java.util.Objects;

@WebServlet("/FindUser")
public class FindUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constans.FindUser).forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        if(Objects.nonNull(req.getParameter("id"))) {
            DBManager manager = new DBManager();
            User user2 = manager.getUserById(Integer.parseInt(req.getParameter("id")));
            req.getSession().setAttribute("user2", user2);
            resp.sendRedirect("/OpenDialog");
        }
    }

//    private boolean SearchDialog(User user, User2 user2){
//        if(user.getId())
//        return true;
//    }
}
