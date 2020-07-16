package com.example.Kabbage;

import com.example.Kabbage.repositories.BodyRepository;
import com.example.Kabbage.repositories.ExerciseRepository;
import com.example.Kabbage.repositories.MuscleRepository;
import com.example.Kabbage.repositories.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Kabbage.models.Body;
import com.example.Kabbage.models.Exercise;
import com.example.Kabbage.models.Muscle;
import com.example.Kabbage.models.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KabbageApplication {

	public static void main(final String[] args) {
		SpringApplication.run(KabbageApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, BodyRepository bodyRepository,
			ExerciseRepository exerciseRepository, MuscleRepository muscleRepository) {
		return (args) -> {
			final List<Muscle> muscles = Arrays.asList("bicep", "pectoral", "tricep").stream()
					.map(muscleName -> Muscle.builder().name(muscleName).build())
					.map(muscle -> muscleRepository.save(muscle)) // gives Ids
					.collect(Collectors.toList());

			final Body standardBody = bodyRepository.save(Body.builder().muscles(muscles).build());

			final User martin = User.builder().name("Martin Perry").userName("dislexicmofo").body(standardBody).build();
			userRepository.save(martin);

			var bicepCurl = exerciseRepository
					.save(Exercise.builder().name("bicep curl")
							.primaryMuscles(Collections.singletonList(
									muscles.stream().filter(muscle -> "bicep".equals(muscle.name)).findFirst().get()))
							.build());
			var benchPress = exerciseRepository.save(Exercise.builder().name("bench press")
					.primaryMuscles(Collections.singletonList(
							muscles.stream().filter(muscle -> "pectoral".equals(muscle.name)).findFirst().get()))
					.build());
			var tricepExtension = exerciseRepository.save(Exercise.builder().name("tricep extension")
					.primaryMuscles(Collections.singletonList(
							muscles.stream().filter(muscle -> "tricep".equals(muscle.name)).findFirst().get()))
					.build());
			var tricepPullDown = exerciseRepository.save(Exercise.builder().name("tricep pull down")
					.primaryMuscles(Collections.singletonList(
							muscles.stream().filter(muscle -> "tricep".equals(muscle.name)).findFirst().get()))
					.build());
		};
	}
}
