package com.pharmacy.controllers;

import com.pharmacy.daoImp.MedicineDaoImp;
import com.pharmacy.models.Medicine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getMedicine")
public class GetMedicine extends HttpServlet {
    private MedicineDaoImp medicineDao = new MedicineDaoImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // Prevent creating a new session
        if (session == null || session.getAttribute("email") == null) {
            resp.sendRedirect("Userlogin");
            return;
        }

        List<Medicine> medicines = medicineDao.getAllMedicines();

        // Set response type to HTML
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // Get PrintWriter to output HTML content
        PrintWriter out = resp.getWriter();

        // Write HTML Structure
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Medicine List</title>");
        out.println("<style>");

        // CSS Styles
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding: 20px; }");
        out.println("h2 { color: #333; margin-bottom: 20px; }");
        out.println("table { width: 80%; margin: auto; border-collapse: collapse; background: white; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); border-radius: 8px; }");
        out.println("th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }");
        out.println("th { background: #007bff; color: white; }");
        out.println("tr:nth-child(even) { background: #f2f2f2; }");
        out.println("button { background-color: #28a745; color: white; border: none; padding: 8px 12px; cursor: pointer; border-radius: 5px; transition: background 0.3s; }");
        out.println("button:hover { background-color: #218838; }");
        out.println("button.delete-btn { background-color: #dc3545; }");
        out.println("button.delete-btn:hover { background-color: #c82333; }");
        out.println("a { display: inline-block; background: #007bff; color: white; padding: 10px; margin-top: 15px; text-decoration: none; border-radius: 5px; transition: background 0.3s; }");
        out.println("a:hover { background: #0056b3; }");
        out.println(".logout { background-color: #ff6600; margin-top: 20px; }");
        out.println(".logout:hover { background-color: #e65c00; }");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Medicines List</h2>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Price</th>");
        out.println("<th>Stock</th>");
        out.println("<th>Actions</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        // Generate Table Rows Dynamically
        if (medicines != null && !medicines.isEmpty()) {
            for (Medicine med : medicines) {
                out.println("<tr>");
                out.println("<td>" + med.getId() + "</td>");
                out.println("<td>" + med.getName() + "</td>");
                out.println("<td>$" + med.getPrice() + "</td>");
                out.println("<td>" + med.getStock() + "</td>");

                // Update Form
                out.println("<td>");
                out.println("<form action='updateMedicine' method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='action' value='update'>");
                out.println("<input type='hidden' name='id' value='" + med.getId() + "'>");
                out.println("<input type='text' name='name' value='" + med.getName() + "' required>");
                out.println("<input type='number' name='price' value='" + med.getPrice() + "' step='0.01' required>");
                out.println("<input type='number' name='stock' value='" + med.getStock() + "' required>");
                out.println("<button type='submit'>Update</button>");
                out.println("</form>");

                // Delete Form
                out.println("<form action='deleteMedicine' method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='action' value='delete'>");
                out.println("<input type='hidden' name='id' value='" + med.getId() + "'>");
                out.println("<button type='submit' class='delete-btn' onclick='return confirm(\"Are you sure you want to delete this medicine?\");'>Delete</button>");
                out.println("</form>");

                out.println("</td>");
                out.println("</tr>");
            }
        } else {
            out.println("<tr><td colspan='5'>No medicines found.</td></tr>");
        }

        out.println("</tbody>");
        out.println("</table>");

        // Refresh and Logout Buttons
        out.println("<br>");
        out.println("<form action='logout' method='GET' style='display: inline;'>");
        out.println("<button type='submit' class='logout'>Logout</button>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");

        out.close();  // Close the writer
    }
}
