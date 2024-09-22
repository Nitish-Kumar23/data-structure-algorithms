# Write your MySQL query statement below
select max(salary) as SecondHighestSalary from Employee where salary not in (select max(salary) from Employee);

# Write your MySQL query statement below
select coalesce(
(select distinct salary from employee order by salary desc limit 1, 1),null) as SecondHighestSalary;