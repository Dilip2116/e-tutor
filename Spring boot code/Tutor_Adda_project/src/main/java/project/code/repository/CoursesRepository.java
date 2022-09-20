package project.code.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import project.code.entity.Courses;


@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
	
	@Query(value="select count(course_id) from courses;",nativeQuery=true)
	public int coursecount();
	
	@Query(value="select * from courses where course_teacher_id=:tid and :date between course_start_date and course_end_date;",nativeQuery=true)
	public List<Courses> coursebydate(@PathVariable("date") String date ,@PathVariable("tid") int tid);

	
}

