# Write your MySQL query statement below
select e1.name as Employee from Employee e1 
inner join Employee e2 
where e1.Managerid = e2.id 
and e1.salary> e2.salary;