package com.ntt.challenge.member.enrollment;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableAutoConfiguration
@Repository
public interface MemberRepository extends CrudRepository<MemberEntity, Long> {

}
