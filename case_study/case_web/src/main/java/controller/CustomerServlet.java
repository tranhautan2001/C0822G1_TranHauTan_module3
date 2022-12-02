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
        switch (action) {
            case "delete":
                deleteID(request, response);
                break;
            case "create":
                try {
                    addCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                editCustomer(request, response);
                break;

        }

    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_customer"));
        int id_customer_type = Integer.parseInt(request.getParameter("id_customer_type"));
        String name = request.getParameter("name");
        String date_of_birth = request.getParameter("date_of_birth");
        String gender
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


    private void deleteID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "create":
                showAddForm(request, response);
                break;
            default:
                listCustomer(request, response);

        }
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
