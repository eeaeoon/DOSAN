create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

-- 그룹/조직/부서 구조도
CREATE TABLE CIP_ORGANIZATION
(
	-- 조직 일련번호
	ORGANIZATION_SEQ varchar(50) NOT NULL COMMENT '조직 일련번호',
	-- 명칭
	NAME varchar(1000) NOT NULL COMMENT '명칭',
	-- 대표 전화번호
	TELEPHONE varchar(40) COMMENT '대표 전화번호',
	-- 정렬순서
	ORDER_NUMBER decimal COMMENT '정렬순서',
	-- 상위 조직 일련번호
	PARENT_ORGANIZATION_SEQ varchar(50) COMMENT '상위 조직 일련번호',
	CONSTRAINT PK_ORGANIZATION PRIMARY KEY (ORGANIZATION_SEQ)
) COMMENT = '그룹/조직/부서 구조도';

-- 계좌 테이블
CREATE TABLE ACCOUNT
(
    NAME VARCHAR(45)    NOT NULL    COMMENT '회원이름', 
    VALUE        DOUBLE         NOT NULL    COMMENT '잔액', 
    ACCOUNT_NUM  VARCHAR(45)    NOT NULL    COMMENT '계좌번호', 
    BANK_NAME    VARCHAR(45)    NOT NULL    COMMENT '은행이름', 
    PRIMARY KEY (ACCOUNT_NUM)
);


-- 입출금내역 테이블
CREATE TABLE INOUT
(
    ACCOUNT_NUM  VARCHAR(45)    NOT NULL    COMMENT '계좌번호',
    OTHER_NUM    VARCHAR(45)    NOT NULL        COMMENT '상대방계좌번호',
    OTHER_BANK   VARCHAR(45)    NOT NULL    COMMENT '상대방은행',
    OTHER_NAME   VARCHAR(45)    NOT NULL    COMMENT '상대방이름',
    VALUE        DOUBLE         NOT NULL        COMMENT '송금금액',
    DATE         DATE           NOT NULL        COMMENT '보낸날짜',
    PRIMARY KEY (ACCOUNT_NUM)
);

ALTER TABLE INOUT
    ADD CONSTRAINT FK_INOUT_ACCOUNT_NUM_ACCOUNT_ACCOUNT_NUM FOREIGN KEY (ACCOUNT_NUM)
        REFERENCES ACCOUNT (ACCOUNT_NUM) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- 상품 테이블
CREATE TABLE PRODUCT
(
    NAME       VARCHAR(45)    NOT NULL    COMMENT '회원이름',
    PRODUCT  VARCHAR(45)    NOT NULL    COMMENT '상품',
    DATE     DATE           NOT NULL    COMMENT '날짜',
    PRIMARY KEY (NAME)
);