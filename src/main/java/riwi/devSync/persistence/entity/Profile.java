package riwi.devSync.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private User userId;
    private String nickname;
    private String location;
    private String portfolio;
    private String bio;
}
