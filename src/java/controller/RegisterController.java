/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.UserDAO;
import dtos.ErrorUserDTO;
import dtos.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baoph
 */
public class RegisterController extends HttpServlet {
    private static final String SUCCESS = "login.html";
    private static final String ERROR = "register.jsp";

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
        String url = ERROR;
        try {

            ErrorUserDTO errorDTO = new ErrorUserDTO("", "", "", "");
            boolean check = true;
            String email = request.getParameter("txtEmail");
            String name = request.getParameter("txtName");
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtRePassword");
            if (email.length() < 1) {
                errorDTO.setErrorEmail("Email can not empty");
                check = false;
            }
            if (name.length() < 1 || name.length() > 5) {
                errorDTO.setErrorName("Name <1 and >5");
                check = false;
            }
            if (password.length() < 1) {
                errorDTO.setErrorPassword("Password can not empty");
                check = false;
            }
            if (!password.equals(rePassword)) {
                errorDTO.setErrorPassword("Password not match");
                check = false;
            }
            UserDAO dao = new UserDAO();
            boolean exits = dao.checkID(email);
            if (!exits) {
                errorDTO.setErrorEmail("Email is duplicate");
                check = false;
            }
            String sha256 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
            if (check) {
                UserDTO dto = new UserDTO(email, name, sha256, "Member");
                dao.create(dto);
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_USER", errorDTO);
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
