package com.mgl.jpa.mapping.samples;

import java.util.List;

import javax.annotation.Nonnegative;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mgl.jpa.mapping.samples.support.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(indexes = {
    @Index(name = "document__title_idx", columnList = "title")
})
@Audited
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class Document extends BaseEntity {

    private static final int TITLE_MIN_LEN = 0;
    private static final int TITLE_MAX_LEN = 128;

    @NotNull @NotBlank @Size(min = TITLE_MIN_LEN, max = TITLE_MAX_LEN)
    @Column(nullable = false, length = TITLE_MAX_LEN)
    private String title;

    @Nonnegative
    @Column(nullable = false) @ColumnDefault("0")
    private int pagesCnt;

    @ManyToMany
    @NotAudited
    private List<RegularUser> authors;

}
