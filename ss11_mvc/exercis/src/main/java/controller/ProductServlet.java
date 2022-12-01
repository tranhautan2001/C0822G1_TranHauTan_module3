package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "edit":
               editProduct(request,response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
      int id = Integer.parseInt(request.getParameter("id"));
      String name = request.getParameter("name");
      String point = request.getParameter("point");
      String describe = request.getParameter("describe");
      String producer = request.getParameter("producer");
      Product product = iProductService.findById(id);
      product.setName(name);
      product.setPoint(point);
      product.setDescribe(describe);
      product.setProducer(producer);
      iProductService.update(id,product);
      request.setAttribute("product",product);
      request.getRequestDispatcher("view/edit.jsp");
      listProduct(request,response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.remove(id);
        listProduct(request,response);
        }


    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String point = request.getParameter("point");
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");
        Product product = new Product(name, point, describe, producer);
        iProductService.save(product);
        listProduct(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(request, response);
                break;
            case "delete":
                showDeleteFrom(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "seach":
                showSearchForm(request,response);
                break;
            case "view":
                showViewForm(request,response);
                break;
            default:
                listProduct(request, response);

        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/view.jsp").forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch = request.getParameter("nameSearch");
        List<Product> products = iProductService.findByName(nameSearch == null? "" : nameSearch);
        request.setAttribute("productList",products);
        request.getRequestDispatcher("view/list.jsp");
        listProduct(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/edit.jsp").forward(request, response);
    }

    private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("view/delete.jsp").forward(request, response);


    }

    private void showCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rs = request.getRequestDispatcher("view/add.jsp");
        try {
            rs.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.iProductService.selectAll();
        request.setAttribute("productList", productList);
        RequestDispatcher rs = request.getRequestDispatcher("view/list.jsp");
        try {
            rs.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
