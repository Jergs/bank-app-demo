create table db.customers
(
    customer_id   int          not null auto_increment,
    name          varchar(50)  not null,
    email         varchar(100) not null,
    mobile_number varchar(20)  not null,
    pwd           varchar(500) not null,
    role          varchar(100) not null,
    created_at    date default null,
    primary key (customer_id)
);

create table db.accounts
(
    customer_id    int          not null,
    account_number int          not null,
    account_type   varchar(100) not null,
    branch_address varchar(200) not null,
    created_at     date default null,
    primary key (account_number),
    key customer_id (customer_id),
    constraint customer_ibfk_1 foreign key (customer_id) references customers (customer_id) on delete cascade
);

CREATE TABLE db.balances
(
    balance_id     int NOT NULL auto_increment,
    account_number int NOT NULL,
    amount         int NOT NULL,
    updated_at     date DEFAULT NULL,
    PRIMARY KEY (balance_id),
    KEY account_number (account_number),
    CONSTRAINT accounts_ibfk_1 FOREIGN KEY (account_number) REFERENCES accounts (account_number) on delete cascade
);

CREATE TABLE db.transactions
(
    transaction_id int          NOT NULL auto_increment,
    account_number int          NOT NULL,
    customer_id    int          NOT NULL,
    date           date         NOT NULL,
    summary        varchar(200) NOT NULL,
    type           varchar(100) NOT NULL,
    amount         int          NOT NULL,
    created_at     date DEFAULT NULL,
    PRIMARY KEY (transaction_id),
    KEY customer_id (customer_id),
    KEY account_number (account_number),
    CONSTRAINT accounts_ibfk_2 FOREIGN KEY (account_number) REFERENCES accounts (account_number) ON DELETE CASCADE,
    CONSTRAINT acct_user_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);

CREATE TABLE db.loans
(
    loan_number        int          NOT NULL AUTO_INCREMENT,
    customer_id        int          NOT NULL,
    start_date         date         NOT NULL,
    type               varchar(100) NOT NULL,
    total              int          NOT NULL,
    amount_paid        int          NOT NULL,
    outstanding_amount int          NOT NULL,
    created_at         date DEFAULT NULL,
    PRIMARY KEY (loan_number),
    KEY customer_id (customer_id),
    CONSTRAINT loan_customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);


CREATE TABLE db.cards
(
    card_id          int          NOT NULL AUTO_INCREMENT,
    card_number      varchar(100) NOT NULL,
    customer_id      int          NOT NULL,
    type             varchar(100) NOT NULL,
    total_limit      int          NOT NULL,
    amount_used      int          NOT NULL,
    available_amount int          NOT NULL,
    created_at       date DEFAULT NULL,
    PRIMARY KEY (card_id),
    KEY customer_id (customer_id),
    CONSTRAINT card_customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);

CREATE TABLE db.notices
(
    notice_id  int          NOT NULL AUTO_INCREMENT,
    summary    varchar(200) NOT NULL,
    details    varchar(500) NOT NULL,
    beg_date   date         NOT NULL,
    end_date   date DEFAULT NULL,
    created_at date DEFAULT NULL,
    updated_at date DEFAULT NULL,
    PRIMARY KEY (notice_id)
);

CREATE TABLE db.contact_messages
(
    contact_id varchar(50)   NOT NULL,
    name       varchar(50)   NOT NULL,
    email      varchar(100)  NOT NULL,
    subject    varchar(500)  NOT NULL,
    message    varchar(2000) NOT NULL,
    created_at date DEFAULT NULL,
    PRIMARY KEY (contact_id)
);