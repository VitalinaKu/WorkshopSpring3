INSERT INTO course (id, name, number_of_years, university, course_type) VALUES
                                                                         (7, 'Informatyka', 4, 'SGH', 'INZYNIER'),
                                                                         (8, 'Filologia', 3, 'Vistula', 'LICENCJAT'),
                                                                         (9, 'Matematyka', 5, 'Griffindor', 'MAGISTER');

INSERT INTO student (id, name, lastname, birthdate, gender, course_id) VALUES
                                                                           (10, 'Jan', 'Kowalski', '1993-12-14', 'MALE', 7),
                                                                           (11, 'Melissa', 'Pertanko', '1999-12-13', 'FEMALE', 8),
                                                                           (12, 'Andrew', 'Mariko', '1998-02-10', 'MALE', 9);