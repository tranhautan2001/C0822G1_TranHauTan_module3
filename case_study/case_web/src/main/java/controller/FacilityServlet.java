package controller;

import model.Customer;
import model.Facility;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FacilityServlet" ,urlPatterns = "/facility")
public class FacilityServlet extends HttpServlet {
    IFacilityService iFacilityService = new FacilityService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createVilla":
                try {
                    addFacilityVilla(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "createHouse":
                try {
                    addFacilityHouse(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "createRoom":
                try {
                    addFacilityRoom(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                    deleteFacility(request, response);
                break;
            case "edit":
                try {
                    updateFacility(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    searchFacility(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_facility"));
        String name = request.getParameter("name_facility");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost =Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
        String facilityFree = request.getParameter("facility_free");
        String nameFacilityType = request.getParameter("name_facility_type");
        String nameRentType = request.getParameter("name_rent_type");
        Facility book = new Facility(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,facilityFree,nameFacilityType,nameRentType);
        iFacilityService.updateFacility(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void addFacilityRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id_facility"));
        String name = request.getParameter("name_facility");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost =Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
        String facilityFree = request.getParameter("facility_free");
        String nameFacilityType = request.getParameter("name_facility_type");
        String nameRentType = request.getParameter("name_rent_type");
        Facility book = new Facility(id,name,area,cost,maxPeople,poolArea,numberOfFloors,facilityFree,nameFacilityType,nameRentType);
        iFacilityService.addFacilityRoom(book);
        listFacility(request,response);

    }

    private void addFacilityHouse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_facility"));
        String name = request.getParameter("name_facility");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost =Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
        String nameFacilityType = request.getParameter("name_facility_type");
        String nameRentType = request.getParameter("name_rent_type");
        Facility book = new Facility(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,nameFacilityType,nameRentType);
        iFacilityService.addFacilityHouse(book);
        listFacility(request,response);

    }

    private void addFacilityVilla(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id_facility"));
        String name = request.getParameter("name_facility");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost =Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloors = Integer.parseInt(request.getParameter("number_of_floors"));
        String nameFacilityType = request.getParameter("name_facility_type");
        String nameRentType = request.getParameter("name_rent_type");
        Facility book = new Facility(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,nameFacilityType,nameRentType);
        iFacilityService.addFacilityVilla(book);
        listFacility(request,response);
    }

    private void searchFacility(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
      String name = request.getParameter("name_facility");
      List<Facility> facilities = iFacilityService.searchName(name);
      request.setAttribute("facilityList",facilities);
      RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
      dispatcher.forward(request,response);
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("id_facility"));
        try {
            boolean check = iFacilityService.deleteFacility(id);
            String mess = "xóa không thành công";
            if (check) {
                mess = "xóa thành công";
            }
            request.setAttribute(mess, mess);
            listFacility(request, response);
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
            case "createHouse":
               showAddHouse(request, response);
                break;
            case "createVilla":
                showAddVilla(request, response);
                break;
            case "createRoom":
                showAddRoom(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                try {
                    listFacility(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_facility"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/edit.jsp");
        Facility facility=iFacilityService.selectFacility(id);
        request.setAttribute("facility", facility);
        dispatcher.forward(request,response);
    }

    private void showAddRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher("view/facility/add_room.jsp");
        rs.forward(request,response);
    }

    private void showAddVilla(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher("view/facility/add_villa.jsp");
        rs.forward(request,response);
    }

    private void showAddHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher("view/facility/add_house.jsp");
      rs.forward(request,response);
    }

    private void listFacility(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Facility> facilityList = iFacilityService.selectFacility();
        request.setAttribute("facilityList",facilityList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
