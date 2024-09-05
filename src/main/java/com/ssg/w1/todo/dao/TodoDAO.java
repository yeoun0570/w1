package com.ssg.w1.todo.dao;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    public void insert(TodoVO vo) throws Exception {
        String sql = "INSERT INTO tbl_todo(tno,title,dueDate,finished) VALUES(null,?,?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1,vo.getTitle());
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3,vo.isFinished());

        pstmt.executeUpdate();
    }

    public List<TodoVO> selectAllList() throws Exception {
        String sql = "SELECT * FROM tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while(rs.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();

            list.add(vo);
        }
        return list;
    }

    public TodoVO selectOne(long tno) throws Exception {
        String sql = "SELECT * FROM tbl_todo WHERE tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        TodoVO vo = TodoVO.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();

        return vo;
    }

    //하나 삭제
    public void deleteOne(Long tno) throws Exception{
        String sql = "DELETE FROM tbl_todo WHERE tno=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setLong(1,tno);

        pstmt.executeUpdate();
    }

    //하나 수정
    public void updateOne(TodoVO vo) throws Exception{
        String sql = "UPDATE tbl_todo SET title=?, dueDate=?, finished=? WHERE tno=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1,vo.getTitle());
        pstmt.setDate(2,Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3,vo.isFinished());
        pstmt.setLong(4,vo.getTno());

        pstmt.executeUpdate();
    }
}
