package fi.antti.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.antti.spring.bean.Ottelu;
import fi.antti.spring.bean.Pelaaja;

public class OttelutRowMapper implements RowMapper<Ottelu> {

	public Ottelu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ottelu t = new Ottelu();
		Pelaaja p1 = new Pelaaja();
		Pelaaja p2 = new Pelaaja();
		Pelaaja voittaja = new Pelaaja();
		
		t.setMatch_id(rs.getInt("match_id"));
		t.setPlayer_1_id(rs.getInt("player_1_id"));
		t.setPlayer_2_id(rs.getInt("id"));
		t.setWinner_id(rs.getInt("winner_id"));
		t.setMatch_date(rs.getString("match_date"));
		t.setResult(rs.getString("result"));
		p1.setId(rs.getInt("player_1_id"));
		p1.setName(rs.getString("t2.name"));
		p2.setId(rs.getInt("id"));
		p2.setName(rs.getString("t3.name"));		
		voittaja.setId(rs.getInt("winner_id"));
		voittaja.setName(rs.getString("t4.name"));
		t.setVoittaja(voittaja);
		t.setPelaaja_1(p1);
		t.setPelaaja_2(p2);
	
		return t;
	}
}
