
-- =========================================
-- データベース名：task_management_db
-- テーブル定義SQL
-- =========================================

-- 1. ユーザーテーブル
CREATE TABLE user_tbl (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


-- 2. カテゴリーテーブル
CREATE TABLE category_tbl (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(30) NOT NULL
);

-- カテゴリ初期データ
INSERT INTO category_tbl (category_name)
VALUES
    ('仕事'),
    ('学習'),
    ('プライベート'),
    ('その他');


-- 3. タスクテーブル
CREATE TABLE task_tbl (
    task_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    task_name VARCHAR(100) NOT NULL,
    task_detail VARCHAR(500),
    due_date DATE,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES user_tbl(user_id),
    FOREIGN KEY (category_id)
        REFERENCES category_tbl(category_id)
);
