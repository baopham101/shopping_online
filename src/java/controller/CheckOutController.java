/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.CakeDAO;
import daos.OrderDAO;
import daos.OrderDetailDAO;
import dtos.CakeDTO;
import dtos.CartDTO;
import dtos.OrderDTO;
import dtos.OrderDetailDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author baoph
 */
public class CheckOutController extends HttpServlet {

    public static final String MEMBER = "OrderController";
    public static final String GUEST = "HomeController";
    public static final String ERROR = "invalid.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        CakeDAO cakeDAO = new CakeDAO();
        HttpSession session = request.getSession();
        CartDTO cartDTO = (CartDTO) session.getAttribute("CART");
        try {
            OrderDAO dao = new OrderDAO();
            UserDTO user = (UserDTO) request.getSession().getAttribute("MEMBER");

            if (user == null) {
                Timestamp orderDate = new Timestamp(System.currentTimeMillis());
                String phoneNumber = request.getParameter("txtPhoneNumber");
                String guestName = request.getParameter("txtName");
                String address = request.getParameter("txtAddress");
                String radio = request.getParameter("optradio");
                String paymentMethod = null;
                if ("Direct Bank Tranfer".equals(radio)) {
                    paymentMethod = radio;
                } else if ("COD".equals(radio)) {
                    paymentMethod = radio;
                }
                OrderDTO dto = new OrderDTO(0, orderDate, phoneNumber, guestName, address, paymentMethod, null, true);
                dao.create(dto);
                for (CakeDTO cakeDTO : cartDTO.getCart().values()) {
                    int cakeID = cakeDTO.getId();
                    int cakeQuantity = cakeDAO.getQuantityByCakeID(cakeID);
                    int quantity = cakeDTO.getCartQuantity();
                    int orderID = dao.getOrderID();
                    if (cakeQuantity > quantity) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                        OrderDetailDTO orderDetailDTO = new OrderDetailDTO(0, orderID, cakeID, dto.getOrderDate());
                        orderDetailDAO.create(orderDetailDTO);
                        cakeDAO.updateQuantity(cakeID, cakeQuantity - quantity);
                    }
                }
                session.setAttribute("CART", null);
                url = GUEST;
            } else {
                String email = user.getEmail();
//                int ID = Integer.parseInt(request.getParameter("txtcakeID"));
                Timestamp orderDate = new Timestamp(System.currentTimeMillis());
                String radio = request.getParameter("optradio");
                String paymentMethod = null;
                if ("Direct Bank Tranfer".equals(radio)) {
                    paymentMethod = radio;
                } else if ("COD".equals(radio)) {
                    paymentMethod = radio;
                }
                String address = request.getParameter("txtAddress");
                OrderDTO dto = new OrderDTO(0, orderDate, null, null, address, paymentMethod, email, true);
                dao.create(dto);
                for (CakeDTO cakeDTO : cartDTO.getCart().values()) {
                    int cakeID = cakeDTO.getId();
                    int cakeQuantity = cakeDAO.getQuantityByCakeID(cakeID);
                    int quantity = cakeDTO.getCartQuantity();
                    int orderID = dao.getOrderID();
                    if (cakeQuantity > quantity) {
                        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                        OrderDetailDTO orderDetailDTO = new OrderDetailDTO(0, orderID, cakeID, dto.getOrderDate());
                        orderDetailDAO.create(orderDetailDTO);
                        cakeDAO.updateQuantity(cakeID, cakeQuantity - quantity);
                    }
                }
                session.setAttribute("CART", null);
                url = MEMBER;
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
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
