package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    //http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map->{
            sb.append(map.getKey()+" : " + map.getValue()+"\n");
        });
        return sb.toString();
    }

    // Dto 객체를 활용한 put 매서드 구현
    //http:8080//localhost/api/v1/put-api/member1
    // 리턴값이 string
    @PutMapping(value = "/member1")
    public String PostMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    //http:8080//localhost:8080/api/v1/put-api/member2
    // return 값이 dto객체 타입
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    //http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
