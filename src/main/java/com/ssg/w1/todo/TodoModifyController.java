package com.ssg.w1.todo;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import com.ssg.w1.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // /todo/read?tno=3
        Long tno = Long.parseLong(req.getParameter("tno"));
        TodoVO vo = null; //데이터 가져오기
        try {
            vo = TodoService.INSTANCE.get(tno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("dto",vo); //데이터 담기

        RequestDispatcher dispatcher = req.getRequestDispatcher("/todo/modify.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDAO dao = new TodoDAO();

        Long tno = Long.parseLong(req.getParameter("tno"));
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        Boolean finished = Boolean.valueOf(req.getParameter("finished"));

        TodoVO vo = TodoVO.builder()
                .tno(tno)
                .title(title)
                .dueDate(LocalDate.parse(date))
                .finished(finished)
                .build();
        try {
            dao.updateOne(vo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/todo/list");
    }
}
