package com.ssg.dao;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    TodoDAO dao = new TodoDAO();

    @Test
    public void testInsert() throws Exception {
        TodoVO vo = TodoVO.builder()
                .title("Sample title...")
                .dueDate(LocalDate.of(2024,9,5))
                .build();

        dao.insert(vo);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = dao.selectAllList();
        list.forEach(vo-> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception{
        TodoVO vo = dao.selectOne(1);
        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO vo = TodoVO.builder()
                .tno(1L)
                .title("UpdateTest...")
                .dueDate(LocalDate.of(2024,9,5))
                .finished(true)
                .build();
        dao.updateOne(vo);
    }

    @Test
    public void testDeleteOne() throws Exception{
        dao.deleteOne(1L);
    }
}
