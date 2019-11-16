package controller;

import db.DBManager;
import entity.Dialog;
import utility.Constans;
import utility.MyComparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Collections;
import java.util.List;

@WebServlet("/Dialog")
public class DialogController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager = new DBManager();
        Dialog dialog = (Dialog) req.getSession().getAttribute("dialog");

        List<Dialog> contentDialogList = dbManager.GetDialogContent(dialog);
        contentDialogList.sort(new MyComparator());
        req.getSession().setAttribute("ContentInDatabase", contentDialogList);

        req.getRequestDispatcher(Constans.DIALOG_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { java.util.Date utilDate = new java.util.Date();
      //  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Dialog dialog = (Dialog) req.getSession().getAttribute("dialog");
        dialog.setContent(req.getParameter("massage"));
      //  dialog.setDate(sqlDate);
       // dialog.setId_from(Integer.parseInt((String) req.getSession().getAttribute("dialog.id_from")));
       // dialog.setId_from(Integer.parseInt((String) req.getSession().getAttribute("dialog.id_to")));
        DBManager dbManager = new DBManager();
        dbManager.InitContent(dialog);
        resp.sendRedirect("/Dialog");
    }
}
