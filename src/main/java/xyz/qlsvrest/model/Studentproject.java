package xyz.qlsvrest.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import xyz.qlsvrest.dto.StudentprojectDto;

@Entity
public class Studentproject {
	@Id
	//tai sao phai dung auto
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Float mark;
	private Date startDate;
	private Date endDate;
	
	/* */
	@ManyToOne
	private Project project;
	
//	@ManyToMany(mappedBy = "studentproject")
//	private List<Ssp> ssps;
	
//	@ManyToMany(mappedBy = "studentproject")
//	private List<Student> students;
	
	@OneToMany(mappedBy = "studentproject")
	private List<Student> students;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public static Studentproject from(StudentprojectDto studentprojectDto) {
		Studentproject studentproject =  new Studentproject();
		studentproject.setEndDate(studentprojectDto.getEndDate());
		studentproject.setId(studentprojectDto.getId());
		studentproject.setMark(studentprojectDto.getMark());
		
		if(studentprojectDto.getProjectId()!=null) {
			Project project = new Project();
			project.setId(studentprojectDto.getProjectId());
			studentproject.setProject(project);
		}
		return studentproject;
	}

}
