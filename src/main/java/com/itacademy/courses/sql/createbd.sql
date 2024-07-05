-- Создание таблицы USERS
CREATE TABLE USERS (
                       ID SERIAL PRIMARY KEY,
                       USERNAME VARCHAR(50) NOT NULL,
                       EMAIL VARCHAR(100) NOT NULL,
                       PASSWORD VARCHAR(255) NOT NULL,
                       CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы TASKS
CREATE TABLE TASKS (
                       ID SERIAL PRIMARY KEY,
                       USER_ID INT NOT NULL,
                       TITLE VARCHAR(100) NOT NULL,
                       DESCRIPTION TEXT NOT NULL,
                       STATUS VARCHAR(20) NOT NULL,
                       PRIORITY VARCHAR(10) NOT NULL,
                       DUE_DATE DATE NOT NULL,
                       REMINDER_TIME TIMESTAMP,
                       CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

-- Создание таблицы CATEGORIES
CREATE TABLE CATEGORIES (
                            ID SERIAL PRIMARY KEY,
                            NAME VARCHAR(50) NOT NULL,
                            DESCRIPTION TEXT NOT NULL,
                            CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы TASK_CATEGORIES (связь многие ко многим)
CREATE TABLE TASK_CATEGORIES (
                                 TASK_ID INT,
                                 CATEGORY_ID INT,
                                 CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (TASK_ID, CATEGORY_ID),
                                 FOREIGN KEY (TASK_ID) REFERENCES TASKS(ID),
                                 FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES(ID)
);

-- Создание таблицы TAGS
CREATE TABLE TAGS (
                      ID SERIAL PRIMARY KEY,
                      NAME VARCHAR(50) NOT NULL,
                      CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы TASK_TAGS (связь многие ко многим)
CREATE TABLE TASK_TAGS (
                           TASK_ID INT,
                           TAG_ID INT,
                           CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           PRIMARY KEY (TASK_ID, TAG_ID),
                           FOREIGN KEY (TASK_ID) REFERENCES TASKS(ID),
                           FOREIGN KEY (TAG_ID) REFERENCES TAGS(ID)
);

-- Создание таблицы REPORTS
CREATE TABLE REPORTS (
                         ID SERIAL PRIMARY KEY,
                         USER_ID INT NOT NULL,
                         CONTENT TEXT NOT NULL,
                         CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

-- Создание таблицы FILTERS
CREATE TABLE FILTERS (
                         ID SERIAL PRIMARY KEY,
                         FILTER_NAME VARCHAR(50) NOT NULL,
                         CRITERIA VARCHAR(100) NOT NULL,
                         CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы PROJECTS
CREATE TABLE PROJECTS (
                          ID SERIAL PRIMARY KEY,
                          USER_ID INT NOT NULL,
                          NAME VARCHAR(100) NOT NULL,
                          DESCRIPTION TEXT NOT NULL,
                          CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

-- Создание таблицы PROJECT_TASKS (связь многие ко многим)
CREATE TABLE PROJECT_TASKS (
                               ID INT,
                               TASK_ID INT,
                               CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               PRIMARY KEY (ID, TASK_ID),
                               FOREIGN KEY (ID) REFERENCES PROJECTS(ID),
                               FOREIGN KEY (TASK_ID) REFERENCES TASKS(ID)
);

-- Создание таблицы SUBTASKS
CREATE TABLE SUBTASKS (
                          ID SERIAL PRIMARY KEY,
                          TASK_ID INT NOT NULL,
                          TITLE VARCHAR(100) NOT NULL,
                          STATUS VARCHAR(20) NOT NULL,
                          DUE_DATE DATE NOT NULL,
                          CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (TASK_ID) REFERENCES TASKS(ID)
);
