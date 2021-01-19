create table rentit.categories
(
    id   integer generated always as identity primary key,
    name text unique not null
);

create table rentit.products
(
    id            integer generated always as identity primary key,
    category_id   integer      not null,
    name          varchar(255) not null,
    price_per_day integer      not null,
    description   text         not null,
    constraint fk_category
        foreign key (category_id) references rentit.categories (id)
);

create table rentit.images
(
    id         integer generated always as identity primary key,
    url        varchar(255) not null,
    product_id integer      not null,
    constraint fk_product
        foreign key (product_id) references rentit.products (id)
);

create table rentit.accounts
(
    id         integer generated always as identity primary key,
    first_name varchar(30)        not null,
    last_name  varchar(30)        not null,
    email      varchar(50) unique not null,
    mobile     varchar(20) unique not null
);

create table rentit.rented_products
(
    id          integer generated always as identity primary key,
    category_id integer      not null,
    product_id  integer      not null,
    renter_id   integer      not null,
    rentee_id   integer      not null,
    constraint fk_category foreign key (category_id) references rentit.categories (id),
    constraint fk_product foreign key (product_id) references rentit.products (id),
    constraint fk_renter foreign key (renter_id) references rentit.accounts (id),
    constraint fk_rentee foreign key (rentee_id) references rentit.accounts (id),
    address     varchar(255) not null,
    start_date  date         not null,
    end_date    date         not null
);

create table rentit.users
(
    id integer generated always as identity primary key,
    username varchar(20) not null,
    password varchar(120) not null
);

create type rentit.erole as enum ('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN');

create table rentit.roles
(
    id integer generated always as identity primary key,
    name rentit.erole
);

create table rentit.user_roles (
    user_id integer not null,
    role_id integer not null,
    constraint fk_user foreign key (user_id) references rentit.users(id),
    constraint fk_role foreign key (role_id) references rentit.roles(id)
);