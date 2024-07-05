-- Вставка тестовых данных в таблицу USERS
INSERT INTO USERS (USERNAME, EMAIL, PASSWORD) VALUES
                                                  ('Yamal', 'yamal@gmail.com', '1234567890'),
                                                  ('Kirill', 'kirille@@gmail.com', '1234567123');

-- Вставка тестовых данных в таблицу TASKS
INSERT INTO TASKS (USER_ID, TITLE, DESCRIPTION, STATUS, PRIORITY, DUE_DATE, REMINDER_TIME) VALUES
                                                                                               (1, 'Task 1', 'Description for task 1', 'pending', 'high', '2024-06-20', '2024-06-19 10:00:00'),
                                                                                               (1, 'Task 2', 'Description for task 2', 'in progress', 'medium', '2024-06-25', '2024-06-24 14:00:00'),
                                                                                               (2, 'Task 3', 'Description for task 3', 'completed', 'low', '2024-06-15', '2024-06-24 14:00:00');

-- Вставка тестовых данных в таблицу CATEGORIES
INSERT INTO CATEGORIES (NAME, DESCRIPTION) VALUES
                                               ('Work', 'Tasks related to work'),
                                               ('Personal', 'Personal tasks');

-- Вставка тестовых данных в таблицу TASK_CATEGORIES
INSERT INTO TASK_CATEGORIES (TASK_ID, CATEGORY_ID) VALUES
                                                       (1, 1),
                                                       (2, 2);

-- Вставка тестовых данных в таблицу TAGS
INSERT INTO TAGS (NAME) VALUES
                            ('urgent'),
                            ('home'),
                            ('work');

-- Вставка тестовых данных в таблицу TASK_TAGS
INSERT INTO TASK_TAGS (TASK_ID, TAG_ID) VALUES
                                            (1, 1),
                                            (2, 2);

-- Вставка тестовых данных в таблицу REPORTS
INSERT INTO REPORTS (USER_ID, CONTENT) VALUES
                                           (1, 'Report content for user 1'),
                                           (2, 'Report content for user 2');

-- Вставка тестовых данных в таблицу FILTERS
INSERT INTO FILTERS (FILTER_NAME, CRITERIA) VALUES
                                                ('High Priority', '{"priority": "high"}'),
                                                ('Completed Tasks', '{"status": "completed"}');

-- Вставка тестовых данных в таблицу PROJECTS
INSERT INTO PROJECTS (USER_ID, NAME, DESCRIPTION) VALUES
                                                      (1, 'Project 1', 'Description for project 1'),
                                                      (2, 'Project 2', 'Description for project 2');

-- Вставка тестовых данных в таблицу PROJECT_TASKS
INSERT INTO PROJECT_TASKS (ID, TASK_ID) VALUES
                                            (1, 1),
                                            (2, 3);

-- Вставка тестовых данных в таблицу SUBTASKS
INSERT INTO SUBTASKS (TASK_ID, TITLE, STATUS, DUE_DATE) VALUES
                                                            (1, 'Subtask 1 for Task 1', 'pending', '2024-06-18'),
                                                            (2, 'Subtask 2 for Task 2', 'in progress', '2024-06-22');


