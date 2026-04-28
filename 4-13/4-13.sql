/**
* 問1
 */
    SELECT name, salary, hire_date
    FROM employees
    ORDER BY hire_date DESC;

/**
* 問2
 */

    SELECT * FROM employees
    WHERE department_id = 1 AND salary >= 300000;

/**
* 問3
 */

    SELECT department_id, COUNT(*) AS employee_count
    FROM employees
    GROUP BY department_id;

/**
* 問4
 */

    SELECT e.name, d.name AS department_name
    FROM employees e
    JOIN departments d ON e.department_id = d.id;

/**
* 問5
 */

    SELECT project_id, COUNT(employee_id) AS member_count
    FROM employee_projects
    GROUP BY project_id;

/**
* 問6
 */

    SELECT employee_id, SUM(hours) AS total_hours
    FROM employee_projects
    GROUP BY employee_id
    ORDER BY total_hours DESC;

/**
* 問7
 */

    SELECT department_id, MAX(salary) AS max_salary
    FROM employees
    GROUP BY department_id;

/**
* 問8
 */

    SELECT *
    FROM employees WHERE id NOT IN (
    SELECT employee_id FROM employee_projects
    );