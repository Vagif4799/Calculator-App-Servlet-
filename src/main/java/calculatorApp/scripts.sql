create table calculator2
(
    id     serial not null
        constraint calculator2_pk
            primary key,
    op1    integer,
    op2    integer,
    op     text,
    result integer,
    "user" integer
);
