package fi.antti.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.antti.spring.bean.Piste;

public class PisteRowMapper implements RowMapper<Piste> {

	public Piste mapRow(ResultSet rs, int rowNum) throws SQLException {

		Piste p = new Piste();

		p.setName(rs.getString("nimi"));
		p.setPisteet(rs.getInt("lkm"));

		return p;
	}

}
