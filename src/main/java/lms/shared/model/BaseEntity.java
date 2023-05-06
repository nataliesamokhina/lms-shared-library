package lms.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class BaseEntity<ID> {
    @Id
    @GenericGenerator(
            name = "UseExistingIdOtherwiseGenerateUsingIdentity",
            strategy = "lms.shared.util.UseExistingIdOtherwiseGenerateUsingIdentity")
    @GeneratedValue(generator = "UseExistingIdOtherwiseGenerateUsingIdentity")
    protected ID id;

    @Column(nullable = false, columnDefinition = "boolean default false")
    protected boolean deleted = false;
}
