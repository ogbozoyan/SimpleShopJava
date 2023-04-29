# SimpleShopJava

Создание backed для интернет-магазина реализующее следуюдий функционал: 
 1. Запись, чтение, изменение, удаление данных о товарах из базы
 2. Получение списка всех товаров, получение товаров с заданными фильтрами (цена от-до, фильтр по категориям, фильтры по производителю итд), сортировка товаров (убывание, возрастание), пагинация.
 3. Реализовать корзину для отслеживания истории покупок, для этого потребуется реализовать аутентификацию в системе (пример - jwt token). Реализовать запрос для получения истории покупок конкретного пользователя
 DDL:
<img width="795" alt="Screenshot 2023-04-29 at 16 11 21" src="https://user-images.githubusercontent.com/85520525/235304396-5fe7724f-b047-4bf5-b20d-eb29fa8c302c.png">
Sql:
create table user_table
(
    id       bigserial
        primary key,
    login    varchar
        unique,
    password varchar
);

alter table user_table
    owner to shop;

create table role_table
(
    id   bigserial
        primary key,
    name varchar
        unique
);

alter table role_table
    owner to shop;

create table user_role
(
    id      bigserial
        primary key,
    user_id bigint
        constraint user_role_user_table_id_fk
            references user_table
            on update cascade on delete cascade,
    role_id bigint
        constraint user_role_role_table_id_fk
            references role_table
            on update cascade on delete cascade
);

alter table user_role
    owner to shop;

create table items
(
    id       bigserial
        primary key,
    name     varchar,
    category varchar,
    price    integer
);

alter table items
    owner to shop;

create table cart
(
    id      bigserial
        primary key,
    user_id bigint
        constraint cart_user_table_id_fk
            references user_table
            on update cascade on delete cascade,
    item_id bigint
        constraint cart_items_id_fk
            references items
            on update cascade on delete cascade
);

alter table cart
    owner to shop;

