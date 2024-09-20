CREATE SCHEMA `teamproject01` DEFAULT CHARACTER SET utf8;
USE teamproject01;

CREATE TABLE accounts (
    account_no        INTEGER NOT NULL AUTO_INCREMENT,
    account_id        VARCHAR(50),
    account_password  VARCHAR(50),
    account_level     INTEGER,
    PRIMARY KEY (account_no)
);

CREATE TABLE cart_details (
    cart_detail_no  INTEGER NOT NULL AUTO_INCREMENT,
    cart_quantity   INTEGER,
    product_no      INTEGER NOT NULL,
    cart_no         INTEGER NOT NULL,
    PRIMARY KEY (cart_detail_no)
);

CREATE TABLE carts (
    cart_no    INTEGER NOT NULL AUTO_INCREMENT,
    member_no  INTEGER NOT NULL,
    PRIMARY KEY (cart_no)
);

CREATE UNIQUE INDEX carts__idx ON carts (member_no ASC);

CREATE TABLE categories (
    category_no    INTEGER NOT NULL AUTO_INCREMENT,
    category_name  VARCHAR(50),
    PRIMARY KEY (category_no)
);

CREATE TABLE inquiry_answer (
    inquiry_answer_no       INTEGER NOT NULL AUTO_INCREMENT,
    inquiry_no              INTEGER NOT NULL,
    seller_no               INTEGER NOT NULL,
    inquiry_answer_date     DATE,
    inquiry_answer_content  VARCHAR(2000),
    PRIMARY KEY (inquiry_answer_no)
);

CREATE TABLE inquiry_board (
    inquiry_no       INTEGER NOT NULL AUTO_INCREMENT,
    inquiry_title    VARCHAR(100),
    inquiry_content  VARCHAR(2000),
    inquiry_date     DATE,
    member_no        INTEGER NOT NULL,
    seller_no        INTEGER NOT NULL,
    PRIMARY KEY (inquiry_no)
);

CREATE TABLE likes (
    like_no  INTEGER NOT NULL AUTO_INCREMENT,
    like_count  INTEGER,
    member_no    INTEGER NOT NULL,
    PRIMARY KEY (like_no)
);

CREATE TABLE log (
    log_no      INTEGER NOT NULL AUTO_INCREMENT,
    log_date    DATE,
    account_no  INTEGER NOT NULL,
    PRIMARY KEY (log_no)
);

CREATE TABLE members (
    member_no      INTEGER NOT NULL AUTO_INCREMENT,
    member_name    VARCHAR(50),
    member_age     INTEGER,
    member_mobile  VARCHAR(50),
    account_no     INTEGER NOT NULL,
    member_address  VARCHAR(200),
    PRIMARY KEY (member_no)
);

CREATE UNIQUE INDEX members__idx ON members (account_no ASC);

CREATE TABLE order_details (
    order_detail_no  INTEGER NOT NULL AUTO_INCREMENT,
    order_quantity   INTEGER,
    order_price      INTEGER,
    order_no         INTEGER NOT NULL,
    product_no       INTEGER NOT NULL,
    PRIMARY KEY (order_detail_no)
);

CREATE TABLE orders (
    order_no    INTEGER NOT NULL AUTO_INCREMENT,
    order_date  DATE,
    member_no   INTEGER NOT NULL,
    PRIMARY KEY (order_no)
);

CREATE TABLE products (
    product_no    INTEGER NOT NULL AUTO_INCREMENT,
    product_name  VARCHAR(100),
    product_image VARCHAR(100),
    product_price INTEGER,
    category_no   INTEGER,
    seller_no     INTEGER NOT NULL,
    PRIMARY KEY (product_no)
);

CREATE TABLE review_board (
    review_no       INTEGER NOT NULL AUTO_INCREMENT,
    review_title    VARCHAR(100),
    review_content  VARCHAR(2000),
    review_date     DATE,
    member_no       INTEGER NOT NULL,
    seller_no       INTEGER NOT NULL,
    PRIMARY KEY (review_no)
);

CREATE TABLE sellers (
    seller_no      INTEGER NOT NULL AUTO_INCREMENT,
    account_no     INTEGER NOT NULL,
    brand_name     VARCHAR(50),
    seller_mobile  VARCHAR(50),
    PRIMARY KEY (seller_no)
);

CREATE UNIQUE INDEX sellers__idx ON sellers (account_no ASC);

ALTER TABLE cart_details ADD CONSTRAINT cart_details_carts_fk FOREIGN KEY (cart_no) REFERENCES carts (cart_no);
ALTER TABLE cart_details ADD CONSTRAINT cart_details_products_fk FOREIGN KEY (product_no) REFERENCES products (product_no);
ALTER TABLE carts ADD CONSTRAINT carts_members_fk FOREIGN KEY (member_no) REFERENCES members (member_no);
ALTER TABLE inquiry_answer ADD CONSTRAINT inquiry_answer_inquiry_board_fk FOREIGN KEY (inquiry_no) REFERENCES inquiry_board (inquiry_no);
ALTER TABLE inquiry_answer ADD CONSTRAINT inquiry_answer_sellers_fk FOREIGN KEY (seller_no) REFERENCES sellers (seller_no);
ALTER TABLE inquiry_board ADD CONSTRAINT inquiry_board_members_fk FOREIGN KEY (member_no) REFERENCES members (member_no);
ALTER TABLE inquiry_board ADD CONSTRAINT inquiry_board_sellers_fk FOREIGN KEY (seller_no) REFERENCES sellers (seller_no);
ALTER TABLE likes ADD CONSTRAINT likes_members_fk FOREIGN KEY (member_no) REFERENCES members (member_no);
ALTER TABLE log ADD CONSTRAINT log_accounts_fk FOREIGN KEY (account_no) REFERENCES accounts (account_no);
ALTER TABLE members ADD CONSTRAINT members_accounts_fk FOREIGN KEY (account_no) REFERENCES accounts (account_no);
ALTER TABLE order_details ADD CONSTRAINT order_details_orders_fk FOREIGN KEY (order_no) REFERENCES orders (order_no);
ALTER TABLE order_details ADD CONSTRAINT order_details_products_fk FOREIGN KEY (product_no) REFERENCES products (product_no);
ALTER TABLE orders ADD CONSTRAINT orders_members_fk FOREIGN KEY (member_no) REFERENCES members (member_no);
ALTER TABLE products ADD CONSTRAINT products_categories_fk FOREIGN KEY (category_no) REFERENCES categories (category_no);
ALTER TABLE products ADD CONSTRAINT products_sellers_fk FOREIGN KEY (seller_no) REFERENCES sellers (seller_no);
ALTER TABLE review_board ADD CONSTRAINT review_board_members_fk FOREIGN KEY (member_no) REFERENCES members (member_no);
ALTER TABLE review_board ADD CONSTRAINT review_board_sellers_fk FOREIGN KEY (seller_no) REFERENCES sellers (seller_no);
ALTER TABLE sellers ADD CONSTRAINT sellers_accounts_fk FOREIGN KEY (account_no) REFERENCES accounts (account_no);

ALTER TABLE likes
ADD COLUMN product_no INTEGER NOT NULL;

ALTER TABLE likes
ADD CONSTRAINT fk_likes_product
FOREIGN KEY (product_no) REFERENCES products(product_no)
ON DELETE CASCADE; 

ALTER TABLE likes DROP COLUMN like_count;

-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                            14
-- CREATE INDEX                             3
-- ALTER TABLE                             33
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0

use teamproject01;

# 카테고리
INSERT INTO CATEGORIES VALUES (1, '상의');
INSERT INTO CATEGORIES VALUES (2, '하의');
INSERT INTO CATEGORIES VALUES (3, '아우터');
INSERT INTO CATEGORIES VALUES (4, '신발');

# 계정 더미데이터(판매자)
INSERT INTO ACCOUNTS VALUES(1,'NIKE','NIKE',2);
INSERT INTO ACCOUNTS VALUES(2,'ADIDAS','ADIDAS',2);
INSERT INTO ACCOUNTS VALUES(3,'POLO','POLO',2);
INSERT INTO ACCOUNTS VALUES(4,'MATINKIM','MATINKIM',2);
INSERT INTO ACCOUNTS VALUES(5,'STUSSY','STUSSY',2);

# 계정 더미데이터(일반회원)
INSERT INTO ACCOUNTS VALUES(6,'wjdwndkdlel','wjdwnqlqjs',1);
INSERT INTO ACCOUNTS VALUES(7,'wlghksdkdlel','wlghksqlqjs',1);
INSERT INTO ACCOUNTS VALUES(8,'dbwlsdkdlel','dbwlsqlqjs',1);
INSERT INTO ACCOUNTS VALUES(9,'alswjddkdlel','alswjdqlqjs',1);

# 판매자 더미데이터
INSERT INTO SELLERS VALUES(1, 1, '나이키', '010-1111-1111');
INSERT INTO SELLERS VALUES(2, 2, '아디다스', '010-2222-2222');
INSERT INTO SELLERS VALUES(3, 3, '폴로', '010-3333-3333');
INSERT INTO SELLERS VALUES(4, 4, '마뗑킴', '010-4444-4444');
INSERT INTO SELLERS VALUES(5, 5, '스투시', '010-5555-5555');

#일반회원 더미데이터
INSERT INTO MEMBERS VALUES(6, '박정주', 27, '010-2601-2640', 6, '경기도 파주시');
INSERT INTO MEMBERS VALUES(7, '황지환', 28, '010-2201-8695', 7, '경기도 의정부시');
INSERT INTO MEMBERS VALUES(8, '김유진', 27, '010-4159-5682', 8, '경기도 시흥시');
INSERT INTO MEMBERS VALUES(9, '김민정', 25, '010-5265-6310', 9, '대구광역시');

# 상품 더미데이터
INSERT INTO PRODUCTS VALUES (1, '여성 반팔 폴로', 'top01.png',85000, 1, 1);
INSERT INTO PRODUCTS VALUES (2, '나이키 스포츠웨어 칠 니트', 'top02.png', 59000, 1, 1);
INSERT INTO PRODUCTS VALUES (3, '여성 오버 오버사이즈 크루넥 로고 스웻셔츠', 'top03.png',109000, 1, 1);
INSERT INTO PRODUCTS VALUES (4, '아디다스 브이넥 롱슬리브 티셔츠 블랙', 'top04.png',85000, 1, 2);
INSERT INTO PRODUCTS VALUES (5, '아디다스 삼선 사틴 롱슬리브 티셔츠 블랙', 'top05.png',104000, 1, 2);
INSERT INTO PRODUCTS VALUES (6, '아디다스 x 웨일스 보너 타월 롱 슬리브 다크 브라운', 'top06.png',260000, 1, 2);
INSERT INTO PRODUCTS VALUES (7, '폴로 랄프 로렌 아이코닉 럭비 셔츠 아틱 옐로우- 24FW', 'top07.png',239000, 1, 3);
INSERT INTO PRODUCTS VALUES (8, '폴로 랄프 로렌 폴로 베어 플리스 후디 그레이 - 24FW', 'top08.png',279000, 1, 3);
INSERT INTO PRODUCTS VALUES (9, '폴로 랄프 로렌 폴로 베어 울 캐시미어 스웨터 네이비 - 24FW', 'top09.png', 699000, 1, 3);
INSERT INTO PRODUCTS VALUES (10, '마뗑킴 스티치 브이넥 슬림 탑 라이트 브라운', 'top10.png',108000, 1, 4);
INSERT INTO PRODUCTS VALUES (11, '마뗑킴 스티치 브이넥 슬림 탑 차콜', 'top11.png',108000, 1, 4);
INSERT INTO PRODUCTS VALUES (12, '마뗑킴 스티치 브이넥 슬림 탑 라이트 옐로우', 'top12.png', 108000, 1, 4);
INSERT INTO PRODUCTS VALUES (13, '스투시 베이직 스투시 롱슬리브 티셔츠 블랙 2024', 'top13.png',109000, 1, 5);
INSERT INTO PRODUCTS VALUES (14, '스투시 월드투어 롱슬리브 티셔츠 화이트 2024', 'top14.png', 85000, 1, 5);
INSERT INTO PRODUCTS VALUES (15, '스투시 베이직 스투시 피그먼트 다이드 롱슬리브 티셔츠 브라운 2024', 'top15.png', 126000, 1, 5);
INSERT INTO PRODUCTS VALUES(16, 'Nike Dri-Fit Challenger Woven Pants Black', 'bottom01.png', 66000, 2, 1);
INSERT INTO PRODUCTS VALUES(17, 'Nike ACG Snowgrass Cargo Shorts Black', 'bottom02.png', 72000, 2, 1);
INSERT INTO PRODUCTS VALUES(18, 'Nike Court Dri-Fit Victory Skirt Black', 'bottom03.png', 68000, 2, 1);
INSERT INTO PRODUCTS VALUES(19, 'Adidas Camo Parachute Pants Black Trace Grey', 'bottom04.png', 129000, 2, 2);
INSERT INTO PRODUCTS VALUES(20, 'Adidas Adicolor Classic Waffle Beckenbauer Track Pants Wonder White ', 'bottom05.png', 159000, 2, 2);
INSERT INTO PRODUCTS VALUES(21, 'Adidas Cargo Pants Black', 'bottom06.png', 216000, 2, 2);
INSERT INTO PRODUCTS VALUES(22, 'Polo Ralph Lauren Parkside Active Taper Selvage Jean Whitford', 'bottom07.png', 399000, 2, 3);
INSERT INTO PRODUCTS VALUES(23, 'Polo Ralph Lauren Vintage Fleece Sweatpants White', 'bottom08.png', 349000, 2, 3);
INSERT INTO PRODUCTS VALUES(24, 'Polo Ralph Lauren for KREAM String Sweatpant Grey', 'bottom09.png', 259000, 2, 3);
INSERT INTO PRODUCTS VALUES(25, 'Matin Kim Patchwork Washed Denim Pants Light Blue', 'bottom10.png', 232000, 2, 4);
INSERT INTO PRODUCTS VALUES(26, 'Matin Kim Patchwork Washed Denim Pants Blue', 'bottom11.png', 232000, 2, 4 );
INSERT INTO PRODUCTS VALUES(27, 'Matin Kim Button Roll Up Double Knee Pants Mint', 'bottom12.png', 211000, 2, 4);
INSERT INTO PRODUCTS VALUES(28, 'Stussy Stock Water Pigment Short Charcoal', 'bottom13.png', 130000, 2, 5);
INSERT INTO PRODUCTS VALUES(29, 'Stussy x Levis Crispy Rinse 568 Jean Black', 'bottom14.png', 440000, 2, 5);
INSERT INTO PRODUCTS VALUES(30, 'Stussy Ripstop Cargo Beach Pants Black', 'bottom15.png', 200000, 2, 5);
insert into products values (31, 'TCM stripe hooded zip-up (charcoal/black)', 'outer01.png', 107100, 3, 1);
insert into products values (32, '파이어버드 트랙탑-미드그린', 'outer02.png', 95000, 3, 2);
insert into products values (33, '져지 트랙 자켓 아이보리', 'outer03.png', 54900, 3, 3);
insert into products values (34, '빈티지 워크 자켓_차콜', 'outer04.png', 89000, 3, 4);
insert into products values (35, '98 Patch Velour Zip-Up Hoodie', 'outer05.png', 139500, 3, 5);
insert into products values (36, '비숍 울 알파카 크루넥 가디건 진저 브라운', 'outer06.png', 124100, 3, 1);
insert into products values (37, '무톤 디바이드 바이커 자켓_Suede Brown', 'outer07.png', 84000, 3, 2);
insert into products values (38, '배색 골덴 카라 바버 헌팅 트러커 자켓 점퍼', 'outer08.png', 58100, 3, 3);
insert into products values (39, '아톰 후디 남성 - BLACK', 'outer09.png', 450000, 3, 4);
insert into products values (40, '오버 다잉 페이디드 데미지 워크 자켓 (워시드블랙)', 'outer10.png', 256500, 3, 5);
insert into products values (41, '워시드 데님 로드 바이커 자켓 INDIGO', 'outer11.png', 149000, 3, 1);
insert into products values (42, 'BOUTIQUE LEATHER JACKET (BLACK)', 'outer12.png', 197100, 3, 2);
insert into products values (43, '져지 트랙 자켓 네이비', 'outer13.png', 54900, 3, 3);
insert into products values (44, 'RAGLAN TRACK JERSEY JACKET', 'outer14.png', 44500, 3, 4);
insert into products values (45, '베지터블 레더 A-2 자켓 (브라운)', 'outer15.png', 472500, 3, 5);
INSERT INTO PRODUCTS VALUES(46, '덩크 로우 W - 화이트:포톤 더스트 / DD1503-103', 'shoes01.png', 111200, 4, 1);
INSERT INTO PRODUCTS VALUES(47, '코르테즈 텍스타일 W - 블랙:다크 스모크 그레이', 'shoes02.png', 83300, 4, 1);
INSERT INTO PRODUCTS VALUES(48, '코르테즈 M', 'shoes03.png', 139000, 4, 1);
INSERT INTO PRODUCTS VALUES(49, '핸드볼 스페지알 - 핑크', 'shoes04.png', 49900, 4, 2);
INSERT INTO PRODUCTS VALUES(50, 'YEEZY BOOST 350 V2', 'shoes05.png', 133200, 4, 2);
INSERT INTO PRODUCTS VALUES(51, '가젤 인도어 - 네이비:핑크', 'shoes06.png', 121200, 4, 2);
INSERT INTO PRODUCTS VALUES(52, '롱우드 레더 스니커즈', 'shoes07.png', 144200, 4, 3);
INSERT INTO PRODUCTS VALUES(53, '마스터즈 코트 레더 스니커즈', 'shoes08.png', 89200, 4, 3);
INSERT INTO PRODUCTS VALUES(54, '마스터즈 코트 레더 스니커즈-네이비', 'shoes09.png', 76200, 4, 3);
INSERT INTO PRODUCTS VALUES(55, 'CRACK LEATHER SNEAKERS IN WHITE', 'shoes10.png', 178000, 4, 4);
INSERT INTO PRODUCTS VALUES(56, 'PADDED ROUND BLOAFER IN BLACK', 'shoes11.png', 168000, 4, 4);
INSERT INTO PRODUCTS VALUES(57, 'MATIN SQUARE LONG BOOTS IN BROWN', 'shoes12.png', 98200, 4, 4);
INSERT INTO PRODUCTS VALUES(58, '마들렌', 'shoes13.png', 142000, 4, 5);
INSERT INTO PRODUCTS VALUES(59, '스틱 러기드', 'shoes14.png', 164000, 4, 5);
INSERT INTO PRODUCTS VALUES(60, '심볼 스니커즈', 'shoes15.png', 98700, 4, 5);

insert into orders values(1, now(), 8);
insert into order_details values(1, 1, 85000, 1, 1);


use teamproject01;
select * from members;

select * from sellers;
select * from inquiry_board;
select * from sellers;
select*from accounts;


INSERT INTO inquiry_board (inquiry_title, inquiry_content, inquiry_date, member_no, seller_no)
VALUES ('상품 문의', '이 상품은 언제 입고되나요?', NOW(), 6, 1);

SELECT a.account_id
FROM accounts a
JOIN members m ON m.account_no = a.account_no
WHERE m.member_name = '박정주'
AND m.member_mobile = '010-2601-2640';
INSERT INTO inquiry_board(inquiry_title, inquiry_content, inquiry_date, member_no, seller_no)
VALUES ('2', '2', NOW(), 
       (SELECT member_no FROM members WHERE member_no = 6), 
       (SELECT seller_no FROM sellers WHERE seller_no = 1));