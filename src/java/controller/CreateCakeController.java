/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.CakeDAO;
import dtos.CakeDTO;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.StringLib;

/**
 *
 * @author baoph
 */
@MultipartConfig
public class CreateCakeController extends HttpServlet {

    public static final String SUCCESS = "createcake.jsp";
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
//            String cakeID = request.getParameter("txtID");
            String cakeName = request.getParameter("txtName");
            String description = request.getParameter("txtDescription");
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            String createDate = request.getParameter("txtCreateDate");
            String expirationDate = request.getParameter("txtExpirationDate");
            java.util.Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(createDate);
            java.util.Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);
            java.sql.Date dateStart = new java.sql.Date(startDate.getTime());
            java.sql.Date dateEnd = new java.sql.Date(endDate.getTime());
            String category = request.getParameter("txtCategory");
            String unicodeCakeName = StringLib.toUnicode(cakeName);
            String unicodeDescription = StringLib.toUnicode(description);
            String unicodeCategory = StringLib.toUnicode(category);
            Part part = request.getPart("photo");
            InputStream is = part.getInputStream();
            CakeDAO dao = new CakeDAO();
            CakeDTO dto = new CakeDTO(0, unicodeCakeName, unicodeDescription, unicodeCategory, "".getBytes(), price, quantity, dateStart, dateEnd, true);
            dao.create(dto, is);
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
