--問1
SELECT e.name, d.name
FROM employees e
INNER JOIN departments d
ON e.department_id = d.id;

--問2
SELECT d.name,
AVG(e.salary) AS average_salary
FROM employees e
INNER JOIN departments d
ON e.department_id = d.id
GROUP BY d.name;

--問3
SELECT p.name,
SUM(ep.hours) AS total_hours
FROM projects p
INNER JOIN employee_projects ep
ON p.id = ep.project_id
GROUP BY p.name;

--問4
SELECT *
FROM employees
WHERE salary = (
SELECT MAX(salary)
FROM employees
);

--問5
SELECT e.*
FROM employees e
LEFT JOIN employee_projects ep
ON e.id = ep.employee_id
WHERE ep.employee_id IS NULL;

--問6
SELECT e.name 
AS employee_name, p.name
AS project_name
FROM employee_projects ep
INNER JOIN employees e
ON ep.employee_id = e.id
INNER JOIN projects p
ON ep.project_id = p.id
WHERE ep.hours >= 50;

--問7
SELECT e.name, e.salary
FROM employees e
INNER JOIN departments d
ON e.department_id = d.id
WHERE d.name = '開発'
ORDER BY e.salary DESC;

--問8
SELECT e.name,
SUM(ep.hours) AS total_hours
FROM employees e
INNER JOIN employee_projects ep
ON e.id = ep.employee_id
GROUP BY e.name
ORDER BY total_hours DESC;