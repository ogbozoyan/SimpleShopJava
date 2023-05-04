# SimpleShopJava

Создание backed для интернет-магазина реализующее следуюдий функционал: 
 1. Запись, чтение, изменение, удаление данных о товарах из базы
 2. Получение списка всех товаров, получение товаров с заданными фильтрами (цена от-до, фильтр по категориям, фильтры по производителю итд), сортировка товаров (убывание, возрастание), пагинация.
 3. Реализовать корзину для отслеживания истории покупок, для этого потребуется реализовать аутентификацию в системе (пример - jwt token). Реализовать запрос для получения истории покупок конкретного пользователя
 DDL:
![image](https://user-images.githubusercontent.com/85520525/236308740-b7fc8e07-c3e9-4776-a635-cc484532ed6a.png)

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

create table history_order
(
    id      bigserial
        primary key,
    user_id bigint
        constraint history_order_user_table_id_fk
            references user_table
            on update cascade on delete cascade,
    cart_id bigint
        constraint history_order_cart_id_fk
            references cart
            on update cascade on delete cascade
);

alter table history_order
    owner to shop;

