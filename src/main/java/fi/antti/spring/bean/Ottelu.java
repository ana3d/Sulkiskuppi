package fi.antti.spring.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Ottelu {

	private int match_id;
	private int player_1_id;
	private int player_2_id;
	private int winner_id;

	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
	private String match_date;

	@Pattern(regexp = "\\d{1}-\\d{1}")
	private String result;
	
	
	@Min(0)
	@Max(20)
	private int player_1_score;
	
	@Min(0)
	@Max(20)
	private int player_2_score;

	private Pelaaja pelaaja_1;
	private Pelaaja pelaaja_2;
	private Pelaaja voittaja;

	public Ottelu(int match_id, int player_1_id, int player_2_id,
			int winner_id, String match_date, String result,
			int player_1_score, int player_2_score, Pelaaja pelaaja_1,
			Pelaaja pelaaja_2, Pelaaja voittaja) {
		super();
		this.match_id = match_id;
		this.player_1_id = player_1_id;
		this.player_2_id = player_2_id;
		this.winner_id = winner_id;
		this.match_date = match_date;
		this.result = result;
		this.player_1_score = player_1_score;
		this.player_2_score = player_2_score;
		this.pelaaja_1 = pelaaja_1;
		this.pelaaja_2 = pelaaja_2;
		this.voittaja = voittaja;
	}

	public Ottelu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public int getPlayer_1_id() {
		return player_1_id;
	}

	public void setPlayer_1_id(int player_1_id) {
		this.player_1_id = player_1_id;
	}

	public int getPlayer_2_id() {
		return player_2_id;
	}

	public void setPlayer_2_id(int player_2_id) {
		this.player_2_id = player_2_id;
	}

	public int getWinner_id() {
		return winner_id;
	}

	public void setWinner_id(int winner_id) {
		this.winner_id = winner_id;
	}

	public String getMatch_date() {
		return match_date;
	}

	public void setMatch_date(String match_date) {
		this.match_date = match_date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getPlayer_1_score() {
		return player_1_score;
	}

	public void setPlayer_1_score(int player_1_score) {
		this.player_1_score = player_1_score;
	}

	public int getPlayer_2_score() {
		return player_2_score;
	}

	public void setPlayer_2_score(int player_2_score) {
		this.player_2_score = player_2_score;
	}

	public Pelaaja getPelaaja_1() {
		return pelaaja_1;
	}

	public void setPelaaja_1(Pelaaja pelaaja_1) {
		this.pelaaja_1 = pelaaja_1;
	}

	public Pelaaja getPelaaja_2() {
		return pelaaja_2;
	}

	public void setPelaaja_2(Pelaaja pelaaja_2) {
		this.pelaaja_2 = pelaaja_2;
	}

	public Pelaaja getVoittaja() {
		return voittaja;
	}

	public void setVoittaja(Pelaaja voittaja) {
		this.voittaja = voittaja;
	}

	@Override
	public String toString() {
		return "Ottelu [match_id=" + match_id + ", player_1_id=" + player_1_id
				+ ", player_2_id=" + player_2_id + ", winner_id=" + winner_id
				+ ", match_date=" + match_date + ", result=" + result
				+ ", player_1_score=" + player_1_score + ", player_2_score="
				+ player_2_score + ", pelaaja_1=" + pelaaja_1 + ", pelaaja_2="
				+ pelaaja_2 + ", voittaja=" + voittaja + "]";
	}

}
