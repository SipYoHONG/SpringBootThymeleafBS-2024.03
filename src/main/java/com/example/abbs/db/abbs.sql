SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS likes;
DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS nReply;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE board
(
	bid int NOT NULL AUTO_INCREMENT,
	title varchar(256) NOT NULL,
	content varchar(4000),
	uid varchar(12) NOT NULL,
	modTime datetime DEFAULT CURRENT_TIMESTAMP,
	isDeleted int DEFAULT 0,
	category varchar(30) NOT NULL,
	foodName varchar(30) NOT NULL,
	openClosed varchar(30) NOT NULL,
	address varchar(250) NOT NULL,
	phoneNumber varchar(15) NOT NULL,
	titleImage varchar(40) NOT NULL,
	PRIMARY KEY (bid)
);


CREATE TABLE likes
(
	lid int NOT NULL AUTO_INCREMENT,
	uid varchar(12) NOT NULL,
	bid int NOT NULL,
	value int DEFAULT 0,
	PRIMARY KEY (lid)
);


CREATE TABLE reply
(
	rid int NOT NULL AUTO_INCREMENT,
	comment varchar(256) NOT NULL,
	regTime datetime DEFAULT CURRENT_TIMESTAMP,
	uid varchar(12) NOT NULL,
	bid int NOT NULL,
	isMine int DEFAULT 0,
	isDeleted int DEFAULT 0,
	PRIMARY KEY (rid)
);


CREATE TABLE nReply
(
	ri2d int NOT NULL AUTO_INCREMENT,
	comment varchar(256) NOT NULL,
	regTime datetime DEFAULT CURRENT_TIMESTAMP,
	uid varchar(12) NOT NULL,
	bid int NOT NULL,
	isMine int DEFAULT 0,
	isDeleted int DEFAULT 0,
	PRIMARY KEY (ri2d)
);


CREATE TABLE users
(
	uid varchar(12) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar(16) NOT NULL,
	email varchar(32),
	regDate date DEFAULT (CURRENT_DATE),
	isDeleted int DEFAULT 0,
	PRIMARY KEY (uid)
);



/* Create Foreign Keys */

ALTER TABLE likes
	ADD FOREIGN KEY (bid)
	REFERENCES board (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE reply
	ADD FOREIGN KEY (bid)
	REFERENCES board (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE board
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE likes
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE reply
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE nReply
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


