-- Create Users table
CREATE TABLE Users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Tasks table
CREATE TABLE Tasks (
                       task_id SERIAL PRIMARY KEY,
                       user_id INT,
                       title VARCHAR(100) NOT NULL,
                       description TEXT,
                       status VARCHAR(20) NOT NULL,
                       priority VARCHAR(10),
                       due_date DATE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES Users(user_id)
);


-- Create Categories table
CREATE TABLE Categories (
                            category_id SERIAL PRIMARY KEY,
                            name VARCHAR(50) NOT NULL,
                            description TEXT
);

-- Create TaskCategories table (many-to-many)
CREATE TABLE TaskCategories (
                                task_id INT,
                                category_id INT,
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (task_id, category_id),
                                FOREIGN KEY (task_id) REFERENCES Tasks(task_id),
                                FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Create Reminders table
CREATE TABLE Reminders (
                           reminder_id SERIAL PRIMARY KEY,
                           task_id INT,
                           reminder_time TIMESTAMP,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (task_id) REFERENCES Tasks(task_id)
);

-- Create Tags table
CREATE TABLE Tags (
                      tag_id SERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL
);

-- Create TaskTags table (many-to-many)
CREATE TABLE TaskTags (
                          task_id INT,
                          tag_id INT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          PRIMARY KEY (task_id, tag_id),
                          FOREIGN KEY (task_id) REFERENCES Tasks(task_id),
                          FOREIGN KEY (tag_id) REFERENCES Tags(tag_id)
);

-- Create Reports table
CREATE TABLE Reports (
                         report_id SERIAL PRIMARY KEY,
                         user_id INT,
                         content TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Create Filters table
CREATE TABLE Filters (
                         filter_id SERIAL PRIMARY KEY,
                         user_id INT,
                         filter_name VARCHAR(50) NOT NULL,
                         criteria JSON,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Create Projects table
CREATE TABLE Projects (
                          project_id SERIAL PRIMARY KEY,
                          user_id INT,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Create ProjectTasks table (many-to-many)
CREATE TABLE ProjectTasks (
                              project_id INT,
                              task_id INT,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              PRIMARY KEY (project_id, task_id),
                              FOREIGN KEY (project_id) REFERENCES Projects(project_id),
                              FOREIGN KEY (task_id) REFERENCES Tasks(task_id)
);

-- Create Subtasks table
CREATE TABLE Subtasks (
                          subtask_id SERIAL PRIMARY KEY,
                          task_id INT,
                          title VARCHAR(100) NOT NULL,
                          status VARCHAR(20),
                          due_date DATE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (task_id) REFERENCES Tasks(task_id)
);