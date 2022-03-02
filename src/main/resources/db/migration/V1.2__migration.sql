/*CREATE NEW USERS*/
INSERT INTO app_user(dob, created_at, credentials_expired,
                     currency, email, enabled, expired, locked,
                     name, password, phone_number,
                     role, surname, username, nationality_id)
VALUES (DATE '1999-07-23', NOW(), false, 'MKD', 'admin@email.com', true, false, false, 'Admin', '$2a$12$uuMhxrRHyMSfPZ2A0gpV2.VBB0mHFWdaMRnAQgjBIGmYcO7yD4IW6','+389/71500500', 'ADMIN', 'User', 'admin', 141);

INSERT INTO app_user(dob, created_at, credentials_expired,
                     currency, email, enabled, expired, locked,
                     name, password, phone_number,
                     role, surname, username, nationality_id)
VALUES (DATE '2000-02-22', NOW(), false, 'MKD', 'testuser1@email.com', true, false, false, 'Test', '$2a$12$b5AZ3.QYhcMAJnV.iysBMuFf3Bdjnjqh0o1eB8LbvtQPbd5Ys5TN.','+389/72445467', 'USER', 'User1', 'testuser1', 141);

INSERT INTO app_user(dob, created_at, credentials_expired,
                     currency, email, enabled, expired, locked,
                     name, password, phone_number,
                     role, surname, username, nationality_id)
VALUES (DATE '1996-04-15', NOW(), false, 'MKD', 'testuser2@email.com', true, false, false, 'Test', '$2a$12$b5AZ3.QYhcMAJnV.iysBMuFf3Bdjnjqh0o1eB8LbvtQPbd5Ys5TN.','+389/78678679', 'USER', 'User2', 'testuser2', 141);

INSERT INTO app_user(dob, created_at, credentials_expired,
                     currency, email, enabled, expired, locked,
                     name, password, phone_number,
                     role, surname, username, nationality_id)
VALUES (DATE '1998-03-10', NOW(), false, 'MKD', 'testuser3@email.com', true, false, false, 'Test', '$2a$12$b5AZ3.QYhcMAJnV.iysBMuFf3Bdjnjqh0o1eB8LbvtQPbd5Ys5TN.','+389/75345345', 'USER', 'User3', 'testuser3', 141);

INSERT INTO app_user(dob, created_at, credentials_expired,
                     currency, email, enabled, expired, locked,
                     name, password, phone_number,
                     role, surname, username, nationality_id)
VALUES (DATE '1988-05-14', NOW(), false, 'MKD', 'partner@email.com', true, false, false, 'Partner', '$2a$12$yFllYV5CfwPHCou.cmfOJOWk61Fc6cCHFkhAEsW29DYOzzM7ps.hS','+389/72567890', 'PARTNER', 'User1', 'partner', 141);


/*CREATE ACCOMMODATIONS*/
INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (5, 42.0015528, 21.4364046, 'Located in the historic nucleus of the Old Bazaar of Skopje, Hotel Arka offers modern accommodations with a panoramic bar and a rooftop terrace available at any hour for a drink. All rooms have free WiFi, flat screen TV, free toiletries and comes with a hairdryer and slippers. Free private parking is available on-site. Guests are offered complementary use of the sauna and the fitness room.The reception desk is open 24 hours a day. Rich breakfast is served daily on the 7th floor. Hotel Arka is located in the Old Bazaar and is set a 10 minutes walking distance to the Central Square. In the same area you can enjoy various entertainment and dining options. Skopje Airport can be found within a 25-minute drive. This is our guests'' favorite part of Skopje, according to independent reviews.', 'Bitpazarska 90/2, 1000 Skopje, North Macedonia', false, 'Hotel Arka', 5, 8.3, 1, 1);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (2, 42.0019239, 21.4112377, 'Set in the heart of Skopje, Moodeight Apartments is 0.9 mi from the city center, while Macedonia Square is 1 mi away. Free WiFi is available throughout the property. The apartments feature a seating area with a TV and a private balcony. Guests can make their own meals in the fully equipped kitchen fitted with oven and fridge. A dining table is also available. The bathroom comes with a toilet and a washing/drying machine. Towels and bad linen are featured. Weekly housekeeping is provided. Traditional restaurants can be found near the property. Guests can use bicycles from the property free of charge. Kale fortress and Stone bridge are 0.9 mi away, and the city park is 500 m away from the property.', 'ul. Franklin Ruzvelt 51A-8, 1000 Skopje', true, 'Moodeight apartment', 4, 9.3, 1, 4);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (1, 41.9865711, 21.452992, 'Offering free WiFi and free private parking, Unity Luxury Apartment - Skopje is located in Skopje, within just 1.9 km of Stone Bridge. The air-conditioned property is 1.9 km from Macedonia Square. The apartment is fitted with 1 bedroom, 1 bathroom, bed linen, towels, a flat-screen TV with satellite channels, a dining area, a fully equipped kitchen, and a balcony with city views. The apartment has a terrace.', 'Metodija Shatorov-Sharlo 29/3-4, 1000 Skopje', true, 'Unity Luxury Apartment', 3, 9.1, 1, 4);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (6, 41.990328, 4710545, 'Located along the river Vardar, DoubleTree by Hilton Skopje offers 5-star accommodations within a 10 minute drive of the city center, featuring luxuriously furnished rooms and suites, large indoor swimming pool with fitness and spa and an elegant roof bar with a relaxing view. The contemporary designed rooms and suites are fitted with stylish designed furniture, air conditioning, Smart TV’s starting from 43’, kettle in every room, laundry service and complimentary WIFI. Deluxe Rooms include espresso machine and floor-to-ceiling windows, while suites offer a kitchenette. Each suite is fitted with either a bathtub or walk-in shower, while some feature both.', '17 ASNOM blvd., 1000 Skopje, North Macedonia', false, 'DoubleTree by Hilton', 5, 9.2, 1, 1);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (7, 42.006279, 21.424777, 'Set in Skopje, 0.6 mi away from Skopje city center, Park Hotel & Spa is surrounded by the greenery of the City Park and features a sun terrace by the river Vardar, a spa center spa and a fitness center with professional equipment. An on-site restaurant and a bar are available for the guests. Rooms come with a flat-screen TV with satellite channels. Some units include a seating area where you can relax. You will find a coffee machine in the room. Rooms are fitted with a private bathroom. For your comfort, you will find bath robes and slippers. Park Hotel & Spa features free WiFi throughout the property. At Park Hotel free WiFi is available, as well as free private parking. Bicycle rental is also possible on site and shuttle services can be arranged upon request and at a surcharge. Kale Fortress is a 5-minute drive away from Park Hotel & Spa, while Macedonia Square is a 20-minute walk away. The nearest airport is Skopje Alexander the Great International Airport, 16 mi from the property.', '1732 Str. no. 4, 1000 Skopje, North Macedonia', false, 'Park Hotel & Spa', 5, 8.7, 1, 1);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (2, 41.1134039, 20.7995684, 'Aurelia Apartment offers accommodations in the center of Ohrid, offering views of the lake. Free WiFi is available and free free public parking is possible on site. A balcony and a flat-screen TV are featured. A working desk with a computer is also available. An oven and a toaster, coffee maker and kettle can be found in the kitchen. Aurelia Apartment is a 1-minute walk away from the shopping street and the lake port Ancient Theater of Ohrid is 601 m from Aurelia Apartment, while Samoil''s Fortress is 801 m away. Ohrid Airport is 5.6 mi from the property. Baby coat on request.', '4 Partizanska Str. apt. 18, 6000 Ohrid', true, 'Aurelia Apartment', 3, 8.5, 6, 4);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (4, 41.110813, 20.8045175, 'This property is a 12-minute walk from the beach. Located in Ohrid, within an 8-minute walk of Port Ohrid and 1 km of Saraiste Beach, Villa Darki has accommodations with a terrace and free WiFi as well as free private parking for guests who drive. Popular points of interest nearby include Church of St. John at Kaneo, Labino Beach and Museum Robev House. The guesthouse has family rooms. All rooms at the guesthouse come with air conditioning, a seating area, a flat-screen TV with cable channels, a safety deposit box and a private bathroom with a shower, slippers and a hairdryer. The rooms include an electric tea pot, while selected rooms also feature a kitchen with a dishwasher and a fridge. At Villa Darki the rooms come with bed linen and towels. Popular points of interest near the accommodation include Cuba Libre Beach, Potpesh Beach and Early Christian Basilica.','18 Jane Sandanski, 6000 Ohrid, North Macedonia', false, 'Villa Darki', 4, 9.6, 6, 5);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (3, 41.0398187, 20.8028675, 'Featuring garden views, Villa Kalina provides accommodations with a garden, barbecue facilities and a terrace, around 3.7 km from Orevche Beach. This beachfront property has a balcony, free private parking and free WiFi. The villa is fitted with 3 bedrooms, 2 bathrooms, bed linen, towels, a flat-screen TV with cable channels, a dining area, a fully equipped kitchen, and a patio with lake views. The villa also has a seating area, washing machine and a bathroom with a bidet and a shower. The villa has a playground. A car rental service is available at Villa Kalina.', 'Elesec, 6000 Ohrid, North Macedonia', false, 'Villa Kalina', 3, 9.7, 6, 5);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (6, 41.0845714, 20.7950216, 'This property is 1 minute walk from the beach. Inex Olgica Hotel & SPA is located on the shore of the Ohrid Lake, 2.5 mi away from Ohrid and a 10-minute drive from Ohrid Airport. Guests benefit from the free WiFi and free parking on site. Available are free access to swimming pool and spa facilities as sauna and steam bath. Massages are provided at a surcharge. Each room comes with air conditioning, a TV with cable channels and a mini-bar. The private bathroom consists of a shower and a bath. A hairdryer and free toiletries are provided as well. Some rooms offer lake views. Inex Olgica Hotel & SPA has an aperitif hall and an on-site restaurant which serves various national specialties. A terrace is at guests'' disposal. Further dining alternatives, grocery shops and entertainment options can be found in Ohrid''s center,  a 5-minute drive away from the property.', '7 Naum Ohridski str., 6000 Ohrid, North Macedonia', false, 'Inex Olgica Hotel & Spa', 5, 8.6, 6, 1);

INSERT INTO accommodation(no_of_rooms, x, y, about, address, entire_accommodation, name, star_rating, user_rating, city_id, type_id)
VALUES (6, 41.0788831, 20.8001461, 'This property is 2 minutes walk from the beach. Hotel Belvedere is a comfortable hotel well-suited for both business and pleasure, 4 km from the center of Ohrid, with a unique atmosphere and friendly room service. Unwind in your air conditioned, spacious and elegantly decorated accommodation. The property is surrounded by magnificent pine woods in the St.Stephan settlement, 101 m from the shore of Lake Ohrid. There is a restaurant serving international and local cuisine with 300 seats, an aperitif bar, seminar rooms with flexible arrangements and an antiques shop.', 'St .Stephan Settlement B.B, 6000 Ohrid, North Macedonia', false, 'Hotel Belvedere', 4, 8.7, 6, 1);