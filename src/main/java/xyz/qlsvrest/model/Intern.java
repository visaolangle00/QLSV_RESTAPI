package xyz.qlsvrest.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import xyz.qlsvrest.dto.InternDto;

@Entity
public class Intern {
	
	@Id
	//tai sao phai dung auto
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private Teacher teacher;
	
	@OneToMany(mappedBy = "intern")
	private List<Student> students;
	
	private Float mark;
	private Date startDate;
	private Date endDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Float getMark() {
		return mark;
	}
	public void setMark(Float mark) {
		this.mark = mark;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public static Intern from(InternDto internDto) {
		Intern intern = new  Intern();
		//intern.setCompany(internDto.getCompanyId());
		if(internDto.getCompanyId()!=null) {
			Company company = new Company();
			company.setId(internDto.getCompanyId());
			intern.setCompany(company);
		}
		
		intern.setEndDate(internDto.getEndDate());
		intern.setId(internDto.getId());
		intern.setMark(internDto.getMark());
		intern.setStartDate(internDto.getStartDate());
		
		
		//intern.setTeacher(internDto.getTeacherId());
		
		if(internDto.getTeacherId()!=null) {
			Teacher teacher = new Teacher();
			teacher.setId(internDto.getCompanyId());
			intern.setTeacher(teacher);
		}
		
		
		return intern;
	}
	
	
	
	
}
