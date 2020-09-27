package com.ntt.challenge.member.enrollment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes=EnrollmentApplication.class)
@ComponentScan
class EnrollmentApplicationTests {

	
	@Autowired
	MemberRepository memRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testFindAllMembers() {

		Iterable<MemberEntity> enrolleesRes = memRepo.findAll();
		//assertNotNull(enrolleeRes);
		System.out.println(enrolleesRes);
		assertNotNull(enrolleesRes);
	}
	@Test
	public void testAddEnrollee() {
		MemberEntity enrolleeReq = new MemberEntity();
		enrolleeReq.setName("SPRING TEST");
		enrolleeReq.setActivationStatus(true);
		enrolleeReq.setDateOfBirth(new Date(System.currentTimeMillis()));
		enrolleeReq.setEId(0);
		enrolleeReq.setType("ENROLLEE");
		enrolleeReq.setPhone("000-000-0000");
		MemberEntity enrolleeRes = memRepo.save(enrolleeReq);
		//assertNotNull(enrolleeRes);
		System.out.println(enrolleeRes);
		assertNotNull(enrolleeRes);
	}
	@Test
	public void testFindAllMembersAfterAddEnrollee() {

		Iterable<MemberEntity> enrolleesRes = memRepo.findAll();
		//assertNotNull(enrolleeRes);
		System.out.println(enrolleesRes);
		assertNotNull(enrolleesRes);
	}
	/*@Test
	public void testFindAllMembersAfterAddEnrollee() {

		Iterable<MemberEntity> enrolleesRes = memRepo.findAll();
		//assertNotNull(enrolleeRes);
		System.out.println(enrolleesRes);
		assertNotNull(enrolleesRes);
	}*/
	
	
}
