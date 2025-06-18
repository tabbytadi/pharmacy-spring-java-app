-- Medicines
INSERT INTO medicine ( name, age_appropriateness, needs_recipe) VALUES ('Paracetamol', 0, false);
INSERT INTO medicine (name, age_appropriateness, needs_recipe) VALUES ('Ibuprofen', 6, false);
INSERT INTO medicine (name, age_appropriateness, needs_recipe) VALUES ('Aspirin', 12, true);
INSERT INTO medicine (name, age_appropriateness, needs_recipe) VALUES ('Cough Syrup', 2, false);
INSERT INTO medicine (name, age_appropriateness, needs_recipe) VALUES ('Antibiotic X', 0, true);

-- Doctors
INSERT INTO `pharmacy-adi`.`doctor` (`name`) VALUES ('Petrov');
INSERT INTO `pharmacy-adi`.`doctor` (`name`) VALUES ('Stankova');
INSERT INTO `pharmacy-adi`.`doctor` (`name`) VALUES ('Petrova');

-- Recipes
INSERT INTO `pharmacy-adi`.`recipe` (`creation_date`, `doctor_id`) VALUES ('2024-06-01', 1);
INSERT INTO `pharmacy-adi`.`recipe` (`creation_date`, `doctor_id`) VALUES ('2024-06-02', 2);
INSERT INTO `pharmacy-adi`.`recipe` (`creation_date`, `doctor_id`) VALUES ('2024-06-03', 3);