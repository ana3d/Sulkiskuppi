package fi.antti.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.antti.spring.bean.Pelaaja;

@Repository
public class PelaajaDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	/**
	 * Tallettaa parametrina annetun henkilön tietokantaan.
	 * Tietokannan generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Pelaaja p) {
		final String sql = "insert into pelaajat(name) values(?)";
		
		//anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		//jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä. 
		final String name = p.getName();
		//jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
	    	            ps.setString(1, name);
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		//tallennetaan id takaisin beaniin, koska
		//kutsujalla pitäisi olla viittaus samaiseen olioon
	    p.setId(idHolder.getKey().intValue());

	}
	

	public Pelaaja etsi(int id) throws Exception {
		String sql = "select * from pelaajat where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Pelaaja> mapper = new PelaajaRowMapper();
		
		Pelaaja p;
	    try { 
	    p = jdbcTemplate.queryForObject(sql , parametrit, mapper);
	    } catch(IncorrectResultSizeDataAccessException e) {
	    	throw new Exception(e);
	    }
	    return p;
	                                  

	}
	

	public List<Pelaaja> haeKaikki() {
		
		String sql = "select * from pelaajat";
		RowMapper<Pelaaja> mapper = new PelaajaRowMapper();
		List<Pelaaja> tunnit = jdbcTemplate.query(sql,mapper);

		return tunnit;
	}

}
