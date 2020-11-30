/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.AdminLogDAO;
import daos.CakeDAO;
import dtos.AdminLogDTO;
import dtos.CakeDTO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dtos.UserDTO;
import utils.StringLib;

/**
 *
 * @author baoph
 */
@MultipartConfig
public class UpdateController extends HttpServlet {

    public static final String SUCCESS = "HomeController";
    public static final String ERROR = "invalid.jsp";

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
            int cakeID = Integer.parseInt(request.getParameter("txtID"));
            String cakeName = request.getParameter("txtCakeName");
            float cakePrice = Float.parseFloat(request.getParameter("txtPrice"));
            String description = request.getParameter("txtDescription");
            String category = request.getParameter("txtCategory");
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            boolean status = Boolean.parseBoolean(request.getParameter("txtStatus"));
            String createDate = request.getParameter("txtCreateDate");
            String expirationDate = request.getParameter("txtExDate");
            String unicodeCakeName = StringLib.toUnicode(cakeName);
            String unicodeDescription = StringLib.toUnicode(description);
            String unicodeCategory = StringLib.toUnicode(category);
            java.util.Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(createDate);
            java.util.Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);
            java.sql.Date dateStart = new java.sql.Date(startDate.getTime());
            java.sql.Date dateEnd = new java.sql.Date(endDate.getTime());
            Part part = request.getPart("photo");
            InputStream is = part.getInputStream();
            UserDTO admin = (UserDTO) request.getSession().getAttribute("ADMIN");
            String email = admin.getEmail();
            String action = "Update";
            Timestamp logDate = new Timestamp(System.currentTimeMillis());
            CakeDAO dao = new CakeDAO();
            CakeDTO dto = new CakeDTO(0, unicodeCakeName, unicodeDescription, unicodeCategory, "".getBytes(), cakePrice, quantity, dateStart, dateEnd, status);
            dao.update(dto, is, cakeID);
            AdminLogDAO adminLogDAO = new AdminLogDAO();
            AdminLogDTO adminLogDTO = new AdminLogDTO(0,email,action,logDate);
            adminLogDAO.create(adminLogDTO);
            url = SUCCESS;
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
