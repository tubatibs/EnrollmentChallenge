package com.ntt.challenge.member.enrollment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public abstract class MemberService {

	@Autowired
	MemberRepository memRepo;

	// Add a new enrollee
	MemberEntity addEnrollee(MemberEntity enrollee) {
		return memRepo.save(enrollee);
	}

	// Modify an existing enrollee
	MemberEntity modifyEnrolee(MemberEntity enrollee) {
		return memRepo.save(enrollee);
	}

	// Remove an enrollee entirely
	void removeEnroleeEntirely(long id) {
		memRepo.deleteById(id);
	}

	// Add dependents to an enrollee
	MemberEntity addDependent(MemberEntity dependent) {
		return memRepo.save(dependent);
	}

	// Remove dependents from an enrollee
	void removeDependent(int memberId) {
		memRepo.deleteById(new Long(memberId));
	}

	// Modify existing dependents
	MemberEntity modifyDependent(MemberEntity dependent) {
		return memRepo.save(dependent);
	}

	// Supporting Methods
	Optional<MemberEntity> findMember(MemberEntity dependent) {
		return memRepo.findById(new Long(dependent.getId()));
	}

}
