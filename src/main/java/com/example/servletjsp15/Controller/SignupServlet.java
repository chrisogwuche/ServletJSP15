package com.example.servletjsp15.Controller;

import com.example.servletjsp15.DAO.signupDOA;
import com.example.servletjsp15.Model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");

        User user = new User(firstname,lastname,password);
        signupDOA signup = new signupDOA();
        try {
            int count = signup.signup(user);
            if(count > 0){
                request.setAttribute("status","success");
            }

            dispatcher.forward(request,response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
