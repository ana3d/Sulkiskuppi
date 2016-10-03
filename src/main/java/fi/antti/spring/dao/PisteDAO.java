package fi.antti.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.antti.spring.bean.Piste;

@Repository
public class PisteDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Piste> haePisteLista() {
		
		String sql = "select t2.name nimi, COUNT(winner_id) AS lkm from ottelut t1 join pelaajat t2 on t2.id = winner_id GROUP BY winner_id order BY lkm desc";
		RowMapper<Piste> mapper = new PisteRowMapper();
		List<Piste> pisteet = jdbcTemplate.query(sql, mapper);
		
		return pisteet;
	}

}







