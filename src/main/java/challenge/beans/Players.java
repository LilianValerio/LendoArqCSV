package challenge.beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Players {
	
	private String id;
	private String name;
	private String full_name;
	private String nationality;
	private String club;
	private BigDecimal eur_release_clause;
	private Double eur_wage;
	private LocalDate birth_date;
	private Integer age;
	
	
	public Players(String id, String name, String full_name, String nationality, String club,
			BigDecimal eur_release_clause, Double eur_wage, LocalDate birth_date, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.full_name = full_name;
		this.nationality = nationality;
		this.club = club;
		this.eur_release_clause = eur_release_clause;
		this.eur_wage = eur_wage;
		this.birth_date = birth_date;
		this.age = age;
	}


	public Players(String col) {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFull_name() {
		return full_name;
	}


	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getClub() {
		return club;
	}


	public void setClub(String club) {
		this.club = club;
	}


	public BigDecimal getEur_release_clause() {
		return eur_release_clause;
	}


	public void setEur_release_clause(BigDecimal eur_release_clause) {
		this.eur_release_clause = eur_release_clause;
	}


	public Double getEur_wage() {
		return eur_wage;
	}


	public void setEur_wage(Double eur_wage) {
		this.eur_wage = eur_wage;
	}


	public LocalDate getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", full_name=" + full_name + ", nationality=" + nationality
				+ ", club=" + club + ", eur_release_clause=" + eur_release_clause + ", eur_wage=" + eur_wage
				+ ", birth_date=" + birth_date + ", age=" + age + "]";
	}
	
	
	
}
