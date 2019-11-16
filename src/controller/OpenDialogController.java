package controller;

import db.DBManager;
import entity.Dialog;
import entity.User;
import utility.Constans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/OpenDialog")
public class OpenDialogController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constans.OPEN_DIALOG_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = new DBManager();
        User user = (User) req.getSession().getAttribute("user");
        User user2 = (User) req.getSession().getAttribute("user2");
        System.out.println(user.getSurname() + user2.getSurname());
        Dialog dialog = dbManager.CreateDialog(initDialog(user, user2));
        req.getSession().setAttribute("dialog", dialog);
        resp.sendRedirect("/Dialog");
    }
    private Dialog initDialog(User user, User user2){
        Dialog dialog = new Dialog();
        dialog.setId_from(user.getId());
        dialog.setId_to(user2.getId());
        return dialog;
    }
}
