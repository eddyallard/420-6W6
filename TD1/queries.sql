/*1*/
select customer_id, first_name, last_name, email
from customer
order by last_name;
/*2*/
select customer_id, first_name, last_name, email, district, postal_code, phone
from customer
inner join address on customer.address_id = address.address_id
where customer_id = 220;
/*3*/
select first_name, last_name, email
from customer
order by create_date
limit 5;
/*4*/
select first_name, last_name, email
from customer
inner join address on address.address_id = customer.address_id
inner join city on city.city_id = address.city_id
inner join country on country.country_id = city.country_id
where country = "Afghanistan";
/*5*/
select c.first_name, c.last_name, r.rental_date, r.return_date
from rental r
inner join customer c on r.customer_id = c.customer_id
where r.customer_id = 13;
/*6*/
select a.first_name, a.last_name
from actor a
inner join film_actor fa on fa.actor_id = a.actor_id
where fa.film_id = 2
/*7*/
select c.first_name, c.last_name, sum(p.amount) as total
from customer c, payment p
where p.customer_id = c.customer_id
group by c.customer_id
order by total desc;
/*8*/
select c.first_name, c.last_name
from customer c
where not exists(select * from rental r where r.customer_id = c.customer_id);
/*9*/
select actor_id, count(actor_id) as film_count
from film_actor
group by actor_id
order by film_count desc
limit 1;
/*10*/
select c.name, avg(f.length) as avg_length
from film_category fc
inner join category c on c.category_id = fc.category_id
inner join film f on f.film_id = fc.film_id
group by c.category_id