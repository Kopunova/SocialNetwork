--db name: social_network 

--tables
-- Table: users
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    media_file varchar(900) NOT NULL
);

-- Table: news
CREATE TABLE news (
    id SERIAL PRIMARY KEY,
    created timestamp(0) DEFAULT now(),
    user_id int NOT NULL REFERENCES users(id),
    content text NOT NULL,
    media_file varchar(900)   
);

-- Table: user_news
CREATE TABLE user_news (
    id SERIAL PRIMARY KEY,
    user_id int NOT NULL REFERENCES users(id),
    news_id int NOT NULL REFERENCES news(id), 
    created timestamp(0) DEFAULT now(),
    likes int DEFAULT 0   
);

-- Table: news_comment
CREATE TABLE news_comment (
    id SERIAL PRIMARY KEY,
    created timestamp DEFAULT now(),
    user_news_id int NOT NULL REFERENCES user_news(id),
    user_id int NOT NULL REFERENCES users(id),
    content varchar(250) NOT NULL   
);

-- Table: user_friend
CREATE TABLE user_friend (
    id SERIAL PRIMARY KEY,
    user_id int NOT NULL REFERENCES users(id),
    friend_user_id int NOT NULL REFERENCES users(id)
);












































