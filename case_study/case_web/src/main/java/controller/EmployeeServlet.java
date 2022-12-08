package controller;

import model.Employee;
import model.Facility;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                try {
                    createEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            case "search":
                try {
                    searchEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        List<Employee> employeeList = iEmployeeService.searchByName(name);
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request,response);
    }


    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        String idCard = request.getParameter("id_card");
        double salary =Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String namePosition = request.getParameter("name_position");
        String nameEducationDegree = request.getParameter("name_education_degree");
        String nameDivision = request.getParameter("name_division");
        Employee book = new Employee(id,name,dateOfBirth,idCard,salary,phoneNumber,email,address,namePosition,nameEducationDegree,nameDivision);
        iEmployeeService.updateEmployee(book);
        response.sendRedirect("/employee");
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        String idCard = request.getParameter("id_card");
        double salary =Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String namePosition = request.getParameter("name_position");
        String nameEducationDegree = request.getParameter("name_education_degree");
        String nameDivision = request.getParameter("name_division");
        Employee book = new Employee(id,name,dateOfBirth,idCard,salary,phoneNumber,email,address,namePosition,nameEducationDegree,nameDivision);
        iEmployeeService.addEmployee(book);
        listEmployee(request,response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            boolean check = iEmployeeService.deleteEmployee(id);
            String mess = "Xóa không thành công";
            if (check) {
                mess = "xóa thành công";
            }
            request.setAttribute(mess, mess);

            listEmployee(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                showAddEmployee(request,response);
                break;
            case "edit":
                showEditEmployee(request,response);
                break;
            default:
                try {
                    listEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher("view/employee/list.jsp");
        rs.forward(request,response);

    }

    private void showAddEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher("view/employee/list.jsp");
        rs.forward(request,response);
   }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Employee> employeeList = iEmployeeService.selectEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
