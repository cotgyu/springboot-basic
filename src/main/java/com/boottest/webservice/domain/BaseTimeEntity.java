package com.boottest.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //Entity클래스가 BaseTimeEntity 클래스를 상속할 경우 createDate와 ModifiedDate를 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //JPA에선 auditing이 생성시간, 수정시간 관련인듯? (JPA entity listener to capture auditing information on persiting and updating entities.)
public class BaseTimeEntity {
    @CreatedDate //Entity가 생성되어 저장될 때 자동으로 시간 저장
    private LocalDateTime created_Date;

    @LastModifiedDate //Entity의 값을 변형할 때 자동으로 시간 저장
    private LocalDateTime modified_Date;
}
