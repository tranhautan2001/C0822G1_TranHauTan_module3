package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    addCustomer(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request,response);
                    break;
                case "search":
                    searchCustomer(request,response);
                    break;
            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Customer> customers = iCustomerService.searchByName(name);
        request.setAttribute("customerList",customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id_customer_type = Integer.parseInt(request.getParameter("id_customer_type"));
        String name = request.getParameter("name");
        String date_of_birth = request.getParameter("date_of_birth");
        String gender =request.getParameter("gender");
        int id_card = Integer.parseInt(request.getParameter("id_card"));
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer book = new Customer(id_customer_type,name,date_of_birth,gender,id_card,phone_number,email,address);
        iCustomerService.updateCustomer(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request,response);
    }
    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_customer"));
        int id_customer_type = Integer.parseInt(request.getParameter("id_customer_type"));
        String name = request.getParameter("name");
        String date_of_birth = request.getParameter("date_of_birth");
        String gender = request.getParameter("gender");
        int id_card = Integer.parseInt(request.getParameter("id_card"));
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer book = new Customer(id, id_customer_type, name, date_of_birth, gender, id_card, phone_number, email, address);
        iCustomerService.addCustomer(book);
        listCustomer(request, response);
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_customer = Integer.parseInt(request.getParameter("id_customer"));
        boolean check = iCustomerService.delete(id_customer);
        String mess = "xóa không thành công";
        if (check) {
            mess = "xóa thành công";
        }
        request.setAttribute(mess, mess);
        listCustomer(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                break;
            case "create":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listCustomer(request, response);
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_customer"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("customer", iCustomerService.selectCustomer(id));
        dispatcher.forward(request,response);
    }
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("view/customer/add.jsp");
        rd.forward(request,response);
    }
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = iCustomerService.selectCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
