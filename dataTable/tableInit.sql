------ɾ�����õ��ı�񣬷�ֹ֮ǰ�Ѵ���ͬ����
DROP TABLE expatriate;
DROP TABLE company;
DROP TABLE personnel;

DROP TABLE notice;

DROP TABLE rent;
DROP TABLE car;

DROP TABLE cargo;

DROP TABLE card;
DROP TABLE cardcase;

DROP TABLE manager;
DROP TABLE employee;
DROP TABLE department;
DROP TABLE job;

-- ɾ������
DROP SEQUENCE expatriate_seq;
DROP SEQUENCE company_seq;
DROP SEQUENCE personnel_seq;
DROP SEQUENCE notice_seq;
DROP SEQUENCE rent_seq;
DROP SEQUENCE car_seq;
DROP SEQUENCE cargo_seq;
DROP SEQUENCE card_seq;
DROP SEQUENCE cardcase_seq;
DROP SEQUENCE employee_seq;
DROP SEQUENCE department_seq;
DROP SEQUENCE job_seq;

---------------------------------

-- 2. ϵͳ�������ţ�ְ��Ա����
-- ���ű�
CREATE TABLE department (
   dept_id          NUMBER(6) PRIMARY KEY,    -- ��100000��ʼ
   dept_name        VARCHAR2(50),
   dept_desc        VARCHAR2(200)
);
CREATE SEQUENCE department_seq MAXVALUE 150000 INCREMENT BY 1 START WITH 100000;

-- ְ���
CREATE TABLE job (
   job_id           NUMBER(6) PRIMARY KEY,    -- ��150000��ʼ
   job_name         VARCHAR2(50),
   job_desc         VARCHAR2(200)
);
CREATE SEQUENCE job_seq MAXVALUE 200000 INCREMENT BY 1 START WITH 150000;

-- Ա����
CREATE TABLE employee (
    emp_id          NUMBER(6) PRIMARY KEY,    -- ��200000��ʼ
    emp_name        VARCHAR2(50),
    emp_phone       VARCHAR2(50),
    emp_birthday    DATE,
    emp_email       VARCHAR2(20),
    emp_qq          NUMBER(15),
    emp_pwd         VARCHAR2(16),
    dept_id         NUMBER(6) REFERENCES department (dept_id),
    job_id          NUMBER(6) REFERENCES job (job_id)
);
CREATE SEQUENCE employee_seq MAXVALUE 250000 INCREMENT BY 1 START WITH 200000;


-- ����Ա��
CREATE TABLE manager (
    emp_id NUMBER(6) REFERENCES employee (emp_id)
);

-- 3.��Ƭ����
-- �����
CREATE TABLE cardcase (
   cardcase_id         NUMBER(6) PRIMARY KEY,   -- ��250000��ʼ
   cardcase_name       VARCHAR2(20),
   emp_id              NUMBER(6) REFERENCES  employee (emp_id)
);
CREATE SEQUENCE cardcase_seq MAXVALUE 300000 INCREMENT BY 1 START WITH 250000;

-- ��Ƭ��
CREATE TABLE card (
   card_id          NUMBER(6) PRIMARY KEY,                  -- ��300000��ʼ
   card_name        VARCHAR2(50),
   card_job         VARCHAR2(200),
   card_phone       NUMBER(11),
   card_qq          NUMBER(15),
   card_addr        VARCHAR2(50),
   card_email       VARCHAR2(20),
   card_company     VARCHAR2(20),
   cardcase_id      NUMBER(6) REFERENCES  cardcase (cardcase_id)
);
CREATE SEQUENCE card_seq MAXVALUE 350000 INCREMENT BY 1 START WITH 300000;

-- 4.������
-- �����
CREATE TABLE cargo (
   cargo_id         NUMBER(6) PRIMARY KEY,      -- ��400000��ʼ
   cargo_name       VARCHAR2(20),
   cargo_desc   	VARCHAR2(20),
   cargo_price      NUMBER(6),
   cargo_num        NUMBER(3)
);
CREATE SEQUENCE cargo_seq MAXVALUE 450000 INCREMENT BY 1 START WITH 400000;

-- 5.���ӹ���
-- ������
CREATE TABLE car (
    car_id          NUMBER(6) PRIMARY KEY,      -- ��450000��ʼ
    car_type        VARCHAR2(20),
    car_num         VARCHAR2(20),
    car_photo       BLOB,
    car_status      VARCHAR2(20) check (car_status in ('free', 'busy'))
);
CREATE SEQUENCE car_seq MAXVALUE 500000 INCREMENT BY 1 START WITH 450000;

-- ����¼��
CREATE TABLE rent (
    rent_id         NUMBER(6) PRIMARY KEY,                -- ��500000��ʼ
    emp_id          NUMBER(6) REFERENCES  employee (emp_id),
    car_id          NUMBER(6) REFERENCES car (car_id),
    rent_path       VARCHAR2(50),
    rent_start      date,
    rent_end        date,
    rent_status     VARCHAR2(20) check (rent_status in ('finish', 'unfinished'))
);
CREATE SEQUENCE rent_seq MAXVALUE 550000 INCREMENT BY 1 START WITH 500000;

-- 6.�������
-- �����
CREATE TABLE notice (   
    notice_id       NUMBER(6)  PRIMARY KEY,     -- ��550000��ʼ
    notice_title    VARCHAR2(50),
    notice_date     date,
    notice_desc     VARCHAR2(200)
);
CREATE SEQUENCE notice_seq MAXVALUE 600000 INCREMENT BY 1 START WITH 550000;

-- 7.�����˲Ź���
-- �˲ű�
CREATE TABLE personnel (
    personnel_id       NUMBER(6) PRIMARY KEY,   -- ��600000��ʼ
    personnel_name     VARCHAR2(20),
    personnel_educt    VARCHAR2(11),
    personnel_skill    VARCHAR2(50),
    personnel_salary   NUMBER(7),
    personnel_status   VARCHAR2(20) check (personnel_status in ('free', 'busy'))
);
CREATE SEQUENCE personnel_seq MAXVALUE 650000 INCREMENT BY 1 START WITH 600000;

-- ������˾��
CREATE TABLE company (
    company_id      NUMBER(6) PRIMARY KEY,      -- ��650000��ʼ
    company_name    VARCHAR2(20),
    company_master  VARCHAR2(20),
    company_phone   NUMBER(11),
    company_qq      NUMBER(15),
    company_desc    VARCHAR2(50)
);
CREATE SEQUENCE company_seq MAXVALUE 700000 INCREMENT BY 1 START WITH 650000;

-- ���ɼ�¼��
CREATE TABLE expatriate (
    expatriate_id   		NUMBER(6) PRIMARY KEY,    -- ��700000��ʼ
    personnel_id    		NUMBER(6) REFERENCES personnel (personnel_id),
    company_id      		NUMBER(6) REFERENCES company (company_id),
    expatriate_start    	date,
    expatriate_end      	date,
    company_request 		VARCHAR2(50),
    expatriate_status     	VARCHAR2(20) check (expatriate_status in ('finish', 'unfinished'))
);
CREATE SEQUENCE expatriate_seq MAXVALUE 750000 INCREMENT BY 1 START WITH 700000;
