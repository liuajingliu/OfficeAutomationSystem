------删除所用到的表格，防止之前已存在同名表单
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

-- 删除序列
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

-- 2. 系统管理（部门，职务，员工）
-- 部门表
CREATE TABLE department (
   dept_id          NUMBER(6) PRIMARY KEY,    -- 从100000开始
   dept_name        VARCHAR2(50),
   dept_desc        VARCHAR2(200)
);
CREATE SEQUENCE department_seq MAXVALUE 150000 INCREMENT BY 1 START WITH 100000;

-- 职务表
CREATE TABLE job (
   job_id           NUMBER(6) PRIMARY KEY,    -- 从150000开始
   job_name         VARCHAR2(50),
   job_desc         VARCHAR2(200)
);
CREATE SEQUENCE job_seq MAXVALUE 200000 INCREMENT BY 1 START WITH 150000;

-- 员工表
CREATE TABLE employee (
    emp_id          NUMBER(6) PRIMARY KEY,    -- 从200000开始
    emp_name        VARCHAR2(50),
    emp_phone       VARCHAR2(50),
    emp_birthday    DATE,
    emp_email       VARCHAR2(20),
    emp_qq          VARCHAR2(50),
    emp_pwd         VARCHAR2(20),
    dept_id         NUMBER(6) REFERENCES department (dept_id),
    job_id          NUMBER(6) REFERENCES job (job_id)
);
CREATE SEQUENCE employee_seq MAXVALUE 250000 INCREMENT BY 1 START WITH 200000;


-- 管理员表
CREATE TABLE manager (
    emp_id NUMBER(6) REFERENCES employee (emp_id)
);

-- 3.名片管理
-- 分组表
CREATE TABLE cardcase (
   cardcase_id         NUMBER(6) PRIMARY KEY,   -- 从250000开始
   cardcase_name       VARCHAR2(20),
   emp_id              NUMBER(6) REFERENCES  employee (emp_id)
);
CREATE SEQUENCE cardcase_seq MAXVALUE 300000 INCREMENT BY 1 START WITH 250000;

-- 名片表
CREATE TABLE card (
   card_id          NUMBER(6) PRIMARY KEY,                  -- 从300000开始
   card_name        VARCHAR2(50),
   card_job         VARCHAR2(200),
   card_phone       VARCHAR2(50),
   card_qq          VARCHAR2(50),
   card_addr        VARCHAR2(50),
   card_email       VARCHAR2(20),
   card_company     VARCHAR2(20),
   cardcase_id      NUMBER(6) REFERENCES  cardcase (cardcase_id)
);
CREATE SEQUENCE card_seq MAXVALUE 350000 INCREMENT BY 1 START WITH 300000;

-- 4.库存管理
-- 货物表
CREATE TABLE cargo (
   cargo_id         NUMBER(6) PRIMARY KEY,      -- 从400000开始
   cargo_name       VARCHAR2(20),
   cargo_desc   	VARCHAR2(20),
   cargo_price      NUMBER(6),
   cargo_num        NUMBER(6)
);
CREATE SEQUENCE cargo_seq MAXVALUE 450000 INCREMENT BY 1 START WITH 400000;

-- 5.车队管理
-- 车辆表
CREATE TABLE car (
    car_id          NUMBER(6) PRIMARY KEY,      -- 从450000开始
    car_type        VARCHAR2(20),
    car_num         VARCHAR2(20),
    car_photo       BLOB,
    car_status      VARCHAR2(20) check (car_status in ('free', 'busy'))
);
CREATE SEQUENCE car_seq MAXVALUE 500000 INCREMENT BY 1 START WITH 450000;

-- 租借记录表
CREATE TABLE rent (
    rent_id         NUMBER(6) PRIMARY KEY,                -- 从500000开始
    emp_id          NUMBER(6) REFERENCES  employee (emp_id),
    car_id          NUMBER(6) REFERENCES car (car_id),
    rent_path       VARCHAR2(50),
    rent_start      date,
    rent_end        date,
    rent_status     VARCHAR2(20) check (rent_status in ('finish', 'unfinished'))
);
CREATE SEQUENCE rent_seq MAXVALUE 550000 INCREMENT BY 1 START WITH 500000;

-- 6.公告管理
-- 公告表
CREATE TABLE notice (   
    notice_id       NUMBER(6)  PRIMARY KEY,     -- 从550000开始
    notice_title    VARCHAR2(50),
    notice_date     date,
    notice_desc     VARCHAR2(200)
);
CREATE SEQUENCE notice_seq MAXVALUE 600000 INCREMENT BY 1 START WITH 550000;

-- 7.外派人才管理
-- 人才表
CREATE TABLE personnel (
    personnel_id       NUMBER(6) PRIMARY KEY,   -- 从600000开始
    personnel_name     VARCHAR2(20),
    personnel_educt    VARCHAR2(50),
    personnel_skill    VARCHAR2(50),
    personnel_salary   NUMBER(10),
    personnel_status   VARCHAR2(20) check (personnel_status in ('free', 'busy'))
);
CREATE SEQUENCE personnel_seq MAXVALUE 650000 INCREMENT BY 1 START WITH 600000;

-- 合作公司表
CREATE TABLE company (
    company_id      NUMBER(6) PRIMARY KEY,      -- 从650000开始
    company_name    VARCHAR2(20),
    company_master  VARCHAR2(20),
    company_phone   VARCHAR2(50),
    company_qq      VARCHAR2(50),
    company_desc    VARCHAR2(50)
);
CREATE SEQUENCE company_seq MAXVALUE 700000 INCREMENT BY 1 START WITH 650000;

-- 外派记录表
CREATE TABLE expatriate (
    expatriate_id   		NUMBER(6) PRIMARY KEY,    -- 从700000开始
    personnel_id    		NUMBER(6) REFERENCES personnel (personnel_id),
    company_id      		NUMBER(6) REFERENCES company (company_id),
    expatriate_start    	date,
    expatriate_end      	date,
    company_request 		VARCHAR2(50),
    expatriate_status     	VARCHAR2(20) check (expatriate_status in ('finish', 'unfinished'))
);
CREATE SEQUENCE expatriate_seq MAXVALUE 750000 INCREMENT BY 1 START WITH 700000;

------------------------------------------------ 插入假数据，方便调试
declare i number;
begin i:=1;
while i<=10 loop
      -- 2.系统管理
      insert into department values (department_seq.nextval, '技术部'||i,'软件开发');
      
      insert into job values (job_seq.nextval, '程序员'||i,'软件开发');
      
      insert into employee values (employee_seq.nextval, 'tom'||i, '13012345678', to_date('1993-6-19','yyyy-mm-dd'),'123@gmail.com' , 12432, '123456', 100000+i-1, 150000+i-1);
      
      -- 3.名片管理
      insert into cardcase values (cardcase_seq.nextval, '分组'||i, 200000+i-1);
      
      insert into card values (card_seq.nextval, '张三'||i, 'asjdhk', '12345678910', '45613467', '中软国际', '45613467@qq.com', '中软国际', 250000+i-1);
      
      -- 4.库存管理
      insert into cargo values (cargo_seq.nextval, '货物'||i, '类型'||i, 5000, 50);
      
      -- 5.车队管理
      insert into car values (car_seq.nextval, '兰博基尼'||i, i, null, 'free');
       
      insert into rent values (rent_seq.nextval, 200000+i-1, 450000+i-1, 'asdafassa', to_date('1993-6-19','yyyy-mm-dd'),to_date('1993-6-19','yyyy-mm-dd'), 'finish');
      
      -- 6.公告管理
      insert into notice values (notice_seq.nextval, '明天放假'||i, to_date('2016-12-1','yyyy-mm-dd'), '明天放假明天放假明天放假');
      
      -- 7.外派人才管理
      insert into personnel values (personnel_seq.nextval, 'tom'||i, '大学', 'java', 5000, 'free');
      
      insert into company values (company_seq.nextval, '大连民族大学'||i, '小张', 12379812, 46512415, 'asdhjaksh');
      
      insert into expatriate values (expatriate_seq.nextval, 600000+i-1, 650000+i-1, to_date('1993-6-19','yyyy-mm-dd'), to_date('1993-6-19','yyyy-mm-dd'), 'java', 'finish');
      i:=i+1;
end loop;
end;
/

commit;
------------------------------------------------------