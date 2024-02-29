INSERT INTO Address (id, town, street, house_number) VALUES
    (NEXT value FOR address_seq, 'Cityville', 'Main Street', '123'),
    (NEXT value FOR address_seq, 'Townsville', 'Broadway', '456'),
    (NEXT value FOR address_seq, 'Villageton', 'Oak Avenue', '789'),
    (NEXT value FOR address_seq, 'Hamletown', 'Maple Lane', '101'),
    (NEXT value FOR address_seq, 'Suburbia', 'Pine Road', '202');
--    (NEXT value FOR address_seq, 'Metropolis', 'Superhero Avenue', '789'),
--    (NEXT value FOR address_seq, 'Harbor City', 'Ocean Drive', '456'),
--    (NEXT value FOR address_seq, 'Mountainview', 'Summit Street', '101'),
--    (NEXT value FOR address_seq, 'Greenfield', 'Meadow Lane', '303'),
--    (NEXT value FOR address_seq, 'Riverside', 'River Road', '505');

INSERT INTO Contact (id, email, phone_number) VALUES
    (NEXT value FOR contact_seq, 'john.doe@example.com', '1234567890'),
    (NEXT value FOR contact_seq, 'jane.smith@example.com', '9876543210'),
    (NEXT value FOR contact_seq, 'bob.jones@example.com', '5551112233'),
    (NEXT value FOR contact_seq, 'alice.wonder@example.com', '8884445678'),
    (NEXT value FOR contact_seq, 'charlie.chaplin@example.com', '7773339999');
--    (NEXT value FOR contact_seq, 'samuel.jackson@example.com', '1112223333', 6),
--    (NEXT value FOR contact_seq, 'emily.white@example.com', '4445556666', 7),
--    (NEXT value FOR contact_seq, 'oliver.johnson@example.com', '7778889999', 8),
--    (NEXT value FOR contact_seq, 'sophia.brown@example.com', '1234567890', 9),
--    (NEXT value FOR contact_seq, 'noah.miller@example.com', '9876543210', 10);

INSERT INTO address_contacts (contacts_id, address_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

INSERT INTO Person (id, full_name, permanent_address_id, temporary_address_id) VALUES
    (NEXT value FOR person_seq, 'John Doe', 1, 2),
    (NEXT value FOR person_seq, 'Jane Smith', 2, 1),
    (NEXT value FOR person_seq, 'Bob Jones', 3, 4),
    (NEXT value FOR person_seq, 'Alice Wonder', 4, 3),
    (NEXT value FOR person_seq, 'Charlie Chaplin', 5, 1),
    (NEXT value FOR person_seq, 'Mary Smith', NULL, NULL);
