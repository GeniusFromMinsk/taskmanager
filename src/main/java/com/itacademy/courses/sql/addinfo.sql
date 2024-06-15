-- Insert test data into Users table
INSERT INTO Users (username, email, password) VALUES
                                                  ('Yamal', 'yamal@gmail.com', '1234567890'),
                                                  ('Kirill', 'kirille@@gmail.com', '1234567123');

-- Insert test data into Tasks table
INSERT INTO Tasks (user_id, title, description, status, priority, due_date) VALUES
                                                                                (1, 'Task 1', 'Description for task 1', 'pending', 'high', '2024-06-20'),
                                                                                (1, 'Task 2', 'Description for task 2', 'in progress', 'medium', '2024-06-25'),
                                                                                (2, 'Task 3', 'Description for task 3', 'completed', 'low', '2024-06-15');

-- Insert test data into Categories table
INSERT INTO Categories (name, description) VALUES
                                               ('Work', 'Tasks related to work'),
                                               ('Personal', 'Personal tasks');

-- Insert test data into TaskCategories table
INSERT INTO TaskCategories (task_id, category_id) VALUES
                                                      (1, 1),
                                                      (2, 2);

-- Insert test data into Reminders table
INSERT INTO Reminders (task_id, reminder_time) VALUES
                                                   (1, '2024-06-19 10:00:00'),
                                                   (2, '2024-06-24 14:00:00');

-- Insert test data into Tags table
INSERT INTO Tags (name) VALUES
                            ('urgent'),
                            ('home'),
                            ('work');

-- Insert test data into TaskTags table
INSERT INTO TaskTags (task_id, tag_id) VALUES
                                           (1, 1),
                                           (2, 2);

-- Insert test data into Reports table
INSERT INTO Reports (user_id, content) VALUES
                                           (1, 'Report content for user 1'),
                                           (2, 'Report content for user 2');

-- Insert test data into Filters table
INSERT INTO Filters (user_id, filter_name, criteria) VALUES
                                                         (1, 'High Priority', '{"priority": "high"}'),
                                                         (2, 'Completed Tasks', '{"status": "completed"}');

-- Insert test data into Projects table
INSERT INTO Projects (user_id, name, description) VALUES
                                                      (1, 'Project 1', 'Description for project 1'),
                                                      (2, 'Project 2', 'Description for project 2');

-- Insert test data into ProjectTasks table
INSERT INTO ProjectTasks (project_id, task_id) VALUES
                                                   (1, 1),
                                                   (2, 3);

-- Insert test data into Subtasks table
INSERT INTO Subtasks (task_id, title, status, due_date) VALUES
                                                            (1, 'Subtask 1 for Task 1', 'pending', '2024-06-18'),
                                                            (2, 'Subtask 2 for Task 2', 'in progress', '2024-06-22');