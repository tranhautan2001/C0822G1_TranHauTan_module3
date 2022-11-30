import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "DiscorServlet" , urlPatterns = "/display")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String productDescription = request.getParameter("Description");
       double listPrice = Double.parseDouble(request.getParameter("Price"));
       double discountPercent = Double.parseDouble(request.getParameter("Percent"));
        BigDecimal price = new BigDecimal(listPrice);
        BigDecimal discountAmount = new BigDecimal(listPrice* discountPercent * 0.01);
        BigDecimal discountPrice = price.subtract(discountAmount);

        request.setAttribute("Description",productDescription);
        request.setAttribute("Price",listPrice);
        request.setAttribute("Percent",discountPercent);
        request.setAttribute("discountAmount",discountAmount);
        request.setAttribute("discountPrice",discountPrice);
        request.getRequestDispatcher("resufl.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
