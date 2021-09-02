package com.sb.batch.tasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.sb.batch.model.Student;

@Component
public class ItemReaderSample implements ItemReader<List<Student>>{
	@Autowired
	private JdbcTemplate template;
	@Override
	public List<Student> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		String sql="select * from Student";
		List<Student> studentList=template.query(sql, new ResultSetExtractor<List<Student>>() {
		@Override
		public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Student> list=new ArrayList<>();
			while(rs.next()) {
				Student student=new Student();
				student.setId(rs.getInt("sid"));
				student.setName(rs.getString("sname"));
				list.add(student);
			}
			return list;
		}
		});
		return studentList;
	}

}
