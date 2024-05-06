CREATE TABLE IF NOT EXISTS students (
    id         int PRIMARY KEY AUTO_INCREMENT,
    teacher_id int NOT NULL,
    name       varchar(50) NOT NULL,
    login_id   varchar(50) NOT NULL,
    class_id   int NOT NULL,
    class_name varchar(50) NOT NULL
);

INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (1, '佐藤', 'foo123', 1, 'クラスA');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (2, '鈴木', 'bar456', 2, 'クラスB');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (1, '田中', 'baz789', 3, 'クラスC');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (1, '加藤', 'hoge0000', 1, 'クラスA');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (2, '太田', 'fuga1234', 2, 'クラスB');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (1, '佐々木', 'piyo5678', 3, 'クラスC');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (1, '小田原', 'fizz9999', 1, 'クラスA');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (2, 'Smith', 'buzz777', 2, 'クラスB');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (1, 'Johnson', 'fizzbuzz#123', 3, 'クラスC');
INSERT INTO students (teacher_id, name, login_id, class_id, class_name) VALUES (1, 'Williams', 'xxx:42', 1, 'クラスA');
