package by.tms.insta.servlet;

import by.tms.insta.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-account")
public class DeleteUserServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        long parsedUserId = Long.parseLong(userid);
//        userService.removeAccount();
        req.setAttribute("message", "user deleted");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
