package com.ssg.w1.todo.service;

import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE; //이 통로를 이용해야만 한다.

    //글 하나를 등록하는 기능
    public void register(TodoDTO dto) {
        System.out.println("Debug..." + dto);
    }

    //등록된 글 목록 반환하는 기능
    //10개의 TodoDTO(글)을 만들어서 List 객체로 반환

    TodoDAO dao = new TodoDAO();
    public List<TodoVO> getList() throws Exception{
        List<TodoVO> list = dao.selectAllList();

        return list;
    }

    //특정 tno의 dto
    public TodoVO get(Long tno) throws Exception {
        TodoVO vo = dao.selectOne(tno);
        return vo;
    }
}
