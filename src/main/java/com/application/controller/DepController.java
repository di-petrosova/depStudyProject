package com.application.controller;

import com.application.data.DepartmentData;
import com.application.service.DepartmentService;
import com.application.service.impl.DefaultDepartmentService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DepController extends HttpServlet {

    /**
     * Respond to a GET request for the content produced by
     * this servlet.
     * @param request The servlet request we are processing
     * @param response The servlet response we are producing
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    private DepartmentService departmentService = new DefaultDepartmentService();
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException
    {
        if ("/department".equals(request.getServletPath())) {
            List<DepartmentData> allDepartments = departmentService.getAllDepartments();

            request.setAttribute("departments", allDepartments);

            request.getRequestDispatcher("/WEB-INF/jsp/departments-list.jsp").forward(request, response);
        }

        if("/department/create".equals(request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/jsp/create-edit-department.jsp").forward(request, response);
        }

        if("/department/edit".equals(request.getServletPath())) {
            String idToEdit = request.getParameter("idToEdit");
            DepartmentData departmentById = departmentService.getDepartmentById(idToEdit);
            if(Objects.nonNull(departmentById)) {
                request.setAttribute("currentDepartment", departmentService.getDepartmentById(idToEdit));
            }
            request.getRequestDispatcher("/WEB-INF/jsp/create-edit-department.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if ("/department".equals(req.getServletPath())) {
            String idToRemove = req.getParameter("idToRemove");
            List<DepartmentData> leftDepartments = departmentService.removeDepartment(idToRemove);

            req.setAttribute("departments", leftDepartments);

            req.getRequestDispatcher("/WEB-INF/jsp/departments-list.jsp").forward(req, resp);
        }

        if ("/department/create".equals(req.getServletPath())) {
            departmentService.createDepartment(req);
            resp.sendRedirect(req.getContextPath() + "/department");
        }

        if ("/department/edit".equals(req.getServletPath())) {
            departmentService.editDepartment(req);
            resp.sendRedirect(req.getContextPath() + "/department");
        }

    }
}
