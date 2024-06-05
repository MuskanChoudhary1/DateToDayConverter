package com.packetprep;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateToDay")
public class DateToDay extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        LocalDate date2 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        DayOfWeek day = date2.getDayOfWeek();

        out.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'></head><body class=\"bg-light d-flex justify-content-center align-items-center min-vh-100\"><div class=\"bg-white p-4 shadow w-75\">");
        out.println("<h1 class=\"text-danger fw-bold text-xl pb-4\">Date Converted To Day</h1><p class=\"text-primary text-lg fw-semibold\">" + date + " Converted to " + day + "</p>");
        out.println("</div></body></html>");
    }
}
