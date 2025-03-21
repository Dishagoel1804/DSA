# Write your MySQL query statement below
Select COALESCE(eu.unique_id,null) as unique_id, e.name
from Employees e
left join EmployeeUNI eu
On e.id=eu.id