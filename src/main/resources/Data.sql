INSERT INTO course (id, name, number_of_hours, university, course_type) VALUES
                                                                         (1, 'Informatyka', 4, 'SGH', 'INZYNIER'),
                                                                         (2, 'Filologia', 3, 'Vistula', 'LICENCJAT'),
                                                                         (3, 'Matematyka', 5, 'Griffindor', 'MAGISTER');

INSERT INTO student (id, name, lastname, birthdate, gender, course_id) VALUES
                                                                           (1, 'Jan', 'Kowalski', '1993-12-14', 'MALE', 2),
                                                                           (2, 'Melissa', 'Pertanko', '1999-12-13', 'FEMALE', 3),
                                                                           (3, 'Andrew', 'Mariko', '1998-02-10', 'MALE', 1);