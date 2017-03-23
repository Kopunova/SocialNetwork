
INSERT INTO users VALUES (1, 'Olga', 'olga@ukr.net', '', '');
INSERT INTO users VALUES (2, 'Vova', 'vova@ukr.net', '', '');
INSERT INTO users VALUES (3, 'Masha', 'masha@ukr.net', '', '');
INSERT INTO users VALUES (4, 'Inna', 'inna@ukr.net', '', '');
INSERT INTO users VALUES (5, 'Sveta', 'sveta@ukr.net', '', '');

INSERT INTO user_friend VALUES (1, 1, 2);
INSERT INTO user_friend VALUES (2, 1, 3);
INSERT INTO user_friend VALUES (3, 1, 4);
INSERT INTO user_friend VALUES (4, 4, 5);

INSERT INTO news VALUES (1, '2017-01-10', 1, 'news1 news1 news1', '');
INSERT INTO news VALUES (2, '2017-01-15', 1, 'news2 news2 news2', '');
INSERT INTO news VALUES (3, '2017-02-05', 1, 'news3 news3 news3', '');
INSERT INTO news VALUES (4, '2017-02-15', 2, 'news1 news1 news1', '');
INSERT INTO news VALUES (5, '2017-02-05', 2, 'news2 news2 news2', '');

INSERT INTO user_news VALUES (1, 1, 1, '2017-01-10', 1);
INSERT INTO user_news VALUES (2, 1, 2, '2017-01-15', 0);
INSERT INTO user_news VALUES (3, 1, 3, '2017-02-05', 12);
INSERT INTO user_news VALUES (4, 2, 4, '2017-02-15', 1);
INSERT INTO user_news VALUES (5, 2, 5, '2017-02-05', 0);

INSERT INTO news_comment VALUES (1, '2017-01-10', 1, 2, 'comment1');
INSERT INTO news_comment VALUES (2, '2017-01-15', 3, 3, 'comment2');

SELECT setval('users_id_seq', 5, true);
SELECT setval('user_friend_id_seq', 4, true);
SELECT setval('news_id_seq', 5, true);
SELECT setval('user_news_id_seq', 5, true);
SELECT setval('news_comment_id_seq', 2, true);




























 


