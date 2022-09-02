package com.example.hellospring;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.JpaMemberRepository;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


@Configuration
public class SpringConfig {

     private EntityManager em;

     @Autowired
    public SpringConfig(EntityManager em) {
         this.em = em;
     }

     @Bean
    public MemberService memberService() {
         return new MemberService(memberRepository());
     }

     @Bean
    public MemberRepository memberRepository() {
         return new JpaMemberRepository(em);
     }

//자바 코드로 의존성 주입
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
