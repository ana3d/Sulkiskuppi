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

import fi.antti.spring.bean.Ottelu;

@Repository
public class OttelutDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Tallettaa parametrina annetun henkilön tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Ottelu o) {
		final String sql = "insert into ottelut(player_1_id, player_2_id, winner_id, match_date, result) values(?,?,?,?,?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen
		// päättyessä.
		final int player_1_id = o.getPlayer_1_id();
		final int player_2_id = o.getPlayer_2_id();
		final int winner_id = o.getWinner_id();
		final String match_date = o.getMatch_date();
		final String result = o.getResult();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä
		// PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "match_id" });
				ps.setInt(1, player_1_id);
				ps.setInt(2, player_2_id);
				ps.setInt(3, winner_id);
				ps.setString(4, match_date);
				ps.setString(5, result);

				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		o.setMatch_id(idHolder.getKey().intValue());

	}

	public Ottelu etsi(int id) throws Exception {
		String sql = "select * from ottelut where match_id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Ottelu> mapper = new OttelutRowMapper();

		Ottelu p;
		try {
			p = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new Exception(e);
		}
		return p;

	}

	public List<Ottelu> haeKaikki() {

		String sql = "select distinct match_id, player_1_id, t2.name , t3.id , t3.name , winner_id, t4.name , result, match_date    from ottelut t1   join pelaajat t2     on t1.player_1_id = t2.id   join pelaajat t3     on t1.player_2_id = t3.id   join pelaajat t4     on t4.id = winner_id order BY match_id";

		RowMapper<Ottelu> mapper = new OttelutRowMapper();
		List<Ottelu> ottelut = jdbcTemplate.query(sql, mapper);

		return ottelut;
	}
	

	

}
