package com.mgl.jpa.mapping.samples.support;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@MappedSuperclass
@Getter @Setter(AccessLevel.PROTECTED) @EqualsAndHashCode(of = "id") @ToString @NoArgsConstructor
public class BaseEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version @Column(nullable = false) @ColumnDefault("0")
    private Long version;

}
