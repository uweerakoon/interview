select e.*
from employee e
inner join address a on e.addressId = a.id
where a.state = 'UT';