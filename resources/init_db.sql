
create table costumer
(
    uuid      char(36) primary key not null,
    full_name text                 not null
);

create table session
(
    id          serial,
    costumer_uuid char(36) not null references costumer (uuid) on delete cascade,
    from_num_to_num        text     not null,
    ip       varchar(15)     not null,
    end_time timestamp not null
);


create table if not exists costumer_card
(
    id          serial,
    full_name           text            not null,
    costumer_mac        text            not null,
    service_mac         text            not null,
    pillar_number       integer         not null,
    onu_number          integer         not null,
    ip                  varchar(15)     not null
);

