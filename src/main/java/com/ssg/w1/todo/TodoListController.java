package com.ssg.w1.todo;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import com.ssg.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list.....call");
        List<TodoVO> dtoList = null; //데이터 가져오기
        try {
            dtoList = TodoService.INSTANCE.getList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("dtoList",dtoList); //가져온 데이터 request에 담기
        req.getRequestDispatcher("/todo/list.jsp").forward(req,resp); //forward(req,resp) --> 이동할때 req랑 resp를 가지고 이동해라
    }
}
