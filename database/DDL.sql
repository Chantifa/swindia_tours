--
DROP TABLE IF EXISTS bookings;
CREATE TABLE IF NOT EXISTS bookings (
  b_id SERIAL  NOT NULL  PRIMARY KEY ,
  t_id int NOT NULL,
  u_id int NOT NULL,
  b_quantity int NOT NULL,
  b_date varchar(450) NOT NULL
) ;

INSERT INTO bookings VALUES (25,3,1,3,'2022-12-01'),(26,2,1,1,'2022-12-03');

DROP TABLE IF EXISTS tours;


CREATE TABLE tours (
  id SERIAL NOT NULL primary key ,
  name varchar(450) NOT NULL,
  description varchar(450) NOT NULL,
  price DOUBLE PRECISION NOT NULL,
  image varchar(450) NOT NULL
);

INSERT INTO tours  values (1,'Agra','An immense mausoleum of white marble, built in Agra between 1631 and 1648 by bookings of the Mughal emperor Shah Jahan in memory of his favourite wife, the Taj Mahal
                    is the jewel of Muslim art in India and one of the universally admired masterpieces of the worlds heritage. With driver from new Delhi to Agra with one over night at a 4 star hotel',250.00, 'agra.png' );

INSERT INTO tours  values (2,'Delhi','New Delhi a city of 18 mio people. Humayun Tomb, Red Fort, JamaMajid, Akshardham, Qutb Minaar, Lotus Temple, Rashtrapati Bhavan, India Gate, and many more, for 4 days at a  star hotel',  650,
                                                                   'delhi.png' );
INSERT INTO tours  values (3,'Amritsar','Amritsar historically also known as Rāmdāspur and colloquially as Ambarsar,
                    is a city in northwestern India which is the administrative headquarters of the Amritsar district and is located in the Majha region of the Indian state of Punjab. The city with the Golden Temple',  300.00,
                                                                   'golden_temple.png' );
INSERT INTO tours values (4,'airport drop and pick up','if you have any package tour booked with us, Airport pick up and drop is free',  30.00,
                                                                   'airportpickup_drop.png' );
INSERT INTO tours values (5,'Rajasthan','Jaipur, Udaipur, Pushkar, Jodhpur, Jaisalmer, Bikaner, two weeks inclusive driver and camel ridding in the desert, 4 star hotels',2000,
                                                                   'udaipur.png' );
INSERT INTO tours  values (6,'Rishikesh and Haridwar','Haridwar An important and religious city of Hindu at the Ganges river and Rishikesh World yoga and meditation center river rafting in Ganges river, with driver and 4 days at a 4 star hotel',
                                                                   350.00, 'Har-ki-Pauri,_Haridwar.png' );

--
-- Table structure for table users
--

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id SERIAL NOT NULL PRIMARY KEY ,
  name varchar(250) NOT NULL,
  email varchar(250) NOT NULL,
  password varchar(250) NOT NULL
);

INSERT INTO users VALUES (1,'user1','user1@ffhs.ch','123456');
INSERT INTO users VALUES (2,'user2','user2@ffhs.ch','123456');
