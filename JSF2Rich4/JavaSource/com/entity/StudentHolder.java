package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean (name="studentHolder")
@RequestScoped

public class StudentHolder {

	private List<Student> studentList;

	public List<Student> getStudent(Integer first, Integer last) {
		//System.out.println("in side stud");
		int size = getStudentList().size();
		if(last > size){
			last = size;
		}
		List<Student> subList = getStudentList().subList(first, last);
		//System.out.println("out side stud");
		return subList;
	}

	public List<Student> getStudentList() {
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();
		Student student6 = new Student();
		Student student7 = new Student();
		Student student8 = new Student();
		Student student9 = new Student();
		Student student10 = new Student();
		Student student11 = new Student();

		student1.setId(1);
		student1.setFirstName("Mohamed");
		student1.setLastName("Sheriff");

		student2.setId(2);
		student2.setFirstName("Mohamed");
		student2.setLastName("Sheriff");

		student3.setId(3);
		student3.setFirstName("Mohamed");
		student3.setLastName("Sheriff");

		student4.setId(4);
		student4.setFirstName("Mohamed");
		student4.setLastName("Sheriff");

		student5.setId(5);
		student5.setFirstName("Mohamed");
		student5.setLastName("Sheriff");

		student6.setId(6);
		student6.setFirstName("Mohamed");
		student6.setLastName("Sheriff");

		student7.setId(7);
		student7.setFirstName("Mohamed");
		student7.setLastName("Sheriff");

		student8.setId(8);
		student8.setFirstName("Mohamed");
		student8.setLastName("Sheriff");

		student9.setId(9);
		student9.setFirstName("Mohamed");
		student9.setLastName("Sheriff");

		student10.setId(10);
		student10.setFirstName("Mohamed");
		student10.setLastName("Sheriff");

		student11.setId(11);
		student11.setFirstName("Mohamed");
		student11.setLastName("Sheriff");
		
		studentList = new ArrayList<Student>();
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
		studentList.add(student6);
		studentList.add(student7);
		studentList.add(student8);
		studentList.add(student9);
		studentList.add(student10);
		studentList.add(student11);
		return studentList;
	}

}
