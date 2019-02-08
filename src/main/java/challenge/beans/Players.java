package challenge.beans;

public class Players {
	
	private String id;
	private String name;
	private String full_name;
	private String nationality;
	private String club;
	private String eur_release_clause;
	private String eur_wage;
	private String birth_date;
	private String age;
	
	
	
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
	
	public String getEur_release_clause() {
		return eur_release_clause;
	}
	public void setEur_release_clause(String eur_release_clause) {
		this.eur_release_clause = eur_release_clause;
	}
	public String getEur_wage() {
		return eur_wage;
	}
	public void setEur_wage(String eur_wage) {
		this.eur_wage = eur_wage;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", full_name=" + full_name + ", nationality=" + nationality
				+ ", club=" + club + ", eur_release_clause=" + eur_release_clause + ", eur_wage=" + eur_wage
				+ ", birth_date=" + birth_date + ", age=" + age + "]";
	}
	
	
	
}
