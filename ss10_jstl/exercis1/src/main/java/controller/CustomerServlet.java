package controller;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet" , urlPatterns = "/list")
public class CustomerServlet extends HttpServlet {
   private static List<Customer> customers = new ArrayList<>();
   static {
       customers.add(new Customer("Trần Hậu Tân","2001/02/27","Tp-Hà Tĩnh","https://vcdn1-dulich.vnecdn.net/2021/07/16/8-1626444967.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=GfgGn4dNuKZexy1BGkAUNA"));
       customers.add(new Customer("Trần Hậu Kiên","1996/11/08","Tp-Hà Tĩnh","https://vcdn1-dulich.vnecdn.net/2021/07/16/8-1626444967.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=GfgGn4dNuKZexy1BGkAUNA"));
       customers.add(new Customer("Trần Hậu Di Đan","2001/10/19","Tp-Hà Tĩnh","https://vcdn1-dulich.vnecdn.net/2021/07/16/8-1626444967.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=GfgGn4dNuKZexy1BGkAUNA"));
       customers.add(new Customer("Trần Hậu Minh Tiến","2001/10/04","Tp-Hà Tĩnh","https://vcdn1-dulich.vnecdn.net/2021/07/16/8-1626444967.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=GfgGn4dNuKZexy1BGkAUNA"));
       customers.add(new Customer("Trần Hậu Minh Khang","2022/10/09","Tp-Hà Tĩnh","https://vcdn1-dulich.vnecdn.net/2021/07/16/8-1626444967.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=GfgGn4dNuKZexy1BGkAUNA"));
       customers.add(new Customer("Trần Hậu Thiên","2017/03/10","Tp-Hà Tĩnh","https://vcdn1-dulich.vnecdn.net/2021/07/16/8-1626444967.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=GfgGn4dNuKZexy1BGkAUNA"));
   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setAttribute("customerList",customers);
         request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
