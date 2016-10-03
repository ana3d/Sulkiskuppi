package fi.antti.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.antti.spring.bean.Pelaaja;

public class PelaajaRowMapper implements RowMapper<Pelaaja> {

	public Pelaaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelaaja t = new Pelaaja();
		
		t.setName(rs.getString("name"));
		t.setId(rs.getInt("id"));
		
		return t;
	}
}