package pl.wsb.fitnesstracker.workoutsession;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.training.api.Training;

// TODO: Define the Event entity with appropriate fields and annotations
@Entity
@Table(name = "workoutSession")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", nullable = false)
    private Training trainingId;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    @Column(name = "startLatitude", nullable = false)
    private double startLatitude;

    @Column(name = "startLongitude", nullable = false)
    private double startLongitude;

    @Column(name = "endLatitude", nullable = false)
    private double endLatitude;

    @Column(name = "endLongitude", nullable = false)
    private double endLongitude;

    @Column(name = "altitude", nullable = false)
    private double altitude;
}
