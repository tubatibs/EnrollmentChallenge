package com.ntt.challenge.member.enrollment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/api/enrollment")
public class MemberController {
	
	@Autowired
	MemberService memService ;
	
	// Add a new enrollee
	@PostMapping("/addEnrollee/{MemberEntity}")
	public MemberEntity addEnrollee(MemberEntity enrollee) {
		return memService.addEnrollee(enrollee);
	}

	// Modify an existing enrollee
	@PostMapping("/modifyEnrolee/{MemberEntity}")
	public MemberEntity modifyEnrolee(MemberEntity enrollee) {
		return memService.modifyEnrolee(enrollee);
	}

	// Remove an enrollee entirely - soft delete to set activation status as FALSE
	@PostMapping("/removeEnroleeEntirely/{id}")
	public void removeEnroleeEntirely(long id) {
		memService.removeEnroleeEntirely(id);
	}

	// Add dependents to an enrollee
	@PostMapping("/addDependent/{MemberEntity}")
	public MemberEntity addDependent(MemberEntity dependent) {
		return memService.addDependent(dependent);
	}

	// Remove dependents from an enrollee
	@PostMapping("/removeDependent/{id}")
	public void removeDependent(Long memberId) {
		memService.removeDependent(memberId.intValue());
	}

	// Modify existing dependents
	@PostMapping("/modifyDependent/{MemberEntity}")
	MemberEntity modifyDependent(MemberEntity dependent) {
		return memService.modifyDependent(dependent);
	}

	@GetMapping("/")
	Iterable<MemberEntity> findAll() {
		return memService.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<MemberEntity> findById(Long id){
		return memService.findById(id);
	}
	
	// Supporting Methods
	@GetMapping("/{id}/{status}")
	List<MemberEntity> findAllEnrolleeAndDependents(@PathVariable long id, String status) {
		return memService.findAllEnrolleeAndDependents(id, status);
	}


}
