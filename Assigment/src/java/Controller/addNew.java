/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DatabaseConnector;

/**
 *
 * @author oteee
 */
public class addNew extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addNew</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addNew at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addNewAccout.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String conPassword = request.getParameter("conPassword");
        String role = request.getParameter("role");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()
                || conPassword == null || conPassword.isEmpty() || role == null || role.isEmpty()) {
            response.sendRedirect("addNewAccout.jsp?error=Please fill in all fields");
            return;
        }
        if (!password.equals(conPassword)) {
            response.sendRedirect("addNewAccout.jsp?error=Password do not match");
            return;
        }
        if (!email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")) {
            response.sendRedirect("addNewAccout.jsp?error=Invalid email format");
            return;
        }
//        if ("Customer".equals(role)) {
//            String customerField = request.getParameter("customerField");
//            if (customerField == null || customerField.isEmpty()) {
//                response.sendRedirect("addNewAccout.jsp?error=Please fill in Customer Field 1");
//                return;
//            }
//        }
        try {
            Connection connection = DatabaseConnector.getConnection();

            String insertQuery = "INSERT INTO customer (address, Username, phone, password, name, email) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, "Dia chi"); // Giá trị cho tham số 1
                preparedStatement.setString(2, "TenDangNhap"); // Giá trị cho tham số 2
                preparedStatement.setString(3, "0849431868"); // Giá trị cho tham số 3
                preparedStatement.setString(4, password); // Giá trị cho tham số 4
                preparedStatement.setString(5, "HoTen"); // Giá trị cho tham số 5
                preparedStatement.setString(6, email); // Giá trị cho tham số 

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    request.setAttribute("signupSuccess", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect("addNewAccout.jsp?error=Failed to add new account");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("addNewAccout.jsp?error=Database error" + e);
            return;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
